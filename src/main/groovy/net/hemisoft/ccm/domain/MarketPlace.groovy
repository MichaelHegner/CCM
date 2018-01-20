package net.hemisoft.ccm.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@Entity
@EqualsAndHashCode(includes = ["name"])
@ToString
class MarketPlace {
	@Id @GeneratedValue		Long id
	@Column(unique=true)	String name
}
