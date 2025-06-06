package spring_web_eoi.jdbc.application;

import spring_web_eoi.jdbc.application.model.CategorySellsCount;
import spring_web_eoi.jdbc.domain.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepository {

    List<Employee> findEmployeeOfOffices();

    Map<Employee, CategorySellsCount> findAllCategorySellsCountByEmployee();
}
