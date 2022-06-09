package skypro.homework_2_13;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeServise {

    private final Map<String, Employee> employee = new HashMap<>() {
    };

    public Employee addEmployee(String firstName, String lastName, Integer salary, Integer department) {
        if (employee.containsKey(conkatinate(firstName, lastName))) {
            throw new AlreadyHasException();
        }
        employee.put(conkatinate(firstName, lastName), new Employee(firstName, lastName, salary, department));
        return employee.get(conkatinate(firstName, lastName));
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        if (employee.containsKey(conkatinate(firstName, lastName))) {
            Employee employee1 = employee.get(conkatinate(firstName, lastName));
            employee.remove(conkatinate(firstName, lastName));
            return employee1;
        }
        throw new NotFoundException();
    }


    public Employee findEmployee(String firstName, String lastName) {
        if (employee.containsKey(conkatinate(firstName, lastName))) {
            return employee.get(conkatinate(firstName, lastName));
        }
        throw new NotFoundException();
    }

    public Map<String, Employee> getListOfEmployee() {
        return employee;
    }

    private String conkatinate(String firstName, String lastName) {
        return StringUtils.capitalize(firstName) + StringUtils.capitalize(lastName);
    }

    public Map<String, Employee> getEmployee() {
        return employee;
    }
}












