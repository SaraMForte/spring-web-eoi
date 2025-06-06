package spring_web_eoi.jdbc.infrastructure.controller.model;

import spring_web_eoi.jdbc.application.model.CategorySellsCount;
import spring_web_eoi.jdbc.domain.Employee;

public record EmpleadoDetalleVentasPorGamaDTO(
        String gama,
        long totalVenta,
        String nombreEmpleado,
        String apellido1Empleado,
        String apellido2Empleado,
        String ciudadOficina,
        String puestoEmpleado
) {

    @Override
    public String toString() {
        return "EmpleadoDetalleVentasPorGamaDTO{" +
               "gama='" + gama + '\'' +
               ", totalVenta=" + totalVenta +
               ", nombreEmpleado='" + nombreEmpleado + '\'' +
               ", apellido1Empleado='" + apellido1Empleado + '\'' +
               ", apellido2Empleado='" + apellido2Empleado + '\'' +
               ", ciudadOficina='" + ciudadOficina + '\'' +
               ", puestoEmpleado='" + puestoEmpleado + '\'' +
               '}';
    }

    public static EmpleadoDetalleVentasPorGamaDTO fromEmpleadoDetalleVentasPorGama(
            Employee employee,
            CategorySellsCount categorySellsCount
    ) {
        return new EmpleadoDetalleVentasPorGamaDTO(
                categorySellsCount.category(),
                categorySellsCount.totalSells(),
                employee.firstName(),
                employee.lastName1(),
                employee.lastName2(),
                employee.office().city(),
                employee.jobTitle()
        );
    }
}
