package net.hemisoft.ccm.backend.service

import javax.transaction.Transactional

import org.springframework.stereotype.Service

import net.hemisoft.ccm.backend.repository.CoinRepository
import net.hemisoft.ccm.domain.Coin
import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.utils.AssertionUtils

@Service
@Transactional
public class CoinService {
	CoinRepository repository
	
	CoinService(CoinRepository repository) {
		this.repository = repository;
	}

	Coin findOrCreateCoin(CoinOnMarketPlace comp) {
		AssertionUtils.assertNotNull comp
		def coin = comp.coin
		findOrCreateCoin coin.coinId, coin.name
	}
	
	Coin findOrCreateCoin(def coinId, def coinName) {
		AssertionUtils.assertNotNull coinId
		AssertionUtils.assertNotNull coinName
		Coin coin = repository.findByCoinIdAndName coinId, coinName
		
		if(null == coin) {
			synchronized(this) {
				coin = repository.findByCoinIdAndName coinId, coinName
				if(null == coin) {
					def newInstance = Coin.newInstance coinId: coinId, name: coinName
					coin = repository.save newInstance
				}
			}
		}
		
		coin
	}
}
