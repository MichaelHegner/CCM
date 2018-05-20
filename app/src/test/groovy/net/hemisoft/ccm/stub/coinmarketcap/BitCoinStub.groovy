package net.hemisoft.ccm.stub.coinmarketcap

import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.porter.coinmarketcap.Coin
import net.hemisoft.ccm.utils.DateUtils

class BitCoinStub {
	static final String			MARKET_PLACE_NAME	= "coinMarketCap"
	static final String 		COIN_ID				= "bitcoin"
	static final String 		NAME 				= "Bitcoin"
	static final String 		SYMBOL 				= "BTC"
	static final int 			RANK 				= 1
	
	static final BigDecimal 	PRICE_USD 			= 14613.5
	static final BigDecimal 	PRICE_BTC 			= 1.0
	static final BigDecimal 	VOLUME_24H_USD 		= 12079400000.0
	static final BigDecimal 	MARKET_CAP_USD 		= 245518197535
	static final BigDecimal 	AVAILABLE_SUPPLY 	= 16800550.0
	static final BigDecimal 	TOTAL_SUPPLY 		= 16800550.0
	static final BigDecimal 	MAX_SUPPLY 			= 21000000.0
	static final BigDecimal 	CHANGE_PERCENT_1H 	= 0.75
	static final BigDecimal 	CHANGE_PERCENT_24H 	= 3.50
	static final BigDecimal 	CHANGE_PERCENT_7D 	= -14.25
	static final Long 			LAST_UPDATE_EPOCH 	= 1515852262
	
	static Coin create() {
		Coin coin = new Coin()
		coin.coinId				= COIN_ID
		coin.name				= NAME
		coin.symbol				= SYMBOL
		coin.rank				= RANK
		coin.priceUSD 			= PRICE_USD
		coin.priceBTC			= PRICE_BTC
		coin.volume24hUSD		= VOLUME_24H_USD
		coin.marketCapUSD		= MARKET_CAP_USD
		coin.availableSupply	= AVAILABLE_SUPPLY
		coin.totalSupply		= TOTAL_SUPPLY
		coin.maxSupply			= MAX_SUPPLY
		coin.changePercent1h	= CHANGE_PERCENT_1H
		coin.changePercent24h	= CHANGE_PERCENT_24H
		coin.changePercent7d	= CHANGE_PERCENT_7D
		coin.lastUpdateEpoch	= LAST_UPDATE_EPOCH
		coin
	} 
	
	static void assertAttributeValues(Coin coin) {
		assert coin.coinId 				== COIN_ID
		assert coin.name 				== NAME
		assert coin.symbol 				== SYMBOL
		assert coin.rank 				== RANK
		assert coin.priceUSD 			== PRICE_USD
		assert coin.priceBTC 			== PRICE_BTC
		assert coin.volume24hUSD 		== VOLUME_24H_USD
		assert coin.marketCapUSD 		== MARKET_CAP_USD
		assert coin.availableSupply 	== AVAILABLE_SUPPLY
		assert coin.totalSupply 		== TOTAL_SUPPLY
		assert coin.maxSupply 			== MAX_SUPPLY
		assert coin.changePercent1h 	== CHANGE_PERCENT_1H
		assert coin.changePercent24h 	== CHANGE_PERCENT_24H
		assert coin.changePercent7d 	== CHANGE_PERCENT_7D
		assert coin.lastUpdateEpoch 	== LAST_UPDATE_EPOCH
	}
	
	static void assertCoinAttributeValuesNotNull(Coin coin) {
		assert coin.coinId 				!= null 
		assert coin.name 				!= null 
		assert coin.symbol 				!= null 
		assert coin.rank 				!= null 
		assert coin.priceUSD 			!= null 
		assert coin.priceBTC 			!= null 
		assert coin.volume24hUSD 		!= null 
		assert coin.marketCapUSD 		!= null 
		assert coin.availableSupply 	!= null 
		assert coin.totalSupply 		!= null 
		assert coin.changePercent1h 	!= null 
		assert coin.changePercent24h 	!= null 
		assert coin.changePercent7d 	!= null 
		assert coin.lastUpdateEpoch 	!= null 
	}
	
	static void assertBitcoinValues(CoinOnMarketPlace comp) {
		assert comp.marketPlace.name	== "coinMarketCap"
		assert comp.coin.coinId 		== "bitcoin"
		assert comp.coin.name 			== "Bitcoin"
		assert comp.coin.symbol 		== "BTC"
		assert comp.rank 				== 1
		assert comp.priceUSD 			== 14613.5
		assert comp.priceBTC 			== 1.0
		assert comp.volume24hUSD 		== 12079400000.0
		assert comp.marketCapUSD 		== 245518197535
		assert comp.availableSupply 	== 16800550.0
		assert comp.totalSupply 		== 16800550.0
		assert comp.maxSupply 			== 21000000.0
		assert comp.changePercent1h 	== 0.75
		assert comp.changePercent24h 	== 3.50
		assert comp.changePercent7d 	== -14.25
		assert comp.lastUpdate 			== DateUtils.convertEpochMillis(1515852262)
	}
}
