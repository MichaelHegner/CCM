package net.hemisoft.ccm.utils

import org.springframework.util.Assert

class AssertionUtils {
	
	static void assertNotNull(def entity) {
		Assert.notNull(entity, entity.getClass().simpleName + " must not be null.")
	}
}
