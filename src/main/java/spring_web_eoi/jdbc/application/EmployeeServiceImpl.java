package spring_web_eoi.jdbc.application;

import spring_web_eoi.jdbc.application.model.CategorySellsCount;
import spring_web_eoi.jdbc.domain.Employee;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findEmployeeOfOffices() {
        return employeeRepository.findEmployeeOfOffices();
    }

    @Override
    public Map<Employee, CategorySellsCount> findAllCategorySellsCountByEmployee() {
        return employeeRepository.findAllCategorySellsCountByEmployee();
    }
}
