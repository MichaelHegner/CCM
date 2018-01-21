package net.hemisoft.ccm.utils

import org.springframework.core.io.ClassPathResource

class ResourceUtils {
	static def getMapperResource() {
		ClassPathResource.newInstance("coinmarketcap2coin.groovymapper").filename
	}
}
