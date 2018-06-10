package net.hemisoft.ccm.backend.service

import static org.junit.Assert.*
import static org.mockito.Mockito.any
import static org.mockito.Mockito.mock
import static org.mockito.Mockito.times
import static org.mockito.Mockito.verify
import static org.mockito.Mockito.when

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

import net.hemisoft.ccm.backend.repository.CoinRepository
import net.hemisoft.ccm.domain.Coin
import net.hemisoft.ccm.domain.CoinOnMarketPlace

class CoinServiceTest {
	CoinRepository 	mockRepository
	CoinService 	serviceUnderTest
	
	@Before
	public void before() {
		mockRepository = mock CoinRepository
		serviceUnderTest = CoinService.newInstance mockRepository
	}

	/*
	 * Good Test Cases ...
	 */
	
	@Test
	public void testFindOrCreateCoin_whenCompIsNotPersisted_thenPersistCompAndReturnPersistedComp() {
		def coinId = "coinId"
		def coinName = "coinName"
		def coin = Coin.newInstance coinId: coinId, name: coinName
		def comp = CoinOnMarketPlace.newInstance coin: coin
		def resultCoin = Coin.newInstance id:1, coinId: coinId, name: coinName
		when(mockRepository.save(any(Coin))).thenReturn(resultCoin);

		def result = serviceUnderTest.findOrCreateCoin comp
		
		assert !result.is(coin) // not same instance
		assert result .is(resultCoin)
		verify(mockRepository, times(2)).findByCoinIdAndName coinId, coinName
		verify(mockRepository, times(1)).save coin
	}
	
	@Test
	public void testFindOrCreateCoin_whenCompIsPersisted_thenReturnPersistedComp() {
		def coinId = "coinId"
		def coinName = "coinName"
		def coin = Coin.newInstance coinId: coinId, name: coinName
		def comp = CoinOnMarketPlace.newInstance coin: coin
		when(mockRepository.findByCoinIdAndName(coinId, coinName)).thenReturn(coin);
		
		def result = serviceUnderTest.findOrCreateCoin comp

		assert result == coin
		verify(mockRepository, times(1)).findByCoinIdAndName coinId, coinName
		verify(mockRepository, times(0)).save coin
	}

	@Test
	public void testFindOrCreateCoin_whenCompIsNotPersistedButBecomesPersisted_thenReturnPersistedComp() {
		def coinId = "coinId"
		def coinName = "coinName"
		def coin = Coin.newInstance coinId: coinId, name: coinName
		def comp = CoinOnMarketPlace.newInstance coin: coin
		when(mockRepository.findByCoinIdAndName(coinId, coinName)).thenReturn(null).thenReturn(coin);
		
		def result = serviceUnderTest.findOrCreateCoin comp

		assert result == coin
		verify(mockRepository, times(2)).findByCoinIdAndName coinId, coinName
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
	public void testFindOrCreateCoin_whenCompIsNULL_thenThrowIllegalArgumentException() {
		try {
			serviceUnderTest.findOrCreateCoin null
			fail "IllegalArgumentException expected."
		} catch (IllegalArgumentException e) {
			assert null != e
		} catch (Throwable e) {
			fail "IllegalArgumentException expected, but throwed $e."
		}
	}
	
	@Test
	public void testFindOrCreateCoin_whenCompCoinIdIsNULL_thenThrowIllegalArgumentException() {
		try {
			serviceUnderTest.findOrCreateCoin null, "name"
			fail "IllegalArgumentException expected."
		} catch (IllegalArgumentException e) {
			assert null != e
		} catch (Throwable e) {
			fail "IllegalArgumentException expected, but throwed $e."
		}
	}
	
	@Test
	public void testFindOrCreateCoin_whenCompCoinNameIsNULL_thenThrowIllegalArgumentException() {
		try {
			serviceUnderTest.findOrCreateCoin "coinId", null
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
