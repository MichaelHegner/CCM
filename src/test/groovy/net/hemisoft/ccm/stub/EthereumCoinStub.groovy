package net.hemisoft.ccm.stub

import net.hemisoft.ccm.porter.Coin

class EthereumCoinStub {
	static final String			MARKET_PLACE_NAME	= "coinMarketPlace"
	static final String 		COIN_ID				= "ethereum"
	static final String 		NAME 				= "Ethereum"
	static final String 		SYMBOL 				= "ETH"
	static final int 			RANK 				= 2
	
	static final BigDecimal 	PRICE_USD 			= 1372.18
	static final BigDecimal 	PRICE_BTC 			= 0.0942203
	static final BigDecimal 	VOLUME_24H_USD 		= 4984240000.0
	static final BigDecimal 	MARKET_CAP_USD 		= 133039071219
	static final BigDecimal 	AVAILABLE_SUPPLY 	= 96954533.0
	static final BigDecimal 	TOTAL_SUPPLY 		= 96954533.0
	static final BigDecimal 	MAX_SUPPLY 			= null
	static final BigDecimal 	CHANGE_PERCENT_1H 	= 0.27
	static final BigDecimal 	CHANGE_PERCENT_24H 	= 7.36
	static final BigDecimal 	CHANGE_PERCENT_7D 	= 32.52
	static final Long 			LAST_UPDATE_EPOCH 	= 1515852250
	
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
