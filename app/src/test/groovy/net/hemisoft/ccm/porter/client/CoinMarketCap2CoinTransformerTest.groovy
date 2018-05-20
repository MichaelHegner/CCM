package net.hemisoft.ccm.porter.client

import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicReference

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.integration.channel.DirectChannel
import org.springframework.integration.channel.PublishSubscribeChannel
import org.springframework.messaging.Message
import org.springframework.messaging.MessageHandler
import org.springframework.messaging.MessagingException
import org.springframework.messaging.support.MessageBuilder
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.stub.coinmarketcap.BitCoinStub

@RunWith(SpringRunner)
@SpringBootTest
@ContextConfiguration(locations= ["../porterapi.xml", "flow/_coinmarketcap.xml"])
public class CoinMarketCap2CoinTransformerTest {
	@Autowired @Qualifier("coinmarketcap.subscribe.channel")
	PublishSubscribeChannel subscribeChannel
	
	@Autowired @Qualifier("coinmarketcap.transformation.outcome.channel")
	DirectChannel outputChannel
	
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
		messageBuilder.setHeader "marketName", "coinMarketCap"
		def request = messageBuilder.build()
		assert true == subscribeChannel.send(request)
		
		def responseMessage 		 = messageReference.get()
		assert null 				!= responseMessage
		assert null 				!= responseMessage.getPayload()
		assert CoinOnMarketPlace 	== responseMessage.getPayload().getClass()
		
		def response = responseMessage.getPayload()
		BitCoinStub.assertBitcoinValues response
	}

}
