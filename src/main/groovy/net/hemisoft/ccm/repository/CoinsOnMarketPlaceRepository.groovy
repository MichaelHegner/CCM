package net.hemisoft.ccm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.hemisoft.ccm.domain.CoinOnMarketPlace;

public interface CoinsOnMarketPlaceRepository extends JpaRepository<CoinOnMarketPlace, Long> {}