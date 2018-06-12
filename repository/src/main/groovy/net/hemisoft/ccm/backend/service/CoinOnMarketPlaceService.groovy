package net.hemisoft.ccm.backend.service

import net.hemisoft.ccm.domain.CoinOnMarketPlace

interface CoinOnMarketPlaceService {
	CoinOnMarketPlace save(CoinOnMarketPlace comp)
	Iterable<CoinOnMarketPlace> findAll()
}
