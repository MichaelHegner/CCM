package net.hemisoft.ccm.repository.stub;

import net.hemisoft.ccm.domain.Coin
import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.domain.MarketPlace
import net.hemisoft.ccm.utils.DateUtils

class CoinOnMarketPlaceStub {
	
	static CoinOnMarketPlace createBitCoin() {
		createBitCoin(MarketPlace.newInstance(name: "coinMarketCap"))
	}
	
	static CoinOnMarketPlace createBitCoin(MarketPlace marketPlace) {
		def coin = Coin.newInstance()
		CoinOnMarketPlace comp = CoinOnMarketPlace.newInstance(coin: coin, marketPlace: marketPlace)
		comp.coin.coinId 				= "bitcoin"
		comp.coin.name 					= "Bitcoin"
		comp.coin.symbol 				= "BTC"
		comp.rank 						= 1
		comp.priceUSD 					= 14613.5
		comp.priceBTC 					= 1.0
		comp.volume24hUSD 				= 12079400000.0
		comp.marketCapUSD 				= 245518197535
		comp.availableSupply 			= 16800550.0
		comp.totalSupply 				= 16800550.0
		comp.maxSupply 					= 21000000.0
		comp.changePercent1h 			= 0.75
		comp.changePercent24h 			= 3.50
		comp.changePercent7d 			= -14.25
		comp.lastUpdate 				= DateUtils.convertEpochMillis(1515852262)
		comp
	}
	
	
	static CoinOnMarketPlace createEthereumCoin() {
		createEthereumCoin(MarketPlace.newInstance(name: "coinMarketCap"))
	}

	static CoinOnMarketPlace createEthereumCoin(def marketPlace) {
		def coin = Coin.newInstance()
		CoinOnMarketPlace comp = CoinOnMarketPlace.newInstance(coin: coin, marketPlace: marketPlace)
		comp.coin.coinId 				= "ethereum"
		comp.coin.name 					= "Ethereum"
		comp.coin.symbol 				= "ETH"
		comp.rank 						= 2
		comp.priceUSD 					= 1372.18
		comp.priceBTC 					= 0.0942203
		comp.volume24hUSD 				= 4984240000.0
		comp.marketCapUSD 				= 133039071219
		comp.availableSupply 			= 96954533.0
		comp.totalSupply 				= 96954533.0
		comp.maxSupply 					= null
		comp.changePercent1h 			= 0.27
		comp.changePercent24h 			= 7.36
		comp.changePercent7d 			= 32.52
		comp.lastUpdate 				= DateUtils.convertEpochMillis(1515852250)
		comp
	}
	
	static void assertEthereumValues(CoinOnMarketPlace comp) {
		assert comp.marketPlace.name	== "coinMarketPlace"
		assert comp.coin.coinId 		== "ethereum"
		assert comp.coin.name 			== "Ethereum"
		assert comp.coin.symbol 		== "ETH"
		assert comp.rank 				== 2
		assert comp.priceUSD 			== 1372.18
		assert comp.priceBTC 			== 0.0942203
		assert comp.volume24hUSD 		== 4984240000.0
		assert comp.marketCapUSD 		== 133039071219
		assert comp.availableSupply 	== 96954533.0
		assert comp.totalSupply 		== 96954533.0
		assert comp.maxSupply 			== null
		assert comp.changePercent1h 	== 0.27
		assert comp.changePercent24h 	== 7.36
		assert comp.changePercent7d 	== 32.52
		assert comp.lastUpdate 			== DateUtils.convertEpochMillis(1515852250)
	}
}
