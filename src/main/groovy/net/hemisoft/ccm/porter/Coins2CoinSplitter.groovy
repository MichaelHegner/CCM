package net.hemisoft.ccm.porter

import org.springframework.integration.splitter.AbstractMessageSplitter
import org.springframework.messaging.Message

class Coins2CoinSplitter {

	public List<Coin> splitMessage(Coins coins) {
		List<Coin> coinList = new ArrayList<>()
		coins.each{coinList.add it}
		return coinList 
	}
	
}
