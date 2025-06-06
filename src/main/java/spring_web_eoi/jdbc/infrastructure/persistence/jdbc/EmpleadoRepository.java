package spring_web_eoi.jdbc.infrastructure.persistence.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import spring_web_eoi.jdbc.application.EmployeeRepository;
import spring_web_eoi.jdbc.domain.Employee;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbc.model.EmpleadoDetalleVentasPorGama;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbc.model.EmpleadoPorOficina;
import spring_web_eoi.jdbc.application.model.CategorySellsCount;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmpleadoRepository implements EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    public EmpleadoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Employee> findEmployeeOfOffices() {
        String sqlQuery = """
                SELECT
                    e.codigo_empleado,
                    e.nombre,
                    e.apellido1,
                    e.apellido2,
                    e.extension,
                    e.email,
                    e.codigo_oficina,
                    e.codigo_jefe,
                    e.puesto
                FROM oficina o
                    INNER JOIN empleado e
                        ON e.codigo_oficina = o.codigo_oficina
                """;

        List<EmpleadoPorOficina> empleadoPorOficinas = jdbcTemplate.query(sqlQuery, new EmpleadoPorOficina());
        return empleadoPorOficinas.stream()
                .map(EmpleadoPorOficina::toEmployee)
                .toList();
    }

    /* Obtener una lista ordenada por empleado del total las ventas de cada empleado. La lista debe mostrar el total de
    ventas de cada categoria. Se incluirá el nombre y apellidos del empleado, la ciudad de su oficina y el puesto que ocupa.
    - Total ventas por categoría
    - Nombre y apellidos empleado
    - Ciudad de su oficina
    - Puesto de oficina
    */
    @Override
    public Map<Employee, CategorySellsCount> findAllCategorySellsCountByEmployee() {
        String sqlQuery = """
                SELECT
                    pr.gama,
                    COUNT(pe) AS "total_venta",
                    e.codigo_empleado,
                    e.nombre,
                    e.apellido1,
                    e.apellido2,
                    e.extension,
                    e.email,
                    e.codigo_oficina,
                    e.codigo_jefe,
                    e.puesto,
                    o.ciudad,
                    o.pais,
                    o.region,
                    o.codigo_postal,
                    o.telefono,
                    o.linea_direccion1,
                    o.linea_direccion2
                FROM empleado e
                    INNER JOIN oficina o
                        ON e.codigo_oficina = o.codigo_oficina
                    INNER JOIN cliente c
                        ON e.codigo_empleado = c.codigo_empleado_rep_ventas
                    INNER JOIN pedido pe
                        ON c.codigo_cliente = pe.codigo_cliente
                    INNER JOIN detalle_pedido d
                        ON pe.codigo_pedido = d.codigo_pedido
                    INNER JOIN producto pr
                        ON d.codigo_producto = pr.codigo_producto
                WHERE
                    pe.estado = 'Entregado'
                GROUP BY
                    pr.gama,
                    e.codigo_empleado,
                    e.nombre,
                    e.apellido1,
                    e.apellido2,
                    e.extension,
                    e.codigo_oficina,
                    e.codigo_jefe,
                    e.puesto,
                    o.ciudad,
                    o.pais,
                    o.codigo_postal,
                    o.region,
                    o.telefono,
                    o.linea_direccion1,
                    o.linea_direccion2
                ORDER BY
                    e.nombre
                """;

        List<EmpleadoDetalleVentasPorGama> empleadoDetalleVentasPorGama = jdbcTemplate.query(sqlQuery, new EmpleadoDetalleVentasPorGama());
        return empleadoDetalleVentasPorGama.stream()
                .collect(Collectors.toMap(
                        EmpleadoDetalleVentasPorGama::toEmployee,
                        EmpleadoDetalleVentasPorGama::toCategorySellsCount,
                        (csc1, csc2) -> csc1,
                        LinkedHashMap::new
                ));
    }
}
