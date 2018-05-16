package net.hemisoft.ccm.porter.marketsimulator

import static java.util.concurrent.TimeUnit.SECONDS
import static org.junit.Assert.*

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicReference

import org.junit.Before
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
import org.springframework.messaging.PollableChannel
import org.springframework.messaging.support.MessageBuilder
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

import net.hemisoft.ccm.porter.marketsimulator.Coin

@RunWith(SpringRunner)
@SpringBootTest
@ContextConfiguration("flow/_splitter.xml")
class MarketSimulatorSplitterTest {
	@Autowired @Qualifier("marketsimulator.response.channel") 
	DirectChannel incomeChannel
	
	@Autowired @Qualifier("marketsimulator.output.channel") 
	DirectChannel outputChannel
	
	@Test
	public void test() {
		List coins = [MarketSimulator.newInstance().btc]
		AtomicReference<Message<?>> messageReference = new AtomicReference<>()
		CountDownLatch latch = new CountDownLatch(1)
		
		assert true == outputChannel.subscribe(new MessageHandler() {
			void handleMessage(Message<?> message) throws MessagingException {
				messageReference.set message
				latch.countDown()
			}
		})
		
		def request = MessageBuilder.withPayload(coins).build()
		assert incomeChannel.send(request) == true
		latch.await 10, SECONDS
		
		def responseMessage = messageReference.get()
		def response = responseMessage.getPayload()
		assert response != null
		assert response.getClass() == Coin
		assert response.coinId == "btc"
	}
}
