package net.hemisoft.ccm.repository

import java.time.ZoneId

import net.hemisoft.ccm.utils.DateUtils

import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.porter.Coin

mappingFor a: CoinOnMarketPlace, b: Coin
introspector exploding 
automap()

a.coin.coinId		=		b.coinId
a.coin.name			=		b.name
a.coin.symbol		=		b.symbol
a.coin.rank			=		b.rank

a.lastUpdate		= 		b.lastUpdateEpoch
convert to_a: { lastUpdateEpoch -> DateUtils.convertEpochMillis(lastUpdateEpoch) }
convert to_b: { lastUpdate -> DateUtils.convertLocalDateTime(lastUpdate) }