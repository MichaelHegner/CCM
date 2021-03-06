package net.hemisoft.ccm.porter.cryptocompare

import static java.util.concurrent.TimeUnit.SECONDS
import static org.junit.Assert.*

import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicReference

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.channel.PublishSubscribeChannel
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.MessageHandler
import org.springframework.messaging.MessagingException
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

import net.hemisoft.ccm.stub.cryptocompare.BitCoinStub

@RunWith(SpringRunner)
@SpringBootTest
@ContextConfiguration("cryptocompare-api.xml")
class CryptoComparePorterITTest {
	@Autowired @Qualifier("cryptocompare.request.channel")
	MessageChannel requestChannel
	
	@Autowired @Qualifier("cryptocompare.subscribe.channel") 
	PublishSubscribeChannel subcscribeChannel
	
	@Test
	public void test() {
		def messageReference = new AtomicReference<>()
		def latch = new CountDownLatch(1)
		
		def responseCoins = []
		assert true == subcscribeChannel.subscribe(new MessageHandler() {
			void handleMessage(Message<?> message) throws MessagingException {
				responseCoins.add message.getPayload()
				latch.countDown()
			}
		})
		
		def request = MessageBuilder.withPayload("").build()
		assert true == requestChannel.send(request)
		
		latch.await 10, SECONDS
		assert responseCoins != null
		BitCoinStub.assertCoinAttributeValuesNotNull responseCoins[0]
	}
}
