package net.hemisoft.ccm.repository

import net.hemisoft.ccm.domain.CoinsOnMarketPlace
import net.hemisoft.ccm.porter.Coin
import net.hemisoft.ccm.porter.Coins

class CoinMarketCapTransformer {

	public CoinsOnMarketPlace transform(Coins marketPlaceCoins) {
		List<CoinsOnMarketPlace> marketPlaceRows = {}
		marketPlaceCoins.each { coin -> marketPlaceRows.add( transformInternal( coin ) ) }
		marketPlaceRows
	}
	
	private CoinsOnMarketPlace transformInternal(Coin coin) {
//		Coin coin 
	}
	
}
