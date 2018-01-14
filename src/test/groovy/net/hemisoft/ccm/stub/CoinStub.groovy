package net.hemisoft.ccm.stub

import net.hemisoft.ccm.porter.Coin

class CoinStub {
	static final String 		COIN_ID				= "BTC"
	static final String 		NAME 				= "Bitcoin"
	static final String 		SYMBOL 				= "(B)"
	static final int 			RANK 				= 1
	
	static final BigDecimal 	PRICE_USD 			= 1.0
	static final BigDecimal 	PRICE_BTC 			= 0.01
	static final BigDecimal 	VOLUME_24H_USD 		= 1_000_000
	static final BigDecimal 	MARKET_CAP_USD 		= 1_000_000
	static final BigDecimal 	AVAILABLE_SUPPLY 	= 500_000
	static final BigDecimal 	TOTAL_SUPPLY 		= 800_000
	static final BigDecimal 	MAX_SUPPLY 			= 2_000_000
	static final BigDecimal 	CHANGE_PERCENT_1H 	= 1.02
	static final BigDecimal 	CHANGE_PERCENT_24H 	= 4.03
	static final BigDecimal 	CHANGE_PERCENT_7D 	= -10.11
	static final Long 			LAST_UPDATE_EPOCH 	= 1515791406
	
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
}
