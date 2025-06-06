package spring_web_eoi.jdbc.infrastructure.controller.model;

import spring_web_eoi.jdbc.domain.Employee;

public record EmpleadoPorOficinaDTO(
        int codigo_empleado,
        String nombre,
        String apellido1,
        String apellido2,
        String email,
        String puesto
) {
    public static EmpleadoPorOficinaDTO fromEmployee(Employee employee) {
        return new EmpleadoPorOficinaDTO(
                employee.employeeCode(),
                employee.firstName(),
                employee.lastName1(),
                employee.lastName2(),
                employee.email(),
                employee.jobTitle()
        );
    }
}
