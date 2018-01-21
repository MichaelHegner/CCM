package net.hemisoft.ccm.repository

import static org.junit.Assert.*
import static org.springframework.transaction.annotation.Propagation.NOT_SUPPORTED

import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

import net.hemisoft.ccm.domain.MarketPlace


@RunWith(SpringRunner)
@Import(RepositoryConfig)
@DataJpaTest
@Transactional(propagation = NOT_SUPPORTED)
class CoinMarketCapJPAHistoryTest {
	@Autowired CoinOnMarketPlaceService 	sut
	
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
		sut.save(comp)

		assert compRepository.findRevisions(comp.id).content.size() == 1
		assert marketPlaceRepository.findRevisions(comp.marketPlace.id).content.size() == 1
		assert coinRepository.findRevisions(comp.coin.id).content.size() == 1
	}
	
	@Test
	public void testInsert_ifTwoDifferentCoinsFromSameMarketInChannel_thenEachEntryHasOneHistoryEntry() {
		def bitComp = CoinOnMarketPlaceStub.createBitCoin()
		def ethComp = CoinOnMarketPlaceStub.createEthereumCoin()
		
		sut.save(bitComp)
		sut.save(ethComp)
		
		assert compRepository.findRevisions(bitComp.id).content.size() == 1
		assert compRepository.findRevisions(ethComp.id).content.size() == 1

		assert marketPlaceRepository.findRevisions(bitComp.marketPlace.id).content.size() == 1
		assert marketPlaceRepository.findRevisions(ethComp.marketPlace.id).content.size() == 1
		assert coinRepository.findRevisions(bitComp.coin.id).content.size() == 1
		assert coinRepository.findRevisions(ethComp.coin.id).content.size() == 1
	}
	
	@Test
	public void testInsert_ifTwoSameCoinsFromSameMarketInChannel_thenHistoryHasTwoEntry() {
		def bitComp = CoinOnMarketPlaceStub.createBitCoin()
		def bitComp2 = CoinOnMarketPlaceStub.createBitCoin()
		bitComp2.setPriceBTC(bitComp2.getPriceBTC() + 10)
		bitComp2.setLastUpdate(bitComp2.lastUpdate.plusSeconds(10))

		sut.save(bitComp)
		sut.save(bitComp2)
		
		assert compRepository.findRevisions(bitComp2.id).content.size() == 2
		assert marketPlaceRepository.findRevisions(bitComp2.marketPlace.id).content.size() == 1
		assert coinRepository.findRevisions(bitComp2.coin.id).content.size() == 1
	}
	
	
	@Test
	public void testInsert_ifTwoDifferentCoinsFromDifferentMarketsInChannel_thenEachEntryHasOneHistoryEntry() {
		def bitComp = CoinOnMarketPlaceStub.createBitCoin()
		def ethComp = CoinOnMarketPlaceStub.createEthereumCoin()
		
		sut.save(bitComp)
		sut.save(ethComp)
		
		assert compRepository.findRevisions(bitComp.id).content.size() == 1
		assert compRepository.findRevisions(ethComp.id).content.size() == 1

		assert marketPlaceRepository.findRevisions(bitComp.marketPlace.id).content.size() == 1
		assert marketPlaceRepository.findRevisions(ethComp.marketPlace.id).content.size() == 1
		assert coinRepository.findRevisions(bitComp.coin.id).content.size() == 1
		assert coinRepository.findRevisions(ethComp.coin.id).content.size() == 1
	}
	
	@Test
	public void testInsert_ifTwoSameCoinsFromDifferentMarketsInChannel_thenEachEntryHasOneHistoryEntry() {
		def bitComp = CoinOnMarketPlaceStub.createBitCoin()
		def bitComp2 = CoinOnMarketPlaceStub.createBitCoin(MarketPlace.newInstance(name: "AnyMarketPlace"))
		bitComp2.setPriceBTC(bitComp2.getPriceBTC() + 10)
		bitComp2.setLastUpdate(bitComp2.lastUpdate.plusSeconds(10))
		
		sut.save(bitComp)
		sut.save(bitComp2)
		
		assert compRepository.findRevisions(bitComp.id).content.size() == 1
		assert compRepository.findRevisions(bitComp2.id).content.size() == 1

		assert marketPlaceRepository.findRevisions(bitComp.marketPlace.id).content.size() == 1
		assert marketPlaceRepository.findRevisions(bitComp2.marketPlace.id).content.size() == 1
		assert coinRepository.findRevisions(bitComp.coin.id).content.size() == 1
		assert coinRepository.findRevisions(bitComp2.coin.id).content.size() == 1
	}
}
