package net.hemisoft.ccm.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import net.hemisoft.ccm.domain.CoinOnMarketPlace;
import net.hemisoft.ccm.porter.Coin;
import net.hemisoft.ccm.stub.CoinStub;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(locations= {"../porter/porterapi.xml", "flow/_coinmarketcap.xml"})
public class CoinMarketCap2CoinTransformerTest {
	@Autowired @Qualifier("coinmarketcap.subscribe.channel")
	PublishSubscribeChannel subscribeChannel;
	
	@Autowired @Qualifier("coinmarketcap.transformation.outcome.channel")
	PollableChannel incomeChannel;
	
	@Test
	public void test() {
		Coin coin = CoinStub.create();
		Message<?> request = MessageBuilder.withPayload(coin).build();
		assertThat(subscribeChannel.send(request)).isTrue();
		
		Message<?> responseMessage = incomeChannel.receive(2000);
		assertThat(responseMessage).isNotNull();
		
		assertThat(responseMessage.getPayload()).isNotNull();
		assertThat(responseMessage.getPayload()).isInstanceOf(CoinOnMarketPlace.class);
		
		CoinOnMarketPlace response = (CoinOnMarketPlace) responseMessage.getPayload();
		CoinOnMarketPlaceStub.assertAttributeValues(response);
	}

}
