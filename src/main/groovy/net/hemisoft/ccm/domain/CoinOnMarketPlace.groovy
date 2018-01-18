package net.hemisoft.ccm.domain

import java.time.LocalDateTime

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.UniqueConstraint

import org.hibernate.annotations.Cascade

import groovy.transform.EqualsAndHashCode

@Entity
@Table(
	uniqueConstraints=
		@UniqueConstraint(columnNames= ["coin_id"]) //, "marketPlace"
)
@EqualsAndHashCode(includes = ["coin"]) //, "marketPlace"
class CoinOnMarketPlace {
	@Id @GeneratedValue	
	Long 			id
	
	@ManyToOne(cascade=[ CascadeType.PERSIST, CascadeType.MERGE ], optional = false) 
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	Coin 			coin
	
	@ManyToOne			
	MarketPlace 	marketPlace
	
	BigDecimal		priceUSD
	BigDecimal		priceBTC
	BigDecimal		volume24hUSD
	BigDecimal 		marketCapUSD
	BigDecimal 		availableSupply
	BigDecimal 		totalSupply			// Optional
	BigDecimal 		maxSupply			// Optional
	BigDecimal 		changePercent1h
	BigDecimal 		changePercent24h
	BigDecimal 		changePercent7d
	LocalDateTime 	lastUpdate	
}
