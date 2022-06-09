package skypro.homework_2_13;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class EmployeeServiseTest {


    private EmployeeServise out = new EmployeeServise();

    @Test
    void shouldReturnEmployeeWithThisParam() {
        assertEquals(new Employee("Ivan", "Ivanov", 30000, 1), out.addEmployee("Ivan", "Ivanov", 30000, 1));
    }

    @Test
    void shouldReturnAlreadyHasExceptionWhenEmployeeAlreadyHas() {
        out.addEmployee("Ivan", "Ivanov", 30000, 1);
        Assertions.assertThrows(AlreadyHasException.class, () -> out.addEmployee("Ivan", "Ivanov", 30000, 1));
    }

    @Test
    void shouldReturnEmployeeObjectIfSuchEmployeeHas() {
        out.addEmployee("Ivan", "Ivanov", 30000, 1);
        assertEquals(new Employee("Ivan", "Ivanov", 30000, 1), out.deleteEmployee("Ivan", "Ivanov"));
    }

    @Test
    void shouldReturnNotFoundExceptionThenEmployeeNotHas() {
        assertThrows(NotFoundException.class, () -> out.deleteEmployee("Ivan", "Ivanov"));
    }

    @Test
    void shouldReturnEmployeeObjectWhenHasEmployeeWithTheseParam() {
        out.addEmployee("Ivan", "Ivanov", 30000, 1);
        assertEquals(new Employee("Ivan", "Ivanov", 30000, 1), out.findEmployee("Ivan", "Ivanov"));
    }

    @Test
    void shouldReturnNotFoundExceptionWhenEmployeeInMapNotFound() {
        assertThrows(NotFoundException.class, () -> out.findEmployee("Ivan", "Ivanov"));
    }

    @Test
    void shouldReturnMapCollection() {
        assertNotNull(out.getListOfEmployee());
    }
}