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

@RunWith(SpringRunner)
@SpringBootTest
@ContextConfiguration("porter.xml")
class CoinMarketCapTest {
	@Autowired @Qualifier("coinmarketcap.info.channel") 
	PollableChannel coinmarketcapinfoChannel
	
	@Autowired @Qualifier("coinmarketcap.subscribe.channel") 
	MessageChannel coinmarketcapIncomeChannel
	
	@Test
	public void test() {
		def request = MessageBuilder.withPayload("").build()
		coinmarketcapIncomeChannel.send(request)
		def response = coinmarketcapinfoChannel.receive()		
		
		response.getPayload().forEach({
			println it
			assert it.coinId != null	
			assert it.name != null
			assert it.symbol != null
			assert it.rank != null
			assert it.priceUSD != null
			assert it.priceBTC != null
			assert it.volume24hUSD != null
			assert it.marketCapUSD != null
			assert it.availableSupply != null
			assert it.totalSupply != null
			assert it.changePercent1h != null
			assert it.changePercent24h != null
			assert it.changePercent7d != null
			assert it.lastUpdate != null
		})
	}

}
