package net.hemisoft.ccm.backend;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.hemisoft.ccm.domain.DomainConfig;

@Configuration
@ImportResource("classpath:/net/hemisoft/ccm/backend/backend-api.xml")
@EnableAutoConfiguration
@ComponentScan
public class BackendConfig {}