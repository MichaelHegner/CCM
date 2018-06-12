package net.hemisoft.ccm.backend.service

import static org.junit.Assert.*

import static org.junit.Assert.*
import static org.mockito.Mockito.any
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.times
import static org.mockito.Mockito.verify
import static org.mockito.Mockito.when

import org.junit.Before
import org.junit.Test

import net.hemisoft.ccm.backend.repository.CoinsOnMarketPlaceRepository
import net.hemisoft.ccm.domain.Coin
import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.domain.MarketPlace

class CoinOnMarketPlaceServiceSaveTest {
	CoinsOnMarketPlaceRepository 	mockRepository;
	CoinOnMarketPlaceService 		serviceUnderTest
	
	@Before
	public void before() {
		mockRepository = mock CoinsOnMarketPlaceRepository
		serviceUnderTest = CoinOnMarketPlaceServiceImpl.newInstance mockRepository
	}
	
	/*
	 * Good Test Cases ...
	 */
	
	@Test
	public void testSave_whenCompIsNotPersisted_thenPersistCompAndReturnPersistedComp() {
		def coin = Coin.newInstance id:1
		def marketPlace = MarketPlace.newInstance id:1
		def comp = CoinOnMarketPlace.newInstance coin:coin, marketPlace:marketPlace
		def expected = CoinOnMarketPlace.newInstance id:1, coin:coin, marketPlace:marketPlace
		when(mockRepository.save(comp)).thenReturn(expected);

		def actual = serviceUnderTest.save comp
		
		assert !actual.is(coin) // not same instance
		assert actual.is(expected)
		verify(mockRepository, times(2)).findByCoinAndMarketPlace coin, marketPlace
		verify(mockRepository, times(1)).save comp
	}
	
	@Test
	public void testSave_whenCompIsPersisted_thenReturnPersistedAndUpdatedComp() {
		def coin = Coin.newInstance id:1
		def marketPlace = MarketPlace.newInstance id:1
		def comp = CoinOnMarketPlace.newInstance coin:coin, marketPlace:marketPlace
		comp.setPriceUSD 1000
		def expected = CoinOnMarketPlace.newInstance id:1, coin:coin, marketPlace:marketPlace
		when(mockRepository.findByCoinAndMarketPlace(coin, marketPlace)).thenReturn(expected)
		
		def actual = serviceUnderTest.save comp

		assert actual.is(expected)
		assert actual.priceUSD == comp.priceUSD
		verify(mockRepository, times(1)).findByCoinAndMarketPlace coin, marketPlace
		verify(mockRepository, times(0)).save comp
	}
	
	@Test
	public void testSave_whenCompIsNotPersistedButBecomesPersisted_thenReturnPersistedComp() {
		def coin = Coin.newInstance id:1
		def marketPlace = MarketPlace.newInstance id:1
		def comp = CoinOnMarketPlace.newInstance coin:coin, marketPlace:marketPlace
		def expected = CoinOnMarketPlace.newInstance id:1, coin:coin, marketPlace:marketPlace
		when(mockRepository.findByCoinAndMarketPlace(coin, marketPlace)).thenReturn(null).thenReturn(expected);

		def actual = serviceUnderTest.save comp

		assert actual == expected
		verify(mockRepository, times(2)).findByCoinAndMarketPlace coin, marketPlace
		verify(mockRepository, times(0)).save coin
	}
	
	/*
	 * ... Good Test Cases
	 */

	//
	
	/*
	 * Bad Test Cases ...
	 */
	
	@Test
	public void testSave_whenCompIsNULL_thenThrowIllegalArgumentException() {
		try {
			serviceUnderTest.save null
			fail "IllegalArgumentException expected."
		} catch (IllegalArgumentException e) {
			assert null != e
		} catch(Throwable e) {
			fail "IllegalArgumentException expected, but throwed $e"
		}
	}
	
	/*
	 * ... Bad Test Cases
	 */


	


}
