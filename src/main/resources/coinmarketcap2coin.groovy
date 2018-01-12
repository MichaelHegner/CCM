import net.hemisoft.ccm.domain.CoinsOnMarketPlace
import net.hemisoft.ccm.porter.Coin


mappingFor comp: CoinsOnMarketPlace, coin: Coin
comp.priceUSD 		= 		coin.priceUSD
