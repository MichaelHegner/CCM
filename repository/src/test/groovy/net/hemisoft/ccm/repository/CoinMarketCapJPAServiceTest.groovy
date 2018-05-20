package net.hemisoft.ccm.repository

import static org.assertj.core.api.Assertions.assertThat
import static org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner

import net.hemisoft.ccm.domain.MarketPlace
import net.hemisoft.ccm.repository.stub.CoinOnMarketPlaceStub


/**
 * This test class tests the hibernate configuration. It tests the behavior of the CRUD methods
 * and its behavior, espacially to the reference data as coin and marketplace.

 * @author Michael Hegner
 */
@RunWith(SpringRunner)
@ContextConfiguration(classes = [RepositoryConfig])
@DataJpaTest
class CoinMarketCapJPAServiceTest {
	@Autowired CoinOnMarketPlaceService service
	
	@Test
	public void testInsert_ifOneCoinInChannel_thenInsertCoin() {
		def comp = CoinOnMarketPlaceStub.createBitCoin()
		service.save(comp)
				
		def comps = service.findAll()
		assert comps != null
		assert comps.size() == 1
		
		assert comps.get(0) == comp
	}
	
	@Test
	public void testInsert_ifTwoDifferentCoinsFromSameMarketInChannel_thenInsertBothCoins() {
		def bitComp = CoinOnMarketPlaceStub.createBitCoin()
		def ethComp = CoinOnMarketPlaceStub.createEthereumCoin()
		service.save(bitComp)
		service.save(ethComp)
		
		def comps = service.findAll()
		assert comps != null
		assert comps.size() == 2
		
		def compResult = comps.get(0)
		assertThat(comps).containsExactly(bitComp, ethComp)
	}
	
	@Test
	public void testInsert_ifTwoSameCoinsFromSameMarketInChannel_thenUpdateCoin() {
		def bitComp = CoinOnMarketPlaceStub.createBitCoin()
		def bitComp2 = CoinOnMarketPlaceStub.createBitCoin()
		bitComp2.priceBTC = bitComp2.priceBTC + 10
		bitComp2.lastUpdate = bitComp2.lastUpdate.plusSeconds(10)
		
		service.save(bitComp)
		service.save(bitComp2)
		
		def comps = service.findAll()
		assert comps != null
		assert comps.size() == 1
		
		assertThat(comps).containsExactly(bitComp2)
	}
	
	
	@Test
	public void testInsert_ifTwoDifferentCoinsFromDifferentMarketsInChannel_thenInsertBothCoins() {
		def bitComp = CoinOnMarketPlaceStub.createBitCoin()
		def ethComp = CoinOnMarketPlaceStub.createEthereumCoin()
		service.save(bitComp)
		service.save(ethComp)
		
		def comps = service.findAll()
		assert comps != null
		assert comps.size() == 2
		
		assertThat(comps).containsExactly(bitComp, ethComp)
	}
	
	@Test
	public void testInsert_ifTwoSameCoinsFromDifferentMarketsInChannel_thenInsertBothCoins() {
		def bitComp = CoinOnMarketPlaceStub.createBitCoin()
		def bitComp2 = CoinOnMarketPlaceStub.createBitCoin(MarketPlace.newInstance(name: "AnyMarketPlace"))
		bitComp2.priceBTC = bitComp2.priceBTC + 10
		bitComp2.lastUpdate = bitComp2.lastUpdate.plusSeconds(10)
		
		service.save(bitComp)
		service.save(bitComp2)
		
		def comps = service.findAll()
		assert comps != null
		assert comps.size() == 2
		
		assertThat(comps).containsExactly(bitComp, bitComp2)
	}
}
