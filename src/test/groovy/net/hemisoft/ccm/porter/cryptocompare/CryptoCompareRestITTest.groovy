package net.hemisoft.ccm.porter.cryptocompare

import static org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
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
	MessageChannel incomeChannel
	
	@Test
	public void test() {
		def request = MessageBuilder.withPayload("").build()
		assert true == requestChannel.send(request)
		
		def response = incomeChannel.receive 10000		
		assert response != null
		
		def responseGetPayload = response.getPayload()
		assert responseGetPayload != null
		assert responseGetPayload.getClass() == Coin
		assertCoinAttributeValuesNotNull(responseGetPayload)
	}

	void assertCoinAttributeValuesNotNull(Coin coin) {
		assert coin.coinId 				!= null
		assert coin.name 				!= null
		assert coin.symbol 				!= null
		assert coin.rank 				!= null
		assert coin.priceUSD			!= null
		assert coin.priceBTC			!= null
	}
}
