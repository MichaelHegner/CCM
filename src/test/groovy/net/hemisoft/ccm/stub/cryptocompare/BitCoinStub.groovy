package net.hemisoft.ccm.stub.cryptocompare

import net.hemisoft.ccm.porter.cryptocompare.Coin

class BitCoinStub {
	static final String			MARKET_PLACE_NAME	= "cryptoCompare"
	static final String 		COIN_ID				= "bitcoin"
	static final String 		NAME 				= "Bitcoin"
	static final String 		SYMBOL 				= "BTC"
	static final int 			RANK 				= 1
	
	static final BigDecimal 	PRICE_USD 			= 14613.5
	static final BigDecimal 	PRICE_BTC 			= 1.0
	static final BigDecimal 	VOLUME_24H_USD 		= 12079400000.0
	static final BigDecimal 	MARKET_CAP_USD 		= 245518197535
	static final BigDecimal 	AVAILABLE_SUPPLY 	= 16800550.0
	static final BigDecimal 	CHANGE_PERCENT_24H 	= 3.50
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
		coin.changePercent24h	= CHANGE_PERCENT_24H
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
		assert coin.changePercent24h 	== CHANGE_PERCENT_24H
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
		assert coin.changePercent24h 	!= null 
		assert coin.lastUpdateEpoch 	!= null 
	}
}
