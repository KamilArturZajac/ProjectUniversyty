import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wsb.university.Class.Student;
import pl.wsb.university.UniversityManager;

import java.time.LocalDate;

public class StudentTest {
    private UniversityManager universityManager;
    private String studentId; // ID studenta, które zwraca metoda recruitNewStudent

    @BeforeEach
    void setUp() {
        universityManager = new UniversityManager();
        createStudent();
    }

    void createStudent() {
        studentId = universityManager.recruitNewStudent("firstName", "lastName", LocalDate.of(1995, 5, 5));
    }

    @Test
    @DisplayName("Sprawdź imię nowego studenta")
    void getFirstName() {
        // given
        // when
        Student student = universityManager.getStudentById(studentId); // Pobierz obiekt Student na podstawie ID
        String firstName = student.getFirstName();
        // then
        Assertions.assertEquals("firstName", firstName);
    }
}
