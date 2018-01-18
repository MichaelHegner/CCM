package net.hemisoft.ccm.porter

import static org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.PollableChannel
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

import net.hemisoft.ccm.stub.BitCoinStub

@RunWith(SpringRunner)
@SpringBootTest
@ContextConfiguration("flow/_restapi.xml")
class CoinMarketCapRestITTest {
	@Autowired @Qualifier("coinmarketcap.request.channel") 
	MessageChannel requestChannel
	
	@Autowired @Qualifier("coinmarketcap.income.channel") 
	MessageChannel incomeChannel
	
	@Test
	public void test() {
		def request = MessageBuilder.withPayload("").build()
		assert true == requestChannel.send(request)
		
		def response = incomeChannel.receive(10000)		
		assert response != null
		
		def responseGetPayload = response.getPayload()
		assert responseGetPayload != null
		assert responseGetPayload.getClass() == Coins
		assert responseGetPayload.size() > 0
		
		responseGetPayload.forEach({ if(it.rank == 1) BitCoinStub.assertCoinAttributeValuesNotNull(it) })
	}

}
