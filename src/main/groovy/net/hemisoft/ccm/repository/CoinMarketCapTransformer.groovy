package net.hemisoft.ccm.repository

import org.nomin.core.Nomin
import org.springframework.messaging.handler.annotation.Header

import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.domain.MarketPlace
import net.hemisoft.ccm.domain.key.ResourceUtils
import net.hemisoft.ccm.porter.Coin


class CoinMarketCapTransformer {
	Nomin nomin = Nomin.newInstance(ResourceUtils.getMapperResource())
	
	CoinOnMarketPlace transform(Coin coin, @Header(name="marketName", required=true) String marketName) {
		MarketPlace marketPlace = MarketPlace.newInstance(name: marketName)
		CoinOnMarketPlace comp = nomin.map(coin, CoinOnMarketPlace)
		comp.setMarketPlace(marketPlace)
		comp
	}
	
	Coin transform(CoinOnMarketPlace comp) {
		nomin.map(comp, Coin.class)
	}
}
