package skypro.homework_2_13;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;

    private DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/max-salary")
    public Optional<Employee> maxSalaryByDepartment(@RequestParam Integer departmentId) {
        return service.findMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Optional<Employee> minSalaryByDepartment(@RequestParam Integer departmentId) {
        return service.findMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/all")
    public String employeeByDepartment(@RequestParam(required = false) Integer departmentId) {
        if (departmentId != null) {
            return service.showAllEmployeeOfDepartment(departmentId).toString();

        } else {
            return service.showAllEmployeesByDepartment();
        }
    }
}
