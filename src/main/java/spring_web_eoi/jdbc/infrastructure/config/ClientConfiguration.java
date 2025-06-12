package spring_web_eoi.jdbc.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_web_eoi.jdbc.application.ClientService;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.JDBCClientRepository;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.JDBCOrderRepository;

@Configuration
public class ClientConfiguration {

    @Bean
    public ClientService clientService(JDBCClientRepository jdbcClientRepository, JDBCOrderRepository jdbcOrderRepository) {
        return new ClientService(jdbcClientRepository, jdbcOrderRepository);
    }
}
