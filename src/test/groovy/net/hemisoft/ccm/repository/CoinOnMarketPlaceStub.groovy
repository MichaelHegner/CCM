package net.hemisoft.ccm.repository;

import java.time.LocalDateTime

import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.stub.CoinStub
import net.hemisoft.ccm.utils.DateUtils

class CoinOnMarketPlaceStub {
	static final String 		COIN_ID				= CoinStub.COIN_ID
	static final String 		NAME 				= CoinStub.NAME
	static final String 		SYMBOL 				= CoinStub.SYMBOL
	static final int 			RANK 				= CoinStub.RANK
	
	static final BigDecimal 	PRICE_USD 			= CoinStub.PRICE_USD
	static final BigDecimal 	PRICE_BTC 			= CoinStub.PRICE_BTC
	static final BigDecimal 	VOLUME_24H_USD 		= CoinStub.VOLUME_24H_USD
	static final BigDecimal 	MARKET_CAP_USD 		= CoinStub.MARKET_CAP_USD
	static final BigDecimal 	AVAILABLE_SUPPLY 	= CoinStub.AVAILABLE_SUPPLY
	static final BigDecimal 	TOTAL_SUPPLY 		= CoinStub.TOTAL_SUPPLY
	static final BigDecimal 	MAX_SUPPLY 			= CoinStub.MAX_SUPPLY
	static final BigDecimal 	CHANGE_PERCENT_1H 	= CoinStub.CHANGE_PERCENT_1H
	static final BigDecimal 	CHANGE_PERCENT_24H 	= CoinStub.CHANGE_PERCENT_24H
	static final BigDecimal 	CHANGE_PERCENT_7D 	= CoinStub.CHANGE_PERCENT_7D
	static final LocalDateTime 	LAST_UPDATE 		= DateUtils.convertEpochMillis(CoinStub.LAST_UPDATE_EPOCH)
	
	
	static void assertAttributeValues(CoinOnMarketPlace comp) {
		assert comp.coin.coinId 		== COIN_ID
		assert comp.coin.name 			== NAME
		assert comp.coin.symbol 		== SYMBOL
		assert comp.coin.rank 			== RANK
		assert comp.priceUSD 			== PRICE_USD
		assert comp.priceBTC 			== PRICE_BTC
		assert comp.volume24hUSD 		== VOLUME_24H_USD
		assert comp.marketCapUSD 		== MARKET_CAP_USD
		assert comp.availableSupply 	== AVAILABLE_SUPPLY
		assert comp.totalSupply 		== TOTAL_SUPPLY
		assert comp.maxSupply 			== MAX_SUPPLY
		assert comp.changePercent1h 	== CHANGE_PERCENT_1H
		assert comp.changePercent24h 	== CHANGE_PERCENT_24H
		assert comp.changePercent7d 	== CHANGE_PERCENT_7D
		assert comp.lastUpdate 			== LAST_UPDATE
	}
}
