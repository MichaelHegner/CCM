package net.hemisoft.ccm.porter.client

import javax.annotation.PostConstruct

import org.nomin.core.Nomin
import org.springframework.messaging.handler.annotation.Header

import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.domain.MarketPlace
import net.hemisoft.ccm.porter.marketsimulator.Coin
import net.hemisoft.ccm.utils.ResourceUtils


class MarketSimulatorTransformer {
	Nomin nomin
	
	@PostConstruct
	void postConstruct() {
		def mapperResource = ResourceUtils.marketSimulatorMapperResource
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
