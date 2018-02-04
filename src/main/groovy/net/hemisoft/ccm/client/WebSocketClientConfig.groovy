package net.hemisoft.ccm.client

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import org.springframework.integration.config.EnableIntegrationManagement

@Configuration
@EnableIntegrationManagement
@ImportResource("classpath:/net/hemisoft/ccm/client/clientapi.xml")
class WebSocketClientConfig {}