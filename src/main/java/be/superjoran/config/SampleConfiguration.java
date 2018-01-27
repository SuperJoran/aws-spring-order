package be.superjoran.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan({"be.superjoran.domain", "be.superjoran.domain.searchresult"})
@EnableJpaRepositories({"be.superjoran.dao"})
@ComponentScan({"be.superjoran.services", "be.superjoran.controllers", "be.superjoran.config.datasource", "be.superjoran.batch"})
@PropertySource(value = "classpath:configuration/${application.config}/application.properties", ignoreResourceNotFound = true)
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableBatchProcessing
@EnableScheduling
public class SampleConfiguration {

}
