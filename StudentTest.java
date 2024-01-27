import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wsb.university.Class.Student;
import pl.wsb.university.UniversityManager;

import java.time.LocalDate;

public class StudentTest {
    private final UniversityManager universityManager = new UniversityManager();
    private Student student; // instancja klasy Student

    @BeforeEach
    void createStudent() {
        student = new Student("studentId", "firstName", "lastName", LocalDate.of(1995, 5, 5));
    }

    @Test
    @DisplayName("Sprawdź imię studenta")
    void getFirstName() {
        // when
        String firstName = student.getFirstName();
        // then
        Assertions.assertEquals("firstName", firstName);
    }

    @Test
    @DisplayName("Sprawdź nazwisko studenta")
    void getLastName() {
        // when
        String lastName = student.getLastName();
        // then
        Assertions.assertEquals("lastName", lastName);
    }
}
