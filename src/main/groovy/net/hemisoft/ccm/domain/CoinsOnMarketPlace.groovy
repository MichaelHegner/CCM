package net.hemisoft.ccm.domain

import java.time.LocalDateTime

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class CoinsOnMarketPlace {
	@Id @GeneratedValue			Long id
	@ManyToOne					Coin coin
	@ManyToOne					MarketPlace marketPlace
	
	BigDecimal priceUSD
	BigDecimal priceBTC
 	BigDecimal volume24hUSD
 	BigDecimal marketCapUSD
	BigDecimal availableSupply
	BigDecimal totalSupply
	BigDecimal maxSupply		// Optional
	BigDecimal changePercent1h
	BigDecimal changePercent24h
	BigDecimal changePercent7d
	Long lastUpdate	// TODO: Make LocalDateTime
	
	CoinsOnMarketPlace() {}
}
