package net.hemisoft.ccm.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class MarketPlace {
	@Id @GeneratedValue		Long id
							String name
}
