package spring_web_eoi.jdbc.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_web_eoi.jdbc.application.OrderService;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.JDBCOrderRepository;

@Configuration
public class OrderConfiguration {

    @Bean
    public OrderService orderService(JDBCOrderRepository jdbcOrderRepository) {
        return new OrderService(jdbcOrderRepository);
    }
}
