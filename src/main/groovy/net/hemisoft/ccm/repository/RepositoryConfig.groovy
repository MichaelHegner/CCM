package net.hemisoft.ccm.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.hemisoft.ccm.domain.DomainConfig;

@Configuration
@Import(DomainConfig)
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories("net.hemisoft.ccm.repository")
@ComponentScan
public class RepositoryConfig {}