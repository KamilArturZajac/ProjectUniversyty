import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.wsb.university.Class.Course;
import pl.wsb.university.Class.Semester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseTest {
    private Course course;

    @BeforeEach
    void createCourse() {
        List<String> members = new ArrayList<>();
        members.add("Student1");
        members.add("Student2");
        members.add("Student3");
        members.add("Student4");
        members.add("Student5");
        course = new Course("courseId", "name", 1, Semester.SUMMER, "leader", (ArrayList) members);
    }

    @Test
    @DisplayName("Sprawdź ID kursu")
    void getId() {
        //given - obiekt kurs z testowymi parametrami
        // when
        String ID = course.getCourseId();
        // then
        Assertions.assertEquals("courseId", ID);
    }
    @Test
    @DisplayName("Sprawdź nazwę kursu")
    void getName() {
        //given - obiekt kurs z testowymi parametrami
        // when
        String name = course.getName();
        // then
        Assertions.assertEquals("name", name);
    }

    @Test
    @DisplayName("Sprawdź na którym roku jest kurs")
    void getYear() {
        //given - obiekt kurs z testowymi parametrami
        // when
        int year = course.getYear();
        // then
        Assertions.assertEquals(1, year);
    }

    @Test
    @DisplayName("Sprawdź semestr kursu")
    void getSemestr() {
        //given - obiekt kurs z testowymi parametrami
        // when
        Semester semester = course.getSemester();
        // then
        Assertions.assertEquals(Semester.SUMMER, semester);
    }

    @Test
    @DisplayName("Sprawdź listę uczestników kursu")
    void getMembers() {
        // given - obiekt kurs z testowymi parametrami
        // when
        List<String> testMembers = course.getMembers();
        // then
        Assertions.assertTrue(testMembers.containsAll(members));
    }
}
