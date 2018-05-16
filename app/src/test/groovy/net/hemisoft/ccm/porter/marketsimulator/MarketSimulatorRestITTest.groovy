package net.hemisoft.ccm.porter.marketsimulator

import static org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.integration.channel.QueueChannel
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.MessageChannel
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner)
@SpringBootTest
@ContextConfiguration("flow/_restapi.xml")
class MarketSimulatorRestITTest {
	@Autowired @Qualifier("marketsimulator.request.channel") 
	MessageChannel requestChannel
	
	@Autowired @Qualifier("marketsimulator.income.channel") 
	QueueChannel incomeChannel
	
	@Test
	public void test() {
		def request = MessageBuilder.withPayload("").build()
		assert true == requestChannel.send(request)
		
		def response = incomeChannel.receive 10000		
		assert response != null
		
		def responseGetPayload = response.getPayload()
		assert responseGetPayload != null
		assert responseGetPayload.getClass() == ArrayList
		assert responseGetPayload.size() == 3
	}

}
