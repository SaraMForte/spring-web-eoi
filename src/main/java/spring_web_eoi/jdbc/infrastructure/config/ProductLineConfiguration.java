package spring_web_eoi.jdbc.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_web_eoi.jdbc.application.ProductLineService;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.JDBCProductLineRepository;

@Configuration
public class ProductLineConfiguration {

    @Bean
    public ProductLineService productLineService(JDBCProductLineRepository jdbcProductLineRepository) {
        return new ProductLineService(jdbcProductLineRepository);
    }
}
