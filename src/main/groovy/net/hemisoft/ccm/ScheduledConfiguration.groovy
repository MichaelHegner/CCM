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
	@Autowired @Qualifier("coinmarketcap.request.channel")
	MessageChannel requestChannel
	
	@Scheduled(fixedRate = 1000l)
	public void reportCurrentTime() {
		requestChannel.send(MessageBuilder.withPayload("").build())
	}
}
