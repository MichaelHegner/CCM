package net.hemisoft.ccm.backend

import static org.junit.Assert.*
import static org.springframework.transaction.annotation.Propagation.NOT_SUPPORTED

import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.integration.support.MessageBuilder
import org.springframework.messaging.MessageChannel
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

import net.hemisoft.ccm.backend.repository.CoinRepository
import net.hemisoft.ccm.backend.repository.CoinsOnMarketPlaceRepository
import net.hemisoft.ccm.backend.repository.MarketPlaceRepository
import net.hemisoft.ccm.backend.repository.stub.CoinOnMarketPlaceStub
import net.hemisoft.ccm.domain.MarketPlace


@RunWith(SpringRunner)
@ContextConfiguration(classes=BackendConfig)
@DataJpaTest
@Transactional(propagation = NOT_SUPPORTED)
class CoinMarketCapJPAHistoryTest {
	@Autowired @Qualifier("repository.income.channel") 	
	MessageChannel channel
	
	@Autowired CoinsOnMarketPlaceRepository compRepository
	@Autowired MarketPlaceRepository 		marketPlaceRepository
	@Autowired CoinRepository 				coinRepository
	
	@After
	void after() {
		compRepository.deleteAll()
		marketPlaceRepository.deleteAll()
		coinRepository.deleteAll()
	}
	
	@Test
	public void testInsert_ifOneCoinInChannel_thenHistoryHasOneEntry() {
		def comp = CoinOnMarketPlaceStub.createBitCoin()
		assert true == channel.send(MessageBuilder.withPayload(comp).build())

		def dbComp = compRepository.findAll().get(0)
		
		assert 1 == compRepository.findRevisions(dbComp.id).content.size()
		assert 1 == marketPlaceRepository.findRevisions(dbComp.marketPlace.id).content.size()
		assert 1 == coinRepository.findRevisions(dbComp.coin.id).content.size()
	}
	
	@Test
	public void testInsert_ifTwoDifferentCoinsFromSameMarketInChannel_thenEachEntryHasOneHistoryEntry() {
		def bitComp = CoinOnMarketPlaceStub.createBitCoin()
		def ethComp = CoinOnMarketPlaceStub.createEthereumCoin()
		assert true == channel.send(MessageBuilder.withPayload(bitComp).build())
		assert true == channel.send(MessageBuilder.withPayload(ethComp).build())
		
		def dbComps = compRepository.findAll()
		def dbBitComp = dbComps.find { it == bitComp }
		def dbEthComp = dbComps.find { it == ethComp }
				
		assert 1 == compRepository.findRevisions(dbBitComp.id).content.size()
		assert 1 == compRepository.findRevisions(dbEthComp.id).content.size()

		assert 1 == marketPlaceRepository.findRevisions(dbBitComp.marketPlace.id).content.size()
		assert 1 == marketPlaceRepository.findRevisions(dbEthComp.marketPlace.id).content.size()
		assert 1 == coinRepository.findRevisions(dbBitComp.coin.id).content.size()
		assert 1 == coinRepository.findRevisions(dbEthComp.coin.id).content.size()
	}
	
	@Test
	public void testInsert_ifTwoSameCoinsFromSameMarketInChannel_thenHistoryHasTwoEntry() {
		def bitComp = CoinOnMarketPlaceStub.createBitCoin()
		def bitComp2 = CoinOnMarketPlaceStub.createBitCoin()
		bitComp2.priceBTC = bitComp2.priceBTC + 10
		bitComp2.lastUpdate = bitComp2.lastUpdate.plusSeconds(10)
		assert true == channel.send(MessageBuilder.withPayload(bitComp).build())
		assert true == channel.send(MessageBuilder.withPayload(bitComp2).build())
		
		def dbComps = compRepository.findAll()
		def dbBitComp  = dbComps.find { it == bitComp }
		def dbBitComp2 = dbComps.find { it == bitComp2 }

		assert 2 == compRepository.findRevisions(dbBitComp2.id).content.size()
		assert 1 == marketPlaceRepository.findRevisions(dbBitComp2.marketPlace.id).content.size()
		assert 1 == coinRepository.findRevisions(dbBitComp2.coin.id).content.size()
	}
	
	
	@Test
	public void testInsert_ifTwoDifferentCoinsFromDifferentMarketsInChannel_thenEachEntryHasOneHistoryEntry() {
		def bitComp = CoinOnMarketPlaceStub.createBitCoin()
		def ethComp = CoinOnMarketPlaceStub.createEthereumCoin()
		assert true == channel.send(MessageBuilder.withPayload(bitComp).build())
		assert true == channel.send(MessageBuilder.withPayload(ethComp).build())
		
		def dbComps = compRepository.findAll()
		def dbBitComp = dbComps.find { it == bitComp }
		def dbEthComp = dbComps.find { it == ethComp }

		assert 1 == compRepository.findRevisions(dbBitComp.id).content.size()
		assert 1 == compRepository.findRevisions(dbEthComp.id).content.size()

		assert 1 == marketPlaceRepository.findRevisions(dbBitComp.marketPlace.id).content.size()
		assert 1 == marketPlaceRepository.findRevisions(dbEthComp.marketPlace.id).content.size()
		assert 1 == coinRepository.findRevisions(dbBitComp.coin.id).content.size()
		assert 1 == coinRepository.findRevisions(dbEthComp.coin.id).content.size()
	}
	
	@Test
	public void testInsert_ifTwoSameCoinsFromDifferentMarketsInChannel_thenEachEntryHasOneHistoryEntry() {
		def bitComp = CoinOnMarketPlaceStub.createBitCoin()
		def bitComp2 = CoinOnMarketPlaceStub.createBitCoin(MarketPlace.newInstance(name: "AnyMarketPlace"))
		bitComp2.priceBTC = bitComp2.priceBTC + 10
		bitComp2.lastUpdate = bitComp2.lastUpdate.plusSeconds(10)
		assert true == channel.send(MessageBuilder.withPayload(bitComp).build())
		assert true == channel.send(MessageBuilder.withPayload(bitComp2).build())
		
		def dbComps = compRepository.findAll()
		def dbBitComp = dbComps.find { it == bitComp }
		def dbBitComp2 = dbComps.find { it == bitComp2 }

		assert 1 == compRepository.findRevisions(dbBitComp.id).content.size()
		assert 1 == compRepository.findRevisions(dbBitComp2.id).content.size()

		assert 1 == marketPlaceRepository.findRevisions(dbBitComp.marketPlace.id).content.size()
		assert 1 == marketPlaceRepository.findRevisions(dbBitComp2.marketPlace.id).content.size()
		assert 1 == coinRepository.findRevisions(dbBitComp.coin.id).content.size()
		assert 1 == coinRepository.findRevisions(dbBitComp2.coin.id).content.size()
	}
}
