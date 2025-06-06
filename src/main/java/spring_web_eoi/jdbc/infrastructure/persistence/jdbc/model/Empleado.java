package spring_web_eoi.jdbc.infrastructure.persistence.jdbc.model;

import org.springframework.jdbc.core.RowMapper;
import spring_web_eoi.jdbc.domain.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Empleado implements RowMapper<Empleado> {
    public int codigoEmpleado;
    public String nombre;
    public String apellido1;
    public String apellido2;
    public String extension;
    public String email;
    public OficinaTable oficinaTable;
    public int codigoJefe;
    public String puesto;

    public int codigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String nombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String apellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String apellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String extension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OficinaTable oficina() {
        return oficinaTable;
    }

    public void setOficina(OficinaTable oficinaTable) {
        this.oficinaTable = oficinaTable;
    }

    public int codigoJefe() {
        return codigoJefe;
    }

    public void setCodigoJefe(int codigoJefe) {
        this.codigoJefe = codigoJefe;
    }

    public String puesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeCode(codigoEmpleado);
        employee.setFirstName(nombre);
        employee.setLastName1(apellido1);
        employee.setLastName2(apellido2);
        employee.setExtension(extension);
        employee.setEmail(email);
        employee.setOffice(oficinaTable.toOffice());
        employee.setManagerCode(codigoJefe);
        employee.setJobTitle(puesto);
        return employee;
    }

    @Override
    public Empleado mapRow(ResultSet rs, int rowNum) throws SQLException {
        Empleado empleado = new Empleado();

        empleado.setCodigoEmpleado(rs.getInt("codigo_empleado"));
        empleado.setNombre(rs.getString("nombre"));
        empleado.setApellido1(rs.getString("apellido1"));
        empleado.setApellido2(rs.getString("apellido2"));
        empleado.setExtension(rs.getString("extension"));
        empleado.setEmail(rs.getString("email"));
        empleado.setCodigoJefe(rs.getInt("codigo_jefe"));
        empleado.setPuesto(rs.getString("puesto"));

        OficinaTable oficinaTable = new OficinaTable();
        empleado.setOficina(oficinaTable.mapRow(rs, rowNum));
        return empleado;
    }
}
