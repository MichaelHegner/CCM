package net.hemisoft.ccm.repository;

import net.hemisoft.ccm.domain.CoinOnMarketPlace;
import net.hemisoft.ccm.domain.MarketPlace
import net.hemisoft.ccm.porter.Coin
import net.hemisoft.ccm.utils.DateUtils

class CoinMarketCapMapper {
	static CoinOnMarketPlace getPopulated(Coin coin, String marketName) {
		def newCoin = net.hemisoft.ccm.domain.Coin.newInstance()
		def newMarketPlace = MarketPlace.newInstance()
		def comp = CoinOnMarketPlace.newInstance(coin: newCoin, marketPlace: newMarketPlace)
		comp.marketPlace.name	= marketName
		comp.coin.coinId 		= coin.coinId
		comp.coin.name 			= coin.name
		comp.coin.symbol		= coin.symbol
		comp.rank				= coin.rank
		comp.priceUSD			= coin.priceUSD
		comp.priceBTC 			= coin.priceBTC
		comp.volume24hUSD 		= coin.volume24hUSD
		comp.marketCapUSD 		= coin.marketCapUSD
		comp.availableSupply 	= coin.availableSupply
		comp.totalSupply 		= coin.totalSupply
		comp.maxSupply 			= coin.maxSupply
		comp.changePercent1h 	= coin.changePercent1h
		comp.changePercent24h 	= coin.changePercent24h
		comp.changePercent7d 	= coin.changePercent7d
		comp.lastUpdate 		= DateUtils.convertEpochMillis(coin.lastUpdateEpoch)
		comp
	}
}
