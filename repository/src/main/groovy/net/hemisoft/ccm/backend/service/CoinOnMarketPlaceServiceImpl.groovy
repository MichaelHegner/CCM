package net.hemisoft.ccm.backend.service

import static org.springframework.beans.BeanUtils.copyProperties

import javax.transaction.Transactional

import org.springframework.stereotype.Service

import net.hemisoft.ccm.backend.repository.CoinsOnMarketPlaceRepository
import net.hemisoft.ccm.domain.CoinOnMarketPlace
import net.hemisoft.ccm.utils.AssertionUtils

@Service
@Transactional
class CoinOnMarketPlaceServiceImpl implements CoinOnMarketPlaceService {
	CoinsOnMarketPlaceRepository repository;
	
	CoinOnMarketPlaceServiceImpl(CoinsOnMarketPlaceRepository repository) {
		this.repository = repository;
	}

	CoinOnMarketPlace save(CoinOnMarketPlace comp) {
		AssertionUtils.assertNotNull(comp)
		def dbComp = repository.findByCoinAndMarketPlace comp.coin, comp.marketPlace
		
		if(null == dbComp) {
			synchronized(this) {
				dbComp = repository.findByCoinAndMarketPlace comp.coin, comp.marketPlace
				if(null == dbComp) {
					dbComp = repository.save comp
				} else {
					copyProperties(comp, dbComp, "id")
				}
			}
		} else {
			copyProperties(comp, dbComp, "id")
		}
		
		dbComp
	}

	@Override
	Iterable<CoinOnMarketPlace> findAll() {
		repository.findAll()
	}
}
