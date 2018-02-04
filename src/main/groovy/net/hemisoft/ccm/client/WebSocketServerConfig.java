package net.hemisoft.ccm.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegrationManagement;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@Configuration
@EnableWebSocket
@EnableIntegrationManagement
@ImportResource("classpath:/net/hemisoft/ccm/client/serverapi.xml")
public class WebSocketServerConfig {}