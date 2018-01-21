package net.hemisoft.ccm.repository;

import net.hemisoft.ccm.domain.Coin
import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.domain.MarketPlace
import net.hemisoft.ccm.stub.BitCoinStub
import net.hemisoft.ccm.stub.EthereumCoinStub
import net.hemisoft.ccm.utils.DateUtils

class CoinOnMarketPlaceStub {
	
	static CoinOnMarketPlace createBitCoin() {
		createBitCoin(MarketPlace.newInstance(name: "coinMarketCap"))
	}
	
	static CoinOnMarketPlace createBitCoin(MarketPlace marketPlace) {
		def coin = Coin.newInstance()
		CoinOnMarketPlace comp = CoinOnMarketPlace.newInstance(coin: coin, marketPlace: marketPlace)
		comp.coin.coinId 				= BitCoinStub.COIN_ID
		comp.coin.name 					= BitCoinStub.NAME
		comp.coin.symbol 				= BitCoinStub.SYMBOL
		comp.rank 						= BitCoinStub.RANK
		comp.priceUSD 					= BitCoinStub.PRICE_USD
		comp.priceBTC 					= BitCoinStub.PRICE_BTC
		comp.volume24hUSD 				= BitCoinStub.VOLUME_24H_USD
		comp.marketCapUSD 				= BitCoinStub.MARKET_CAP_USD
		comp.availableSupply 			= BitCoinStub.AVAILABLE_SUPPLY
		comp.totalSupply 				= BitCoinStub.TOTAL_SUPPLY
		comp.maxSupply 					= BitCoinStub.MAX_SUPPLY
		comp.changePercent1h 			= BitCoinStub.CHANGE_PERCENT_1H
		comp.changePercent24h 			= BitCoinStub.CHANGE_PERCENT_24H
		comp.changePercent7d 			= BitCoinStub.CHANGE_PERCENT_7D
		comp.lastUpdate 				= DateUtils.convertEpochMillis(BitCoinStub.LAST_UPDATE_EPOCH)
		comp
	}
	
	static void assertBitcoinValues(CoinOnMarketPlace comp) {
		assert comp.marketPlace.name	== BitCoinStub.MARKET_PLACE_NAME
		assert comp.coin.coinId 		== BitCoinStub.COIN_ID
		assert comp.coin.name 			== BitCoinStub.NAME
		assert comp.coin.symbol 		== BitCoinStub.SYMBOL
		assert comp.rank 				== BitCoinStub.RANK
		assert comp.priceUSD 			== BitCoinStub.PRICE_USD
		assert comp.priceBTC 			== BitCoinStub.PRICE_BTC
		assert comp.volume24hUSD 		== BitCoinStub.VOLUME_24H_USD
		assert comp.marketCapUSD 		== BitCoinStub.MARKET_CAP_USD
		assert comp.availableSupply 	== BitCoinStub.AVAILABLE_SUPPLY
		assert comp.totalSupply 		== BitCoinStub.TOTAL_SUPPLY
		assert comp.maxSupply 			== BitCoinStub.MAX_SUPPLY
		assert comp.changePercent1h 	== BitCoinStub.CHANGE_PERCENT_1H
		assert comp.changePercent24h 	== BitCoinStub.CHANGE_PERCENT_24H
		assert comp.changePercent7d 	== BitCoinStub.CHANGE_PERCENT_7D
		assert comp.lastUpdate 			== DateUtils.convertEpochMillis(BitCoinStub.LAST_UPDATE_EPOCH)
	}
	
	
	static CoinOnMarketPlace createEthereumCoin() {
		createEthereumCoin(MarketPlace.newInstance(name: "coinMarketCap"))
	}

	static CoinOnMarketPlace createEthereumCoin(def marketPlace) {
		def coin = Coin.newInstance()
		CoinOnMarketPlace comp = CoinOnMarketPlace.newInstance(coin: coin, marketPlace: marketPlace)
		comp.coin.coinId 				= EthereumCoinStub.COIN_ID
		comp.coin.name 					= EthereumCoinStub.NAME
		comp.coin.symbol 				= EthereumCoinStub.SYMBOL
		comp.rank 						= EthereumCoinStub.RANK
		comp.priceUSD 					= EthereumCoinStub.PRICE_USD
		comp.priceBTC 					= EthereumCoinStub.PRICE_BTC
		comp.volume24hUSD 				= EthereumCoinStub.VOLUME_24H_USD
		comp.marketCapUSD 				= EthereumCoinStub.MARKET_CAP_USD
		comp.availableSupply 			= EthereumCoinStub.AVAILABLE_SUPPLY
		comp.totalSupply 				= EthereumCoinStub.TOTAL_SUPPLY
		comp.maxSupply 					= EthereumCoinStub.MAX_SUPPLY
		comp.changePercent1h 			= EthereumCoinStub.CHANGE_PERCENT_1H
		comp.changePercent24h 			= EthereumCoinStub.CHANGE_PERCENT_24H
		comp.changePercent7d 			= EthereumCoinStub.CHANGE_PERCENT_7D
		comp.lastUpdate 				= DateUtils.convertEpochMillis(BitCoinStub.LAST_UPDATE_EPOCH)
		comp
	}
	
	static void assertEthereumValues(CoinOnMarketPlace comp) {
		assert comp.marketPlace.name	== EthereumCoinStub.MARKET_PLACE_NAME
		assert comp.coin.coinId 		== EthereumCoinStub.COIN_ID
		assert comp.coin.name 			== EthereumCoinStub.NAME
		assert comp.coin.symbol 		== EthereumCoinStub.SYMBOL
		assert comp.rank 				== EthereumCoinStub.RANK
		assert comp.priceUSD 			== EthereumCoinStub.PRICE_USD
		assert comp.priceBTC 			== EthereumCoinStub.PRICE_BTC
		assert comp.volume24hUSD 		== EthereumCoinStub.VOLUME_24H_USD
		assert comp.marketCapUSD 		== EthereumCoinStub.MARKET_CAP_USD
		assert comp.availableSupply 	== EthereumCoinStub.AVAILABLE_SUPPLY
		assert comp.totalSupply 		== EthereumCoinStub.TOTAL_SUPPLY
		assert comp.maxSupply 			== EthereumCoinStub.MAX_SUPPLY
		assert comp.changePercent1h 	== EthereumCoinStub.CHANGE_PERCENT_1H
		assert comp.changePercent24h 	== EthereumCoinStub.CHANGE_PERCENT_24H
		assert comp.changePercent7d 	== EthereumCoinStub.CHANGE_PERCENT_7D
		assert comp.lastUpdate 			== DateUtils.convertEpochMillis(EthereumCoinStub.LAST_UPDATE_EPOCH)
	}
}
