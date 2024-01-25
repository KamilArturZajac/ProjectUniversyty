package pl.wsb.university;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws StudentAlreadyEnrolledException, CourseNotFoundException, PersonNotFoundException, LecturerAlreadyAssignedException {
        UniversityManager universityManager = new UniversityManager();
        //METODA 1 Tworzenie przykładowych studentów
        String student1 = universityManager.recruitNewStudent("Jan", "Kowalski", LocalDate.of(1991, 1, 1));
        String student2 = universityManager.recruitNewStudent("Mateusz", "Nowak", LocalDate.of(1992, 2, 2));
        String student3 = universityManager.recruitNewStudent("Janina", "Kowalczyk", LocalDate.of(1993, 3, 3));

        //Wywoływanie ID studenta 1
        System.out.println("ID of student 1: " + student1);


        //METODA 2 Tworzenie przykładowych wykładowców
        String lecturer1 = universityManager.hireNewLecturer("Lucjan", "Puchalski", LocalDate.of(1967, 4, 4));
        String lecturer2 = universityManager.hireNewLecturer("Dorian", "Niemczyk", LocalDate.of(1958, 5, 5));

        //Wywoływanie ID wykładowcy 1
        System.out.println("ID of lecturer 1: " + lecturer1);


        //METODA 3 Tworzenie przykładowych kursów
        String course1 = universityManager.openNewCourse("Programowanie", 1, Semester.SUMMER);
        String course2 = universityManager.openNewCourse("Matematyka", 1, Semester.SUMMER);
        String course3 = universityManager.openNewCourse("Grafika", 1, Semester.WINTER);
        String course4 = universityManager.openNewCourse("Fizyka", 2, Semester.WINTER);

        //Wywoływanie ID kursu 1
        System.out.println("ID of course 1: " + course1);
        System.out.println('\n');


        //METODA 4 Dodawanie studenta 2 i 3 do kursu 1
        universityManager.enrollStudentInCourse(student3, course1);
        System.out.println(student3 + " is now member of course " + course1);

        universityManager.enrollStudentInCourse(student2, course1);
        System.out.println(student2 + " is now member of course " + course1);

        universityManager.enrollStudentInCourse(student2, course2);
        System.out.println(student2 + " is now member of course " + course2);

        //EXPECTIONS METODA 4

            //StudentAlreadyEnrolledExpection
        //universityManager.enrollStudentInCourse(student3, course1);

            //PersonNonFoundExpection
        //universityManager.enrollStudentInCourse("234", course1);

            //CourseNonFoundExpetion
        //universityManager.enrollStudentInCourse(student3, "123");


        //METODA 5 Dodawanie studentów do kursu
        Set<String> studentsList = new HashSet<>();
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        universityManager.enrollStudentsInCourse(studentsList, course4);
        System.out.println("Students " + student1 + ", " + student2 + ", " + student3 + " is now members of course " + course4);

        //EXPECTIONS METODA 5

            //StudentAlreadyEnrolledExpextion
        //universityManager.enrollStudentsInCourse(studentsList, course1);

            //CourseNonFoundExpection
        //universityManager.enrollStudentsInCourse(studentsList, "1111");

            //PersonNonFoundExpection
        //Set<String> studentsList2 = new HashSet<>(); studentsList2.add("1111"); studentsList2.add("2222"); universityManager.enrollStudentsInCourse(studentsList2, course1);


        //METODA 6 Dodawanie wykładowcy 2 do kursu 1
        universityManager.assignLecturerToCourse(lecturer2, course1);
        System.out.println(lecturer2 + " is now leader of course " + course1);
        System.out.println('\n');
        //EXPECTIONS METODA 6
            //CourseNonFoundExpection
        //universityManager.assignLecturerToCourse(lecturer2, "123");

            //PersonNonFoundExpextion
        //universityManager.assignLecturerToCourse("123", course1);

            //LecturerAlreadyAssignedExpection
        //universityManager.assignLecturerToCourse(lecturer2, course1);


        //METODA 7 Sprawdzenie ilości ucześtników kursu 1 NIE DZIAŁA
        int numberOfCourseMembers = universityManager.getNumberOfStudentsEnrolledInCourse(course1);
        System.out.println("Total members of course " + course1 + ": " + numberOfCourseMembers);
        System.out.println('\n');


        //METODA 10 Sprawdzanie ilu studentów nie jest zapisanych do żadnego kursu
        System.out.println(universityManager.getNumberOfStudentsNotEnrolledInAnyCourse() + " students are not members of any course");


        //METODA 13 Sprawdzanie nazw kursów występujących na pierwszym roku semestru letniego
        List <String> allCoursesNamesForSummerSemesterByYear = universityManager.getAllCourseNamesForSummerSemesterByYear(1);
        System.out.println("Names of summer courses in 1 year " + allCoursesNamesForSummerSemesterByYear);
        System.out.println('\n');


        //METODY 17-19 Sprawdzanie ilości studentów, wykładowców i kursów
        System.out.println("Total ammound of students: " + universityManager.getNumberOfAllStudents());
        System.out.println("Total ammound of lecturers: " + universityManager.getNumberOfAllLecturers());
        System.out.println("Total ammound of courses: " + universityManager.getNumberOfAllCourses());
    }
}
