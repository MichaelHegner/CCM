package net.hemisoft.ccm.repository

import javax.annotation.PostConstruct

import org.nomin.core.Nomin
import org.springframework.messaging.handler.annotation.Header

import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.domain.MarketPlace
import net.hemisoft.ccm.porter.cryptocompare.Coin
import net.hemisoft.ccm.utils.ResourceUtils


class CryptoCompareTransformer {
	Nomin nomin
	
	@PostConstruct
	void postConstruct() {
		def mapperResource = ResourceUtils.cryptoCompareMapperResource
		nomin = Nomin.newInstance mapperResource
		nomin.disableAutomapping()
		nomin.disableCache()
	}

	CoinOnMarketPlace transform(Coin coin, @Header(name="marketName", required=true) String marketName) {
		MarketPlace marketPlace = MarketPlace.newInstance name: marketName
		CoinOnMarketPlace comp = nomin.map coin, CoinOnMarketPlace
		comp.marketPlace = marketPlace
		comp
	}
}
