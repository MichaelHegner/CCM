package net.hemisoft.ccm.backend.service

import javax.transaction.Transactional

import org.springframework.stereotype.Service

import net.hemisoft.ccm.backend.repository.MarketPlaceRepository
import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.domain.MarketPlace
import net.hemisoft.ccm.utils.AssertionUtils

@Service
@Transactional
public class MarketPlaceService {
	MarketPlaceRepository repository
	
	public MarketPlaceService(MarketPlaceRepository repository) {
		this.repository = repository;
	}
	
	MarketPlace findOrCreateMarketPlace(data) {
		AssertionUtils.assertNotNull data
		switch (data) {
			case CoinOnMarketPlace:
				findOrCreateMarketPlaceByComp data
            	break
			case String:
            	findOrCreateMarketPlaceByName data
            	break
		}
	}
	
	private MarketPlace findOrCreateMarketPlaceByComp(CoinOnMarketPlace comp) {
		def name = comp.marketPlace.name
		findOrCreateMarketPlace name
	}

	private MarketPlace findOrCreateMarketPlaceByName(String name) {
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
