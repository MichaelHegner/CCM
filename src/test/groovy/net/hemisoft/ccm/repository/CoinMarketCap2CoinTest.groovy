package net.hemisoft.ccm.repository;

import org.junit.Before;
import org.junit.Test;
import org.nomin.NominMapper;
import org.nomin.core.Nomin;

import net.hemisoft.ccm.domain.CoinsOnMarketPlace;
import net.hemisoft.ccm.porter.Coin;

public class CoinMarketCap2CoinTest {
	NominMapper nomin = new Nomin("coinmarketcap2coin.groovy");
	Coin coin;
	CoinsOnMarketPlace comp;
	
	@Before
	public void before() {
		coin = new Coin();
		comp = new CoinsOnMarketPlace();
	}
  
	
	@Test
	public void test() {
		Coin coin = nomin.map(comp, Coin.class);
	}

}
