package net.hemisoft.ccm.utils

import org.springframework.core.io.ClassPathResource

class ResourceUtils {
	static def getCoinMarketCapMapperResource() {
		ClassPathResource.newInstance("coinmarketcap2coin.groovymapper").filename
	}
	
	static def getCryptoCompareMapperResource() {
		ClassPathResource.newInstance("cryptocompare2coin.groovymapper").filename
	}
}
