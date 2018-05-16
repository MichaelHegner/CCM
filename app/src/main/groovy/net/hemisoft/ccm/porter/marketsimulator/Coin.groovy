package net.hemisoft.ccm.porter.marketsimulator

import com.fasterxml.jackson.annotation.JsonProperty

import groovy.transform.ToString

@ToString
class Coin {
	String 	coinId
	String 	name
	String 	symbol
	Integer rank
	Double 	priceUSD
	Double 	priceBTC
	Double 	volume24hUSD
	Double 	marketCapUSD
	Double 	availableSupply
	Double 	totalSupply
	Double 	maxSupply		// Optional
	Double 	changePercent1h
	Double 	changePercent24h
	Double 	changePercent7d
	Long 	lastUpdateEpoch
}
