package spring_web_eoi.jdbc.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_web_eoi.jdbc.application.ProductLineService;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.JDBCProductLineRepository;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.JDBCProductRepository;

@Configuration
public class ProductLineConfiguration {

    @Bean
    public ProductLineService productLineService(
            JDBCProductLineRepository jdbcProductLineRepository,
            JDBCProductRepository jdbcProductRepository
    ) {
        return new ProductLineService(jdbcProductLineRepository, jdbcProductRepository);
    }
}
