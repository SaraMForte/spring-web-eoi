package spring_web_eoi.jdbc.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_web_eoi.jdbc.application.ProductService;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.JDBCProductRepository;

@Configuration
public class ProductConfiguration {

    @Bean
    public ProductService productService(JDBCProductRepository jdbcProductRepository) {
        return new ProductService(jdbcProductRepository);
    }
}
