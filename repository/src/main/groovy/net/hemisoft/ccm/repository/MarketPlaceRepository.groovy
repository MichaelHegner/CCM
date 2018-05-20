package net.hemisoft.ccm.repository;


import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.history.RevisionRepository
import org.springframework.stereotype.Repository

import net.hemisoft.ccm.domain.MarketPlace

@Repository
public interface MarketPlaceRepository extends RevisionRepository<MarketPlace, Long, Integer>, CrudRepository<MarketPlace, Long> {
	MarketPlace findByName(String name)
}