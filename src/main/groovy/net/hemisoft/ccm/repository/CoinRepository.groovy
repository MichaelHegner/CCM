package net.hemisoft.ccm.repository;


import net.hemisoft.ccm.domain.Coin
import org.springframework.stereotype.Repository

@Repository
public interface CoinRepository extends org.springframework.data.repository.Repository<Coin, Long> {
	Coin findByCoinIdAndName(String coinId, String name)
}