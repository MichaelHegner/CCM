package net.hemisoft.ccm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository

import net.hemisoft.ccm.domain.Coin
import net.hemisoft.ccm.domain.CoinOnMarketPlace;

@Repository
public interface CoinsOnMarketPlaceRepository extends JpaRepository<CoinOnMarketPlace, Long> {
	CoinOnMarketPlace findByCoin(Coin coin)
}