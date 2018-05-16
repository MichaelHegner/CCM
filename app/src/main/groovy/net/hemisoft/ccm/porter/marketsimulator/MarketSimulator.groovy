package net.hemisoft.ccm.porter.marketsimulator;

public class MarketSimulator {
	final def btcStartPrice = 10000
	final def etcStartPrice = 800
	final def bchStartPrice = 1600
	
	def btcLastPrice = btcStartPrice
	def etcLastPrice = etcStartPrice
	def bchLastPrice = bchStartPrice
	
	Coin btc = Coin.newInstance(coinId: "btc", name: "bitcoin", symbol: "btc", rank: 1, priceUSD: btcStartPrice, priceBTC: 1, volume24hUSD: 1000000, marketCapUSD: 100000, availableSupply: 1000000);
	Coin eth = Coin.newInstance(coinId: "etc", name: "ethereum", symbol: "eth", rank: 2, priceUSD: etcStartPrice, priceBTC: 0.08, volume24hUSD: 1000000, marketCapUSD: 100000, availableSupply: 1000000);
	Coin bch = Coin.newInstance(coinId: "bch", name: "bitcoin cash", symbol: "bch", rank: 3, priceUSD: bchStartPrice, priceBTC: 0.16, volume24hUSD: 1000000, marketCapUSD: 100000, availableSupply: 1000000);
	
	public def generateCoins() {
		btcLastPrice = btcLastPrice + btcLastPrice * (new Random().nextDouble() - 0.5)
		etcLastPrice = etcLastPrice + etcLastPrice * (new Random().nextDouble() - 0.5)
		bchLastPrice = bchLastPrice + bchLastPrice * (new Random().nextDouble() - 0.5)
		
		btc.priceUSD = btcLastPrice
		eth.priceUSD = etcLastPrice
		bch.priceUSD = bchLastPrice
		
		btc.priceBTC = 1
		eth.priceBTC = eth.priceUSD / btc.priceUSD
		bch.priceBTC = bch.priceUSD / btc.priceUSD
		
		btc.lastUpdateEpoch = System.currentTimeMillis()
		eth.lastUpdateEpoch = System.currentTimeMillis()
		bch.lastUpdateEpoch = System.currentTimeMillis()
		
		[btc, eth, bch]
	}
}
