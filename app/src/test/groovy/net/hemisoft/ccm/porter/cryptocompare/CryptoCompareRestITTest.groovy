package net.hemisoft.ccm.porter.cryptocompare

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
class CryptoCompareRestITTest {
	@Autowired @Qualifier("cryptocompare.request.channel") 
	MessageChannel requestChannel
	
	@Autowired @Qualifier("cryptocompare.income.channel") 
	QueueChannel incomeChannel
	
	@Test
	public void test() {
		def request = MessageBuilder.withPayload("").build()
		assert true == requestChannel.send(request)
		
		def response
		while(response = incomeChannel.receive 10000) {
			assert response != null
			def responseGetPayload = response.getPayload()
			assert responseGetPayload != null
			assert responseGetPayload.getClass() == Coin
			assertCoinAttributeValuesNotNull(responseGetPayload)
		} 
	}

	void assertCoinAttributeValuesNotNull(Coin coin) {
		assert null != coin.coinId
		assert null != coin.name
		assert null != coin.symbol
		assert null != coin.rank
		assert null != coin.priceUSD
		assert null != coin.priceBTC
		assert null != coin.volume24hUSD
		assert null != coin.marketCapUSD
		assert null != coin.availableSupply
		assert null != coin.changePercent24h
		assert null != coin.lastUpdateEpoch
	}
}
