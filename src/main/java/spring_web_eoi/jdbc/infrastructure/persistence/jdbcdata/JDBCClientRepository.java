package spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring_web_eoi.jdbc.application.ClientRepository;
import spring_web_eoi.jdbc.application.exception.DataOperationException;
import spring_web_eoi.jdbc.domain.Client;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbcdata.model.ClienteJDBC;

import java.util.List;
import java.util.Optional;

@Repository
public interface JDBCClientRepository extends
        ListCrudRepository<ClienteJDBC, Integer>,
        ClientRepository {

    @Override
    @Modifying
    @Query("""
                       INSERT INTO cliente
                           (
                            codigo_cliente,
                            nombre_cliente,
                            nombre_contacto,
                            apellido_contacto,
                            telefono,
                            fax,
                            linea_direccion1,
                            linea_direccion2,
                            ciudad,
                            region,
                            pais,
                            codigo_postal,
                            codigo_empleado_rep_ventas,
                            limite_credito
                            )
                       VALUES
                           (
                            :#{#client.clientCode},
                            :#{#client.firstName},
                            :#{#client.contactName},
                            :#{#client.contactLastName},
                            :#{#client.contactPhone},
                            :#{#client.fax},
                            :#{#client.addressLine1},
                            :#{#client.addressLine2},
                            :#{#client.city},
                            :#{#client.region},
                            :#{#client.country},
                            :#{#client.postalCode},
                            :#{#client.employeeSalesRepresentativeCode},
                            :#{#client.creditLimit}
                             )
            """)
    void saveClient(Client client) throws DataOperationException;

    @Override
    @Query("""
            SELECT
                codigo_cliente AS client_code,
                nombre_cliente AS first_name,
                nombre_contacto AS contact_name,
                apellido_contacto AS contact_last_name,
                telefono AS contact_phone,
                fax AS fax,
                linea_direccion1 AS address_line1,
                linea_direccion2 AS address_line2,
                ciudad AS city,
                region AS region,
                pais AS country,
                codigo_postal AS postal_code,
                codigo_empleado_rep_ventas AS employee_sales_representative_code,
                limite_credito AS credit_limit
            FROM cliente
            WHERE
                activo = true
            ORDER BY
                codigo_cliente
            """)
    List<Client> findAllClients() throws DataOperationException;

    @Override
    @Query("""
            SELECT
                codigo_cliente AS client_code,
                nombre_cliente AS first_name,
                nombre_contacto AS contact_name,
                apellido_contacto AS contact_last_name,
                telefono AS contact_phone,
                fax AS fax,
                linea_direccion1 AS address_line1,
                linea_direccion2 AS address_line2,
                ciudad AS city,
                region AS region,
                pais AS country,
                codigo_postal AS postal_code,
                codigo_empleado_rep_ventas AS employee_sales_representative_code,
                limite_credito AS credit_limit
            FROM cliente
            WHERE
                codigo_cliente = :id
            """)
    Optional<Client> findClientById(@Param("id") int id) throws DataOperationException;

    @Override
    @Modifying
    @Query("""
            UPDATE cliente
            SET
                nombre_cliente = :#{#client.firstName},
                nombre_contacto = :#{#client.contactName},
                apellido_contacto = :#{#client.contactLastName},
                telefono = :#{#client.contactPhone},
                fax = :#{#client.fax},
                linea_direccion1 = :#{#client.addressLine1},
                linea_direccion2 = :#{#client.addressLine2},
                ciudad = :#{#client.city},
                region = :#{#client.region},
                pais = :#{#client.country},
                codigo_postal = :#{#client.postalCode},
                codigo_empleado_rep_ventas = :#{#client.employeeSalesRepresentativeCode},
                limite_credito = :#{#client.creditLimit}
            WHERE
                codigo_cliente = :#{#client.clientCode}
            """)
    void updateClient(Client client) throws DataOperationException;

    @Override
    @Modifying
    @Query("""
            UPDATE cliente
            SET
                activo = false
            WHERE
                codigo_cliente = :id
            """)
    void deleteClientById(@Param("id") int id) throws DataOperationException;
}
