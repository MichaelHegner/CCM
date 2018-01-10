package net.hemisoft.ccm.domain

import com.fasterxml.jackson.annotation.JsonProperty

import groovy.transform.ToString

@ToString
class Coin {
	@JsonProperty("id") 				def coinId
	@JsonProperty("name") 				def name
	@JsonProperty("symbol") 			def symbol
	@JsonProperty("rank") 				def rank
	@JsonProperty("price_usd") 			def priceUSD
	@JsonProperty("price_btc") 			def priceBTC
	@JsonProperty("24h_volume_usd") 	def volume24hUSD
	@JsonProperty("market_cap_usd") 	def marketCapUSD
	@JsonProperty("available_supply") 	def availableSupply
	@JsonProperty("total_supply") 		def totalSupply
	@JsonProperty("max_supply") 		def maxSupply		// Optional
	@JsonProperty("percent_change_1h") 	def changePercent1h
	@JsonProperty("percent_change_24h") def changePercent24h
	@JsonProperty("percent_change_7d") 	def changePercent7d
	@JsonProperty("last_updated") 		def lastUpdate
}
