package net.hemisoft.ccm.repository

import net.hemisoft.ccm.domain.CoinsOnMarketPlace
import net.hemisoft.ccm.porter.Coin

mappingFor a: CoinsOnMarketPlace, b: Coin
introspector exploding 
automap()

a.coin.coinId		=		b.coinId
a.coin.name			=		b.name
a.coin.symbol		=		b.symbol
a.coin.rank			=		b.rank