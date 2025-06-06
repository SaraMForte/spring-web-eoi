package spring_web_eoi.jdbc.infrastructure.persistence.jdbc.model;

import org.springframework.jdbc.core.RowMapper;
import spring_web_eoi.jdbc.domain.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoPorOficina implements RowMapper<EmpleadoPorOficina> {
    private int codigo_empleado;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String puesto;

    public int codigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
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

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String puesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeCode(codigo_empleado);
        employee.setFirstName(nombre);
        employee.setLastName1(apellido1);
        employee.setLastName2(apellido2);
        employee.setEmail(email);
        employee.setJobTitle(puesto);
        return employee;
    }


    @Override
    public EmpleadoPorOficina mapRow(ResultSet rs, int rowNum) throws SQLException {
        EmpleadoPorOficina empleado = new EmpleadoPorOficina();
        empleado.setCodigo_empleado(rs.getInt("codigo_empleado"));
        empleado.setNombre(rs.getString("nombre"));
        empleado.setApellido1(rs.getString("apellido1"));
        empleado.setApellido2(rs.getString("apellido2"));
        empleado.setEmail(rs.getString("email"));
        empleado.setPuesto(rs.getString("puesto"));
        return empleado;
    }
}
