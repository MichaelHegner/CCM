package net.hemisoft.ccm.backend.service;

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import net.hemisoft.ccm.backend.repository.RepositoryConfig

@Configuration
@Import(RepositoryConfig)
@ComponentScan
public class ServiceConfig {}