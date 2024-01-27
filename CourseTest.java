import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wsb.university.Class.Course;
import pl.wsb.university.Class.Semester;

import java.time.LocalDate;

public class CourseTest {
    private Course course;

    @BeforeEach
    void createStudent() {
        course = new Course("courseId", "name", 1, Semester.SUMMER, "leader", ));
    }

    @Test
    @DisplayName("Sprawdź ID studenta")
    void getId() {
        //given - obiekt student z testowymi parametrami
        // when
        String ID = student.getStudentId();
        // then
        Assertions.assertEquals("studentId", ID);
    }
    @Test
    @DisplayName("Sprawdź imię studenta")
    void getFirstName() {
        //given - obiekt student z testowymi parametrami
        // when
        String firstName = student.getFirstName();
        // then
        Assertions.assertEquals("firstName", firstName);
    }

    @Test
    @DisplayName("Sprawdź nazwisko studenta")
    void getLastName() {
        //given - obiekt student z testowymi parametrami
        // when
        String lastName = student.getLastName();
        // then
        Assertions.assertEquals("lastName", lastName);
    }

    @Test
    @DisplayName("Sprawdź datę urodzenia studenta")
    void getBirthDate() {
        //given - obiekt student z testowymi parametrami
        // when
        LocalDate birthDate = student.getBirthDate();
        // then
        Assertions.assertEquals(LocalDate.of(1995, 5, 5), birthDate);
    }
}