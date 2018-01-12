package net.hemisoft.ccm.repository

import net.hemisoft.ccm.domain.CoinsOnMarketPlace
import net.hemisoft.ccm.porter.Coin

mappingFor a: CoinsOnMarketPlace, b: Coin
// automap()

a.coin.coinId		=		b.coinId
a.coin.name			=		b.name
a.coin.symbol		=		b.symbol
a.coin.rank			=		b.rank
a.priceUSD 			= 		b.priceUSD
a.priceBTC 			= 		b.priceBTC
a.volume24hUSD 		= 		b.volume24hUSD
a.marketCapUSD 		= 		b.marketCapUSD
a.availableSupply 	= 		b.availableSupply
a.totalSupply 		= 		b.totalSupply
a.maxSupply 		= 		b.maxSupply
a.changePercent1h 	= 		b.changePercent1h
a.changePercent24h 	= 		b.changePercent24h
a.changePercent7d 	= 		b.changePercent7d
a.lastUpdate 		= 		b.lastUpdate
