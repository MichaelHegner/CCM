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
	@Autowired @Qualifier("coinmarketcap.request.channel") MessageChannel coinmarketcapChannel
	@Autowired @Qualifier("cryptocompare.request.channel") MessageChannel cryptocompareChannel
	
	@Scheduled(fixedRate = 1000l)
	void startCoinUpdates() {
		def request = MessageBuilder.withPayload("").build()
		coinmarketcapChannel.send request, 10000
		cryptocompareChannel.send request, 10000
	}
}
