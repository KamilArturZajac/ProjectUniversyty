import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wsb.university.Class.Student;
import pl.wsb.university.UniversityManager;

import java.time.LocalDate;

public class StudentTest {
    private final UniversityManager universityManager = new UniversityManager();

    @BeforeEach
    void createStudent() {
        String studentTest1 = universityManager.recruitNewStudent("firstName", "lastName", LocalDate.of(1995, 5, 5));
        String studentTest2 = universityManager.recruitNewStudent("firstName", "lastName", LocalDate.of(1888, 5, 5));
        String studentTest3 = universityManager.recruitNewStudent("firstName", "lastName", LocalDate.of(2100, 5, 5));
        String studentTest4 = universityManager.recruitNewStudent("firstName", "lastName", LocalDate.of(2000, 15, 5));
        String studentTest5 = universityManager.recruitNewStudent("firstName", "lastName", LocalDate.of(2000, 5, 45));
    }

    @Test
    @DisplayName("Sprawdź imię studenta")
    void getFirstName() {
        // given - kilka studentów
        // when
        String firstName = Student.getFirstName();
        // then
        Assertions.assertEquals("firstName", firstName);
    }
    @Test
    @DisplayName("Sprawdź nazwisko studenta")
    void getLastName() {
        // given - kilka studentów
        // when
        String lastName = Student.getLastName();
        // then
        Assertions.assertEquals("lastName", lastName);
    }
}
