package net.hemisoft.ccm.repository

import java.util.stream.Stream

import net.hemisoft.ccm.domain.CoinOnMarketPlace

interface CoinOnMarketPlaceService {
	CoinOnMarketPlace save(CoinOnMarketPlace comp)
	List<CoinOnMarketPlace> findAll()
}
