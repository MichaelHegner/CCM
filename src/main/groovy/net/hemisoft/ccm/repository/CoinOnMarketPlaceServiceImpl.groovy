package net.hemisoft.ccm.repository

import java.util.stream.Stream

import javax.transaction.Transactional

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import net.hemisoft.ccm.domain.CoinOnMarketPlace

@Service
@Transactional
class CoinOnMarketPlaceServiceImpl implements CoinOnMarketPlaceService {
	@Autowired CoinRepository coinRepository
	@Autowired MarketPlaceRepository marketRepository
	@Autowired CoinsOnMarketPlaceRepository coinsOnMarketPlaceRepository;
	
	CoinOnMarketPlace save(CoinOnMarketPlace comp) {
		def dbCompCoin = coinRepository.findByCoinIdAndName comp.coin.coinId, comp.coin.name
		
		if(null != dbCompCoin) {
			comp.coin = dbCompCoin

			def dbComp = coinsOnMarketPlaceRepository.findByCoin(dbCompCoin)
			
			if(null != dbComp) {
				comp.id = dbComp.id
			}
		}
		
		coinsOnMarketPlaceRepository.save comp
	}

	@Override
	public List<CoinOnMarketPlace> findAll() {
		coinsOnMarketPlaceRepository.findAll();
	}

}
