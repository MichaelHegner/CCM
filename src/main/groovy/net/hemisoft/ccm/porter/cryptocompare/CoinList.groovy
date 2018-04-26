package net.hemisoft.ccm.porter.cryptocompare

import com.fasterxml.jackson.annotation.JsonProperty

class CoinList {
	@JsonProperty("Response")		def repsonse
	@JsonProperty("Message")		def message
	@JsonProperty("BaseImageUrl")	def baseImageUrl
	@JsonProperty("BaseLinkUrl")	def baseLinkUrl
	@JsonProperty("Data") 			Map<String, Coin> coins;
}
