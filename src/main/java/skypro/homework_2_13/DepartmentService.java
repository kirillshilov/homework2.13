package skypro.homework_2_13;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeServise servise;

    public DepartmentService(EmployeeServise servise) {
        this.servise = servise;
    }

    public Optional<Employee> findMaxSalaryByDepartment(Integer departmentId) {
        if (departmentId > 5) {
            throw new NotFoundException();
        }
        return Optional.of(servise.getEmployee().values().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .max(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow());
    }

    public Optional<Employee> findMinSalaryByDepartment(Integer departmentId) {
        if (departmentId > 5) {
            throw new NotFoundException();
        }
        return Optional.of(servise.getEmployee().values().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow());
    }

    public List<Employee> showAllEmployeeOfDepartment(Integer departmentId) {
        if (departmentId > 5) {
            throw new NotFoundException();
        }
        return servise.getEmployee().values().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .collect(Collectors.toList());
    }

    public String showAllEmployeesByDepartment() {
        String department = new String();
        for (Integer i = 0; i < 5; i++) {
            department = department + showAllEmployeeOfDepartment(i).toString() + "<br>";
        }
        return department;
    }


}
