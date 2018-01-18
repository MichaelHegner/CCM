package net.hemisoft.ccm.repository;


import org.springframework.stereotype.Repository

import net.hemisoft.ccm.domain.MarketPlace

@Repository
public interface MarketPlaceRepository extends org.springframework.data.repository.Repository<MarketPlace, Long> {
	MarketPlace findByName(String name)
}