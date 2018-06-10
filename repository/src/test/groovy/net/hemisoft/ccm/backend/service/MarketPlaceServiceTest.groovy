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

import net.hemisoft.ccm.backend.repository.MarketPlaceRepository
import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.domain.MarketPlace

class MarketPlaceServiceTest {
	MarketPlaceRepository 	mockRepository
	MarketPlaceService 	serviceUnderTest
	
	@Before
	public void before() {
		mockRepository = mock MarketPlaceRepository
		serviceUnderTest = MarketPlaceService.newInstance mockRepository
	}

	/*
	 * Good Test Cases ...
	 */
	
	@Test
	public void testFindOrCreateMarketPlace_whenCompIsNotPersisted_thenPersistCompAndReturnPersistedComp() {
		def name = "name"
		def marketPlace = MarketPlace.newInstance name: name
		def comp = CoinOnMarketPlace.newInstance marketPlace: marketPlace
		def resultMarketPlace = MarketPlace.newInstance id:1, name: name
		when(mockRepository.save(any(MarketPlace))).thenReturn(resultMarketPlace);

		def result = serviceUnderTest.findOrCreateMarketPlace comp
		
		assert !result.is(marketPlace) // not same instance
		assert result .is(resultMarketPlace)
		verify(mockRepository, times(2)).findByName name
		verify(mockRepository, times(1)).save marketPlace
	}
	
	@Test
	public void testFindOrCreateMarketPlace_whenCompIsPersisted_thenReturnPersistedComp() {
		def name = "name"
		def marketPlace = MarketPlace.newInstance name: name
		def comp = CoinOnMarketPlace.newInstance marketPlace: marketPlace
		when(mockRepository.findByName(name)).thenReturn(marketPlace);
		
		def result = serviceUnderTest.findOrCreateMarketPlace comp

		assert result == marketPlace
		verify(mockRepository, times(1)).findByName name
		verify(mockRepository, times(0)).save marketPlace
	}

	@Test
	public void testFindOrCreateMarketPlace_whenCompIsNotPersistedButBecomesPersisted_thenReturnPersistedComp() {
		def name = "name"
		def marketPlace = MarketPlace.newInstance name: name
		def comp = CoinOnMarketPlace.newInstance marketPlace: marketPlace
		when(mockRepository.findByName(name)).thenReturn(null).thenReturn(marketPlace);
		
		def result = serviceUnderTest.findOrCreateMarketPlace comp

		assert result == marketPlace
		verify(mockRepository, times(2)).findByName name
		verify(mockRepository, times(0)).save marketPlace
	}
	
	/*
	 * ... Good Test Cases
	 */

	//
	
	/*
	 * Bad Test Cases ...
	 */
	
	@Test
	public void testFindOrCreateMarketPlace_whenCompIsNULL_thenThrowIllegalArgumentException() {
		try {
			CoinOnMarketPlace comp = null
			serviceUnderTest.findOrCreateMarketPlace comp
			fail "IllegalArgumentException expected."
		} catch (IllegalArgumentException e) {
			assert null != e
		} catch (Throwable e) {
			fail "IllegalArgumentException expected, but throwed $e."
		}
	}
	
	@Test
	public void testFindOrCreateMarketPlace_whenCompMarketPlaceNameIsNULL_thenThrowIllegalArgumentException() {
		try {
			String name = null
			serviceUnderTest.findOrCreateMarketPlace name
			fail "IllegalArgumentException expected."
		} catch (IllegalArgumentException e) {
			assert null != e
		} catch (Throwable e) {
			fail "IllegalArgumentException expected, but throwed $e."
		}
	}
	
	/*
	 * ... Bad Test Cases 
	 */
}
