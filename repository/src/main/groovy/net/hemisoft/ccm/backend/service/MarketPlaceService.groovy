package net.hemisoft.ccm.backend.service

import javax.transaction.Transactional

import org.springframework.messaging.Message
import org.springframework.stereotype.Service

import net.hemisoft.ccm.backend.repository.MarketPlaceRepository
import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.domain.MarketPlace

@Service
@Transactional
public class MarketPlaceService {
	MarketPlaceRepository repository
	
	public MarketPlaceService(MarketPlaceRepository repository) {
		this.repository = repository;
	}

	MarketPlace findOrCreateMarketPlace(Message<CoinOnMarketPlace> message) {
		def name = message.payload.marketPlace.name
		MarketPlace market = repository.findByName name
		
		if(null == market) {
			synchronized(this) {
				market = repository.findByName name
				if(null == market) {
					def newInstance = MarketPlace.newInstance name: name
					market = repository.save newInstance
				}
			}
		}
		
		market
	}
}
