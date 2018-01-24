package net.hemisoft.ccm.repository

import org.nomin.core.Nomin
import org.springframework.messaging.handler.annotation.Header

import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.domain.MarketPlace
import net.hemisoft.ccm.porter.Coin
import net.hemisoft.ccm.utils.ResourceUtils


class CoinMarketCapTransformer {
//	Nomin nomin = Nomin.newInstance(ResourceUtils.getMapperResource())
	
	CoinOnMarketPlace transform(Coin coin, @Header(name="marketName", required=true) String marketName) {
//		MarketPlace marketPlace = MarketPlace.newInstance(name: marketName)
//		CoinOnMarketPlace comp = nomin.map(coin, CoinOnMarketPlace)
//		comp.marketPlace = marketPlace
//		comp
		CoinMarketCapMapper.getPopulated(coin, marketName)
	}
	
//	Coin transform(CoinOnMarketPlace comp) {
//		nomin.map(comp, Coin.class)
//	}
}
