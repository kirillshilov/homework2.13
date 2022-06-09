package skypro.homework_2_13;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {
    Employee firstTestEmployee = new Employee("Ivan", "Ivanov", 30000, 1);
    Employee secondTestEmployee = new Employee("Semen", "Semenov", 25000, 1);
    Employee thirdTestEmployee = new Employee("Irina", "Semenova", 27000, 2);
    @Mock
    private final EmployeeServise serviceMock = Mockito.mock(EmployeeServise.class);


    private DepartmentService out;

    @BeforeEach
    public void initOut() {
        out = new DepartmentService(serviceMock);
        Mockito.when(serviceMock.getEmployee()).thenReturn(Map.of(
                "IvanIvanov", firstTestEmployee,
                "SemenSemenov", secondTestEmployee,
                "IrinaSemenova", thirdTestEmployee));
    }

    @Test
    void shouldReturnEmployeeWithMinSalary() {
        assertEquals(Optional.of(secondTestEmployee), out.findMinSalaryByDepartment(1));
    }

    @Test
    void shouldReturnExceptionBecauseEmployeeWithMinSalaryNotFound() {
        assertThrows(RuntimeException.class, () -> out.findMinSalaryByDepartment(3));
    }

    @Test
    void shouldReturnNotFoundExceptionWhenNonExistentDepartmentSpecifiedMInSalary() {
        assertThrows(NotFoundException.class, () -> out.findMinSalaryByDepartment(6));
    }

    @Test
    void shouldReturnEmployeeWithMaxSalary() {
        assertEquals(Optional.of(firstTestEmployee), out.findMaxSalaryByDepartment(1));
    }

    @Test
    void shouldReturnExceptionBecauseEmployeeWithMaxSalaryNotFound() {
        assertThrows(RuntimeException.class, () -> out.findMaxSalaryByDepartment(3));
    }

    @Test
    void shouldReturnNotFoundExceptionWhenNonExistentDepartmentSpecifiedMaxSalary() {
        assertThrows(NotFoundException.class, () -> out.findMaxSalaryByDepartment(6));
    }

    @Test
    void shouldReturnListOfEmployeeWhenPutExistingDepartment() {
        final List<Employee> list = new ArrayList<>();
        list.add(firstTestEmployee);
        list.add(secondTestEmployee);
        assertEquals(list, out.showAllEmployeeOfDepartment(1));
    }

    @Test
    void shouldReturnEmptyListIfDepartmentDontHaveEmployee() {
        final List<Employee> list = new ArrayList<>();
        assertEquals(list, out.showAllEmployeeOfDepartment(3));
    }

    @Test
    void shouldReturnNotFoundExceptionWhenWrongDepartmentSpecified() {
        assertThrows(NotFoundException.class, () -> out.showAllEmployeeOfDepartment(6));
    }

    @Test
    void shouldReturnListOfEmployeeByString() {
        String string = new String("[]<br>[Employee{firstName='Ivan', lastName='Ivanov', salary=30000, department=1}, Employee{firstName='Semen', lastName='Semenov', salary=25000, department=1}]" +
                "<br>[Employee{firstName='Irina', lastName='Semenova', salary=27000, department=2}]<br>[]<br>[]<br>");
        assertEquals(string, out.showAllEmployeesByDepartment());
    }

    @Test
    void shouldReturnEmptyListIfDontHaveEmployee() {
        Mockito.when(serviceMock.getEmployee()).thenReturn(new HashMap<>());
        String test = new String("[]<br>[]<br>[]<br>[]<br>[]<br>");
        assertEquals(test, out.showAllEmployeesByDepartment());
    }


}