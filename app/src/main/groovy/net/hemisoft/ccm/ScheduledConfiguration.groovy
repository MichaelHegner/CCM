package net.hemisoft.ccm;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.support.MessageBuilder
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
class ScheduledConfiguration {
	@Autowired @Qualifier("coinmarketcap.request.channel") 		MessageChannel coinmarketcapChannel
	@Autowired @Qualifier("cryptocompare.request.channel") 		MessageChannel cryptocompareChannel
	@Autowired @Qualifier("marketsimulator.request.channel") 	MessageChannel marketsimulatorChannel
	
	@Scheduled(fixedRate = 10000l)
	void startCoinMarketCapUpdates() {
		def request = MessageBuilder.withPayload("").build()
		coinmarketcapChannel.send 	request, 10000
	}
	
	@Scheduled(fixedRate = 10000l)
	void startCryptoCompareUpdates() {
		def request = MessageBuilder.withPayload("").build()
		cryptocompareChannel.send 	request, 10000
	}
	
	
	@Scheduled(fixedRate = 1000l)
	void startMarketSimulatorUpdates() {
		def request = MessageBuilder.withPayload("").build()
		marketsimulatorChannel.send request, 10000
	}
}
