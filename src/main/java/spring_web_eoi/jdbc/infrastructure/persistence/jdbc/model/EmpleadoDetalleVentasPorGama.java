package spring_web_eoi.jdbc.infrastructure.persistence.jdbc.model;

import org.springframework.jdbc.core.RowMapper;
import spring_web_eoi.jdbc.application.model.CategorySellsCount;
import spring_web_eoi.jdbc.domain.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDetalleVentasPorGama implements RowMapper<EmpleadoDetalleVentasPorGama> {
    public String gama;
    public long totalVenta;
    public Empleado empleado;

    public String gama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public long totalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(long totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Empleado empleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Employee toEmployee() {
        return empleado.toEmployee();
    }

    public CategorySellsCount toCategorySellsCount() {
        CategorySellsCount categorySellsCount = new CategorySellsCount();
        categorySellsCount.setCategory(gama);
        categorySellsCount.setTotalSells(totalVenta);
        return categorySellsCount;
    }

    @Override
    public EmpleadoDetalleVentasPorGama mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmpleadoDetalleVentasPorGama empleadoDetalleVentasPorGama = new EmpleadoDetalleVentasPorGama();
        empleadoDetalleVentasPorGama.setGama(rs.getString("gama"));
        empleadoDetalleVentasPorGama.setTotalVenta(rs.getLong("total_venta"));

        Empleado empleado1 = new Empleado();
        empleadoDetalleVentasPorGama.setEmpleado(empleado1.mapRow(rs, rowNum));

        return empleadoDetalleVentasPorGama;
    }
}

