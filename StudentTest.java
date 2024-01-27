import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wsb.university.Class.Student;
import pl.wsb.university.UniversityManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    private UniversityManager universityManager;
    private List<Student> students;

    @BeforeEach
    void setUp() {
        universityManager = new UniversityManager();
        students = new ArrayList<>();
        createStudent();
    }

    void createStudent() {
        Student newStudent = universityManager.recruitNewStudent("Jan", "Kowalski", LocalDate.of(1991, 1, 1));
        students.add(newStudent);
    }

    @Test
    @DisplayName("Sprawdź imię nowego studenta")
    void getFirstName() {
        // given
        Student student = students.get(0);

        // when
        String firstName = student.getFirstName();
        System.out.println("ID studenta 1: " + student.getStudentId());

        // then
        Assertions.assertEquals("Jan", firstName);
    }
}
