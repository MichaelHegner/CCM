package net.hemisoft.ccm.backend.repository;


import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.history.RevisionRepository
import org.springframework.stereotype.Repository

import net.hemisoft.ccm.domain.Coin

@Repository
public interface CoinRepository extends RevisionRepository<Coin, Long, Integer>, CrudRepository<Coin, Long> {
	Coin findByCoinIdAndName(String coinId, String name)
}