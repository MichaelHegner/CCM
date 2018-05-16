package net.hemisoft.ccm.porter.cryptocompare

import static java.util.concurrent.TimeUnit.SECONDS
import static org.junit.Assert.*

import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicReference

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.integration.channel.DirectChannel
import org.springframework.messaging.Message
import org.springframework.messaging.MessageHandler
import org.springframework.messaging.MessagingException
import org.springframework.messaging.support.MessageBuilder
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

import net.hemisoft.ccm.stub.cryptocompare.BitCoinStub

@RunWith(SpringRunner)
@SpringBootTest
@ContextConfiguration("flow/_splitter.xml")
class CryptoCompareSplitterTest {
	@Autowired @Qualifier("cryptocompare.response.channel") 
	DirectChannel incomeChannel
	
	@Autowired @Qualifier("cryptocompare.output.channel") 
	DirectChannel outputChannel
	
	Coin coin
	
	@Before
	public void before() {
		coin = BitCoinStub.create()
	}
	
	@Test
	public void test() {
		AtomicReference<Message<?>> messageReference = new AtomicReference<>()
		CountDownLatch latch = new CountDownLatch(1)
		
		assert true == outputChannel.subscribe(new MessageHandler() {
			void handleMessage(Message<?> message) throws MessagingException {
				messageReference.set message
				latch.countDown()
			}
		})
		
		def messageBuilder = MessageBuilder.withPayload BitCoinStub.create()
		def request = messageBuilder.build()
		assert incomeChannel.send(request) == true
		latch.await 10, SECONDS
		
		def responseMessage = messageReference.get()
		def response = responseMessage.getPayload()
		assert response != null
		assert response.getClass() == Coin
		BitCoinStub.assertAttributeValues response
	}
}
