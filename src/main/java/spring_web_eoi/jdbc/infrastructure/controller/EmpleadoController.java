package spring_web_eoi.jdbc.infrastructure.controller;

import spring_web_eoi.jdbc.application.EmployeeService;
import spring_web_eoi.jdbc.application.model.CategorySellsCount;
import spring_web_eoi.jdbc.domain.Employee;
import spring_web_eoi.jdbc.infrastructure.controller.model.EmpleadoDetalleVentasPorGamaDTO;
import spring_web_eoi.jdbc.infrastructure.controller.model.EmpleadoPorOficinaDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("java:S106")
public class EmpleadoController {

    private EmployeeService employeeService;

    public EmpleadoController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void printEmployeeOfOffice() {
        employeeService.findEmployeeOfOffices()
                .stream()
                .map(EmpleadoPorOficinaDTO::fromEmployee)
                .forEach(System.out::println);
    }

    public void printAllCategorySellsCountByEmployee() {
        Map<Employee, CategorySellsCount> employeeCategory = employeeService.findAllCategorySellsCountByEmployee();
        Map<String, List<EmpleadoDetalleVentasPorGamaDTO>> empleadoVentaPorCategoria = new HashMap<>();

        employeeCategory.entrySet()
                .forEach(entry -> {
                    putToEmployeeByCategory(empleadoVentaPorCategoria, entry);
                    showEmployeeByCategory(empleadoVentaPorCategoria);
                });
    }

    private void putToEmployeeByCategory(
            Map<String, List<EmpleadoDetalleVentasPorGamaDTO>> empleadoVentaPorCategoria,
            Map.Entry<Employee, CategorySellsCount> entry
    ) {
        empleadoVentaPorCategoria
                .computeIfAbsent(entry.getValue().category(), list -> new ArrayList<>())
                .add(EmpleadoDetalleVentasPorGamaDTO.fromEmpleadoDetalleVentasPorGama(
                                entry.getKey(),
                                entry.getValue()
                        )
                );
    }

    private void showEmployeeByCategory(Map<String, List<EmpleadoDetalleVentasPorGamaDTO>> empleadoVentaPorCategoria) {
        empleadoVentaPorCategoria
                .forEach((category, list) -> {
                    System.out.println("- ".repeat(40) + category + " -".repeat(40));
                    System.out.printf(" %-25s %-25s %-25s %-25s %-25s %n" ,
                            "Total Ventas",
                            "Nombre Empleado",
                            "Apellidos Empleado",
                            "Ciudad de la Oficina",
                            "Puesto del Empleado"
                            );
                    System.out.println("-".repeat(150));

                    list.forEach(element -> System.out.printf(
                            "%-25s %-25s %-25s %-25s %-25s %n",
                            element.totalVenta(),
                            element.nombreEmpleado(),
                            element.apellido1Empleado() + " " + element.apellido2Empleado(),
                            element.ciudadOficina(),
                            element.puestoEmpleado()
                    ));
                });
    }
}