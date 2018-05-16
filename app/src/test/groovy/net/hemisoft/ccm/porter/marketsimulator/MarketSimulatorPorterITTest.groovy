package net.hemisoft.ccm.porter.marketsimulator

import static java.util.concurrent.TimeUnit.SECONDS
import static org.junit.Assert.*

import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicReference

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.integration.channel.PublishSubscribeChannel
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.MessageHandler
import org.springframework.messaging.MessagingException
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner)
@SpringBootTest
@ContextConfiguration("marketsimulator-api.xml")
class MarketSimulatorPorterITTest {
	@Autowired @Qualifier("marketsimulator.request.channel")
	MessageChannel requestChannel
	
	@Autowired @Qualifier("marketsimulator.subscribe.channel") 
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
		assert responseCoins.size() > 0
	}
}
