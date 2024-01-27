import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wsb.university.Class.Student;
import pl.wsb.university.UniversityManager;
import pl.wsb.university.Main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    @BeforeEach
    UniversityManager universityManager = new UniversityManager();
    public List<Student> Students = new ArrayList<>();
    void createStudent() {
        String student = universityManager.recruitNewStudent("Jan", "Kowalski", LocalDate.of(1991, 1, 1));
        //Student newStudent = new Student("studentId","FirstName", "LastName", LocalDate.of(2137, 13, 41));
        //Students.add(newStudent);
    }
    @Test
    @DisplayName("Check new student name'")
    void getFirstName() {
        // given -
        // when
        String firstName;
        student.getStudentId();
        System.out.println("ID of student 1: " + student);
        // then
        Assertions.assertEquals("FirstName", firstName);
    }
}
