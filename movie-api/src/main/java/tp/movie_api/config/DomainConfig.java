package tp.movie_api.config;

import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("tp.movie_api.domain")
@EnableJpaRepositories("tp.movie_api.repos")
@EnableTransactionManagement
public class DomainConfig {
}
