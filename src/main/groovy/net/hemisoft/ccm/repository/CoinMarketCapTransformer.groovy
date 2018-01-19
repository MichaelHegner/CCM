package net.hemisoft.ccm.repository

import javax.annotation.PostConstruct

import org.nomin.core.Nomin

import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.domain.key.ResourceUtils
import net.hemisoft.ccm.porter.Coin


class CoinMarketCapTransformer {
	Nomin nomin = Nomin.newInstance(ResourceUtils.getMapperResource())
	
	CoinOnMarketPlace transform(Coin coin) {
		nomin.map(coin, CoinOnMarketPlace.class);
	}
	
	Coin transform(CoinOnMarketPlace comp) {
		nomin.map(comp, Coin.class);
	}
}
