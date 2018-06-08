package net.hemisoft.ccm.backend.repository

import static org.assertj.core.api.Assertions.assertThat
import static org.junit.Assert.*

import java.util.concurrent.CountDownLatch

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.MessageChannel
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

import net.hemisoft.ccm.backend.BackendConfig
import net.hemisoft.ccm.backend.repository.stub.CoinOnMarketPlaceStub
import net.hemisoft.ccm.backend.service.CoinOnMarketPlaceService



@RunWith(SpringRunner)
@DataJpaTest
@ContextConfiguration(classes=BackendConfig)
class CoinMarketCapRepositoryITTest {
	@Autowired @Qualifier("repository.income.channel")
	MessageChannel requestChannel
	
	@Autowired
	CoinOnMarketPlaceService coinOnMarketPlaceService
	
	@Test
	public void test() {
		def latch = CountDownLatch.newInstance(2)
		
		def bitCoin = CoinOnMarketPlaceStub.createBitCoin()
		def ethCoin = CoinOnMarketPlaceStub.createEthereumCoin()
		
		assert true == requestChannel.send(MessageBuilder.withPayload(bitCoin).build(), 1000)
		assert true == requestChannel.send(MessageBuilder.withPayload(ethCoin).build(), 1000)
		
		def responseCoins = coinOnMarketPlaceService.findAll()
		assertThat(responseCoins).isNotNull()
		assertThat(responseCoins).isNotEmpty()
		assertThat(responseCoins).hasSize(2)
		assertThat(responseCoins).containsExactly(bitCoin, ethCoin)
	}
}
