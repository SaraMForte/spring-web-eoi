package spring_web_eoi.jdbc.application;

import spring_web_eoi.jdbc.application.exception.DataOperationException;
import spring_web_eoi.jdbc.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    void saveOrder(Order order) throws DataOperationException;

    List<Order> findAllOrders() throws DataOperationException;

    Optional<Order> findOrderById(int id) throws DataOperationException;

    void updateOrder(Order order) throws DataOperationException;

    void deleteOrderById(int id) throws DataOperationException;
}
