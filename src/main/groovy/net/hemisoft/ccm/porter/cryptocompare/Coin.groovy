package net.hemisoft.ccm.porter.cryptocompare

import com.fasterxml.jackson.annotation.JsonProperty

import groovy.transform.ToString

@ToString
class Coin {
	@JsonProperty("Id") 				String 	coinId
	@JsonProperty("CoinName")			String 	name
	@JsonProperty("Name")	 			String 	symbol
	@JsonProperty("SortOrder") 			Integer rank
	@JsonProperty("USD") 				Double 	priceUSD
	@JsonProperty("BTC") 				Double 	priceBTC
//	@JsonProperty("24h_volume_usd") 	Double 	volume24hUSD
//	@JsonProperty("market_cap_usd") 	Double 	marketCapUSD
//	@JsonProperty("available_supply") 	Double 	availableSupply
//	@JsonProperty("total_supply") 		Double 	totalSupply
//	@JsonProperty("max_supply") 		Double 	maxSupply		// Optional
//	@JsonProperty("percent_change_1h") 	Double 	changePercent1h
//	@JsonProperty("percent_change_24h") Double 	changePercent24h
//	@JsonProperty("percent_change_7d") 	Double 	changePercent7d
//	@JsonProperty("last_updated") 		Long 	lastUpdateEpoch
}
