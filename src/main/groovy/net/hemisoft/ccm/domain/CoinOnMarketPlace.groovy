package net.hemisoft.ccm.domain

import static javax.persistence.CascadeType.MERGE
import static javax.persistence.CascadeType.PERSIST

import java.time.LocalDateTime

import javax.persistence.CascadeType
import javax.persistence.Column
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
		@UniqueConstraint(columnNames= ["coin_id", "market_place_id"]) 
)
@EqualsAndHashCode(includes = ["coin", "marketPlace"]) 
class CoinOnMarketPlace {
	@Id @GeneratedValue			Long 		id
	
	@ManyToOne(
		cascade=[PERSIST, MERGE], 
		optional = false
	)							Coin 			coin
	
	@ManyToOne(
		cascade=[PERSIST, MERGE], 
		optional = false
	)							MarketPlace 	marketPlace
	
	@Column(nullable = false)	BigDecimal		priceUSD
	@Column(nullable = false)	BigDecimal		priceBTC
	@Column(nullable = false)	BigDecimal		volume24hUSD
	@Column(nullable = false)	BigDecimal 		marketCapUSD
	@Column(nullable = false)	BigDecimal 		availableSupply
								BigDecimal 		totalSupply			
								BigDecimal 		maxSupply			
	@Column(nullable = false)	BigDecimal 		changePercent1h
	@Column(nullable = false)	BigDecimal 		changePercent24h
	@Column(nullable = false)	BigDecimal 		changePercent7d
	@Column(nullable = false)	LocalDateTime 	lastUpdate	
}
