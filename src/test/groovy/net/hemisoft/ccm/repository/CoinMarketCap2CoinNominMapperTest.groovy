package net.hemisoft.ccm.repository;

import java.time.LocalDateTime

import org.junit.Before;
import org.junit.Test;
import org.nomin.NominMapper;
import org.nomin.core.Nomin;

import net.hemisoft.ccm.domain.CoinOnMarketPlace;
import net.hemisoft.ccm.porter.coinmarketcap.Coin
import net.hemisoft.ccm.stub.coinmarketcap.BitCoinStub
import net.hemisoft.ccm.utils.DateUtils
import net.hemisoft.ccm.utils.ResourceUtils

public class CoinMarketCap2CoinNominMapperTest {
	NominMapper nomin = new Nomin(ResourceUtils.getMapperResource());
	
	Coin coin;
	CoinOnMarketPlace comp;
	
	@Before
	public void before() {
		comp = new CoinOnMarketPlace();
		coin = BitCoinStub.create()
	}
  
	
	@Test
	public void test() {
		CoinOnMarketPlace comp = nomin.map(coin, CoinOnMarketPlace.class);

		assert comp.coin.coinId			== coin.coinId
		assert comp.coin.name			== coin.name
		assert comp.coin.symbol			== coin.symbol
		assert comp.rank				== coin.rank
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
