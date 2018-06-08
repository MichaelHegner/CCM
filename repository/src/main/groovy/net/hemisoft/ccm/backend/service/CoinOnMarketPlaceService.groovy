package net.hemisoft.ccm.backend.service

import java.util.stream.Stream

import net.hemisoft.ccm.domain.CoinOnMarketPlace

interface CoinOnMarketPlaceService {
	void save(CoinOnMarketPlace comp)
	Iterable<CoinOnMarketPlace> findAll()
}
