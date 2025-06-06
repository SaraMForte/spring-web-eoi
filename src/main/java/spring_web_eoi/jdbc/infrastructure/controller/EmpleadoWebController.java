package spring_web_eoi.jdbc.infrastructure.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring_web_eoi.jdbc.application.EmployeeService;
import spring_web_eoi.jdbc.application.EmployeeServiceImpl;
import spring_web_eoi.jdbc.infrastructure.controller.model.EmpleadoDetalleVentasPorGamaDTO;
import spring_web_eoi.jdbc.infrastructure.persistence.jdbc.EmpleadoRepository;
import spring_web_eoi.jdbc.infrastructure.util.GenericTableGenerator;

import java.util.List;

@Controller
public class EmpleadoWebController {

    JdbcTemplate jdbcTemplate;
    EmployeeService employeeService;

    public EmpleadoWebController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.employeeService = new EmployeeServiceImpl(new EmpleadoRepository(jdbcTemplate));
    }

    @GetMapping("/generic/empleado-detalle-ventas")
    public String genericEmpleadoDetalleVentas(Model model) {
        List<EmpleadoDetalleVentasPorGamaDTO> empleadoDetalleVentasPorGama = employeeService.findAllCategorySellsCountByEmployee()
                .entrySet()
                .stream()
                .map(entry -> EmpleadoDetalleVentasPorGamaDTO.fromEmpleadoDetalleVentasPorGama(entry.getKey(), entry.getValue()))
                .toList();

        model.addAttribute("table", new GenericTableGenerator<>(
                        empleadoDetalleVentasPorGama,
                        EmpleadoDetalleVentasPorGamaDTO.class
                )
        );
        return "index-generic";
    }
}