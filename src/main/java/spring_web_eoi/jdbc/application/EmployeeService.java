package spring_web_eoi.jdbc.application;

import spring_web_eoi.jdbc.application.model.CategorySellsCount;
import spring_web_eoi.jdbc.domain.Employee;

import java.util.List;
import java.util.Map;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findEmployeeOfOffices() {
        return employeeRepository.findEmployeeOfOffices();
    }

    public Map<Employee, CategorySellsCount> findAllCategorySellsCountByEmployee() {
        return employeeRepository.findAllCategorySellsCountByEmployee();
    }
}
