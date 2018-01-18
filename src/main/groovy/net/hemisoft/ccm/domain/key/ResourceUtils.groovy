package net.hemisoft.ccm.domain.key

import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource

class ResourceUtils {
	static def getMapperResource() {
		new ClassPathResource("coinmarketcap2coin.groovy").getFilename()
	}
}
