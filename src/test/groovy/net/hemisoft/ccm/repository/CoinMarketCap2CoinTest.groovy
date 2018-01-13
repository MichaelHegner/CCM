package net.hemisoft.ccm.repository;

import java.time.LocalDateTime

import org.junit.Before;
import org.junit.Test;
import org.nomin.NominMapper;
import org.nomin.core.Nomin;

import net.hemisoft.ccm.domain.CoinsOnMarketPlace;
import net.hemisoft.ccm.porter.Coin;
import net.hemisoft.ccm.utils.DateUtils

public class CoinMarketCap2CoinTest {
	private static final String PACKAGE = "./net/hemisoft/ccm/repository/"
	
	NominMapper nomin = new Nomin(PACKAGE + "coinmarketcap2coin.groovy");
	Coin coin;
	CoinsOnMarketPlace comp;
	
	@Before
	public void before() {
		comp = new CoinsOnMarketPlace();
		coin = new Coin();
		coin.coinId				= "BTC"
		coin.name				= "Bitcoin"
		coin.symbol				= "(B)"
		coin.rank				= 1
		coin.priceUSD 			= 1.0
		coin.priceBTC			= 0.01
		coin.volume24hUSD		= 1_000_000;
		coin.marketCapUSD		= 1_000_000;
		coin.availableSupply	= 500_000;
		coin.totalSupply		= 800_000;
		coin.maxSupply			= 2_000_000;
		coin.changePercent1h	= 1.02;
		coin.changePercent24h	= 4.03;
		coin.changePercent7d	= -10.11;
		coin.lastUpdateEpoch	= 1515791406;
	}
  
	
	@Test
	public void test() {
		CoinsOnMarketPlace comp = nomin.map(coin, CoinsOnMarketPlace.class);

		assert comp.coin.coinId			== coin.coinId
		assert comp.coin.name			== coin.name
		assert comp.coin.symbol			== coin.symbol
		assert comp.coin.rank			== coin.rank
		assert comp.priceUSD			== coin.priceUSD
		assert comp.priceBTC			== coin.priceBTC
		assert comp.volume24hUSD		== coin.volume24hUSD
		assert comp.marketCapUSD		== coin.marketCapUSD
		assert comp.availableSupply		== coin.availableSupply
		assert comp.totalSupply			== coin.totalSupply
		assert comp.maxSupply			== coin.maxSupply
		assert comp.changePercent1h		== coin.changePercent1h
		assert comp.changePercent24h	== coin.changePercent24h
		assert comp.changePercent7d		== coin.changePercent7d
		
		LocalDateTime testLastUpdate = DateUtils.convertEpochMillis(coin.lastUpdateEpoch)
		assert comp.lastUpdate			== testLastUpdate
	}

}
