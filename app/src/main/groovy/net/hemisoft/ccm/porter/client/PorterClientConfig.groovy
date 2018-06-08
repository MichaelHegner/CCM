package net.hemisoft.ccm.porter.client

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.ImportResource

import net.hemisoft.ccm.backend.repository.RepositoryConfig

@Configuration
@Import(RepositoryConfig)
@ImportResource("classpath:/net/hemisoft/ccm/porter/client/client-api.xml")
class PorterClientConfig {}