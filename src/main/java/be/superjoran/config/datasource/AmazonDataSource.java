package be.superjoran.config.datasource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class AmazonDataSource {
    private static final Logger LOG = LogManager.getLogger();

    @Bean
    @Profile(value = "!development")
    public DataSource dataSource(
            @Value("${application.db.owner.driver}") String driverClassname,
            @Value("${RDS_USERNAME}") String username,
            @Value("${RDS_PASSWORD}") String password,
            @Value("${RDS_DB_NAME}") String dbName,
            @Value("${RDS_HOSTNAME}") String host,
            @Value("${RDS_PORT}") String port
    ) {
        LOG.info(() -> "Using openshift datasource");
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        dataSourceBuilder.driverClassName(driverClassname)
                .username(username)
                .password(password)
                .url(String.format("jdbc:postgresql://%s:%s/%s", host, port, dbName));

        return dataSourceBuilder.build();
    }
}
