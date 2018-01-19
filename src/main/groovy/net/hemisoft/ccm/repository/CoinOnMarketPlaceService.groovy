package net.hemisoft.ccm.repository

import java.util.stream.Stream

import net.hemisoft.ccm.domain.CoinOnMarketPlace

interface CoinOnMarketPlaceService {
	void save(CoinOnMarketPlace comp)
	List<CoinOnMarketPlace> findAll()
}
