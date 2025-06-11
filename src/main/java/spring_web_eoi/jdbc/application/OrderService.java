package spring_web_eoi.jdbc.application;

import spring_web_eoi.jdbc.application.exception.DataOperationException;
import spring_web_eoi.jdbc.domain.Order;

import java.util.List;
import java.util.Optional;

public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(Order order) throws DataOperationException {
        orderRepository.saveOrder(order);
    }

    public List<Order> findAll() throws DataOperationException {
        return orderRepository.findAllOrders();
    }

    public Optional<Order> findById(int id) throws DataOperationException {
        return orderRepository.findOrderById(id);
    }

    public void update(Order order) throws DataOperationException {
        orderRepository.updateOrder(order);
    }

    public void deleteById(int id) throws DataOperationException {
        orderRepository.deleteOrderById(id);
    }

}
