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
import net.hemisoft.ccm.porter.cryptocompare.Coin
import net.hemisoft.ccm.stub.cryptocompare.BitCoinStub
import net.hemisoft.ccm.stub.cryptocompare.CoinOnMarketPlaceStub

@RunWith(SpringRunner)
@SpringBootTest
@ContextConfiguration(locations= ["../porter/porterapi.xml", "flow/_cryptocompare.xml"])
public class CryptoCompare2CoinTransformerTest {
	@Autowired @Qualifier("cryptocompare.subscribe.channel")
	PublishSubscribeChannel subscribeChannel
	
	@Autowired @Qualifier("cryptocompare.transformation.outcome.channel")
	PollableChannel incomeChannel
	
	@Test
	public void test() {
		def messageBuilder = MessageBuilder.withPayload BitCoinStub.create()
		messageBuilder.setHeader "marketName", "cryptoCompare"
		def request = messageBuilder.build()
		assert subscribeChannel.send(request) == true
		
		def responseMessage = incomeChannel.receive(2000)
		assert responseMessage != null
		assert responseMessage.getPayload() != null
		assert responseMessage.getPayload().getClass() == CoinOnMarketPlace
		
		def response = responseMessage.getPayload()
		CoinOnMarketPlaceStub.assertBitcoinValues(response)
	}

}
