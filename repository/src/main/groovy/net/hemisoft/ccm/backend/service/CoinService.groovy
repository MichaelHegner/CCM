package net.hemisoft.ccm.backend.service

import javax.transaction.Transactional

import org.springframework.messaging.Message
import org.springframework.stereotype.Service

import net.hemisoft.ccm.backend.repository.CoinRepository
import net.hemisoft.ccm.domain.Coin
import net.hemisoft.ccm.domain.CoinOnMarketPlace

@Service
@Transactional
public class CoinService {
	CoinRepository repository
	
	public CoinService(CoinRepository repository) {
		this.repository = repository;
	}

	Coin findOrCreateCoin(Message<CoinOnMarketPlace> message) {
		def coinId = message.payload.coin.coinId
		def name = message.payload.coin.name
		findOrCreateCoin coinId, name
	}
	
	Coin findOrCreateCoin(def coinId, def name) {
		Coin coin = repository.findByCoinIdAndName coinId, name
		
		if(null == coin) {
			synchronized(this) {
				coin = repository.findByCoinIdAndName coinId, name
				if(null == coin) {
					def newInstance = Coin.newInstance coinId: coinId, name: name
					coin = repository.save newInstance
				}
			}
		}
		
		coin
	}
}
