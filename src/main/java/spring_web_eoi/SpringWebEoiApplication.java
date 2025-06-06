package spring_web_eoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringWebEoiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringWebEoiApplication.class, args);

		/*
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

		OficinaController oficinaController = new OficinaController(new OfficeServiceImpl(new OficinaRepository(jdbcTemplate)));
		oficinaController.printBasicAddress();

		EmpleadoController empleadoController = new EmpleadoController(new EmployeeServiceImpl(new EmpleadoRepository(jdbcTemplate)));
		System.out.println("--------------------------------------------------------------------------------------");
		empleadoController.printEmployeeOfOffice();

		System.out.println("--------------------------------------------------------------------------------------");
		empleadoController.printAllCategorySellsCountByEmployee();
		*/
    }

}
