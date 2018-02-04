package net.hemisoft.ccm.repository

import javax.transaction.Transactional

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import net.hemisoft.ccm.domain.CoinOnMarketPlace

@Service
@Transactional
class CoinOnMarketPlaceServiceImpl implements CoinOnMarketPlaceService {
	@Autowired CoinRepository 				coinRepository
	@Autowired MarketPlaceRepository 		marketRepository
	@Autowired CoinsOnMarketPlaceRepository coinsOnMarketPlaceRepository;
	
	void save(CoinOnMarketPlace comp) {
		def dbCompCoin = coinRepository.findByCoinIdAndName comp.coin.coinId, comp.coin.name
		if(null != dbCompCoin) {
			comp.coin = dbCompCoin
		}

		def dbMarketPlace = marketRepository.findByName comp.marketPlace.name
		if(null != dbMarketPlace) {
			comp.marketPlace = dbMarketPlace
		}

		if(dbCompCoin && dbMarketPlace) {
			def dbComp = coinsOnMarketPlaceRepository.findByCoinAndMarketPlace(dbCompCoin, dbMarketPlace)
			if(null != dbComp) {
				comp.id = dbComp.id
			}
		}	
					
		coinsOnMarketPlaceRepository.save comp
	}

	@Override
	public Iterable<CoinOnMarketPlace> findAll() {
		coinsOnMarketPlaceRepository.findAll()
	}

}
