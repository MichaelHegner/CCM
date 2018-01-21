package net.hemisoft.ccm.repository;


import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.history.RevisionRepository
import org.springframework.stereotype.Repository

import net.hemisoft.ccm.domain.Coin
import net.hemisoft.ccm.domain.CoinOnMarketPlace

@Repository
public interface CoinRepository extends RevisionRepository<Coin, Long, Integer>, CrudRepository<Coin, Long> {
	Coin findByCoinIdAndName(String coinId, String name)
}