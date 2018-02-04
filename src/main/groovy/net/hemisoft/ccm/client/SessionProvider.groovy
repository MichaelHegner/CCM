package net.hemisoft.ccm.client

import static org.mockito.Mockito.CALLS_REAL_METHODS

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.integration.websocket.ServerWebSocketContainer
import org.springframework.stereotype.Component

@Component
class SessionProvider {
	@Autowired ServerWebSocketContainer websocketContainer;
	
	public Iterator findAllSession() {
		return websocketContainer.getSessions().keySet().iterator();
	}
}
