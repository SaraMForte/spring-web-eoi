package spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_web_eoi.jdbc.application.OrderRepository;
import spring_web_eoi.jdbc.application.exception.DataOperationException;
import spring_web_eoi.jdbc.domain.Order;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.model.PedidoJDBC;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public interface JDBCOrderRepository extends ListCrudRepository<PedidoJDBC, Integer>, OrderRepository {

    @Override
    @Modifying
    @Query("""
            UPDATE pedido
            SET
                activo = false
            WHERE
                codigo_pedido = :id
            """)
    void deleteOrderById(@Param("id") int id) throws DataOperationException;

    @Override
    default void updateOrder(Order order) throws DataOperationException {
        save(PedidoJDBC.fromDomain(order));
    }

    @Override
    default Optional<Order> findOrderById(int id) throws DataOperationException {
        return findById(id).map(PedidoJDBC::toDomain);
    }

    @Override
    default List<Order> findAllOrders() throws DataOperationException {
        return findAll().stream()
                .filter(PedidoJDBC::activo)
                .sorted(Comparator.comparingInt(PedidoJDBC::codigoPedido))
                .map(PedidoJDBC::toDomain)
                .toList();
    }

    @Override
    @Modifying
    @Query("""
            INSERT INTO pedido
                (
                 codigo_pedido,
                 fecha_pedido,
                 fecha_esperada,
                 fecha_entrega,
                 estado,
                 comentarios,
                 codigo_cliente
                 )
            VALUES
                (
                 :#{#order.orderCode},
                 :#{#order.orderDate},
                 :#{#order.expectedDate},
                 :#{#order.deliveryDate},
                 :#{#order.status},
                 :#{#order.comment},
                 :#{#order.clientCode}
                  )
            """)
    void saveOrder(Order order) throws DataOperationException;
}
