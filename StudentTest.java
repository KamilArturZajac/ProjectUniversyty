import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wsb.university.Class.Student;
import pl.wsb.university.UniversityManager;

import java.time.LocalDate;

public class StudentTest {
    private UniversityManager universityManager;
    private Student student;

    @BeforeEach
    void setUp() {
        universityManager = new UniversityManager();
        createStudent();
    }

    void createStudent() {
        student = universityManager.recruitNewStudent("firstName", "lastName", LocalDate.of(1995, 5, 5));
    }

    @Test
    @DisplayName("Sprawdź imię nowego studenta")
    void getFirstName() {
        // given
        // when
        String firstName = student.getFirstName();
        // then
        Assertions.assertEquals("firstName", firstName);
    }
}
