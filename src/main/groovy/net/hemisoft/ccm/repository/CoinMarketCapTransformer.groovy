package net.hemisoft.ccm.repository

import org.nomin.NominMapper
import org.nomin.core.Nomin

import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.domain.key.ResourcePath
import net.hemisoft.ccm.porter.Coin

class CoinMarketCapTransformer {
	NominMapper nomin = new Nomin(ResourcePath.PACKAGE + "coinmarketcap2coin.groovy");
	
	CoinOnMarketPlace transform(Coin coin) {
		nomin.map(coin, CoinOnMarketPlace.class);
	}
	
	Coin transform(CoinOnMarketPlace comp) {
		nomin.map(comp, Coin.class);
	}
}
