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
	@JsonProperty("VOLUME24HOUR") 		Double 	volume24hUSD
	@JsonProperty("MKTCAP") 			Double 	marketCapUSD
	@JsonProperty("SUPPLY") 			Double 	availableSupply
	@JsonProperty("CHANGEPCT24HOUR") 	Double 	changePercent24h
	@JsonProperty("LASTUPDATE") 		Long 	lastUpdateEpoch
}
