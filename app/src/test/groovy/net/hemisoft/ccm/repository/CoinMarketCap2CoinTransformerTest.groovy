package net.hemisoft.ccm.repository

import static org.assertj.core.api.Assertions.assertThat

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.integration.channel.PublishSubscribeChannel
import org.springframework.messaging.Message
import org.springframework.messaging.PollableChannel
import org.springframework.messaging.support.MessageBuilder
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.porter.coinmarketcap.Coin
import net.hemisoft.ccm.stub.coinmarketcap.BitCoinStub
import net.hemisoft.ccm.stub.coinmarketcap.CoinOnMarketPlaceStub

@RunWith(SpringRunner)
@SpringBootTest
@ContextConfiguration(locations= ["../porter/porterapi.xml", "flow/_coinmarketcap.xml"])
public class CoinMarketCap2CoinTransformerTest {
	@Autowired @Qualifier("coinmarketcap.subscribe.channel")
	PublishSubscribeChannel subscribeChannel
	
	@Autowired @Qualifier("coinmarketcap.transformation.outcome.channel")
	PollableChannel incomeChannel
	
	@Test
	public void test() {
		def messageBuilder = MessageBuilder.withPayload BitCoinStub.create()
		messageBuilder.setHeader "marketName", "coinMarketCap"
		def request = messageBuilder.build()
		assert subscribeChannel.send(request) == true
		
		def responseMessage = incomeChannel.receive(2000)
		assert null != responseMessage
		assert null != responseMessage.getPayload()
		assert CoinOnMarketPlace == responseMessage.getPayload().getClass()
		
		def response = responseMessage.getPayload()
		CoinOnMarketPlaceStub.assertBitcoinValues response
	}

}
