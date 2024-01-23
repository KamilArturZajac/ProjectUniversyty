package pl.wsb.university;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UniversityManager universityManager = new UniversityManager();
        //Tworzenie przykładowych studentów
        String student1 = universityManager.recruitNewStudent("Jan", "Kowalski", LocalDate.of(1991, 1, 1));
        String student2 = universityManager.recruitNewStudent("Mateusz", "Nowak", LocalDate.of(1992, 2, 2));
        String student3 = universityManager.recruitNewStudent("Janina", "Kowalczyk", LocalDate.of(1993, 3, 3));

        //Wywoływanie ID studenta 1
        System.out.println("ID studenta 1: " + student1);

        //Tworzenie przykładowych wykładowców
        String lecturer1 = universityManager.hireNewLecturer("Lucjan", "Puchalski", LocalDate.of(1967, 4, 4));
        String lecturer2 = universityManager.hireNewLecturer("Dorian", "Niemczyk", LocalDate.of(1958, 5, 5));

        //Wywoływanie ID wykładowcy 1
        System.out.println("ID wykładowcy 1: " + lecturer1);

        //Tworzenie przykładowych kursów
        String course1 = universityManager.openNewCourse("Programowanie", 1, Semester.SUMMER);
        String course2 = universityManager.openNewCourse("Matematyka", 1, Semester.SUMMER);
        String course3 = universityManager.openNewCourse("Grafika", 1, Semester.WINTER);
        String course4 = universityManager.openNewCourse("Fizyka", 2, Semester.WINTER);

        //Wywoływanie ID kursu 1
        System.out.println("ID kursu 1: " + course1);

        //Dodawanie studenta 2 i 3 do kursu 1
        universityManager.enrollStudentInCourse(student3, course1);
        System.out.println(student3 + " is now member of course " + course1);
        universityManager.enrollStudentInCourse(student2, course1);
        System.out.println(student2 + " is now member of course " + course1);
        universityManager.enrollStudentInCourse(student3, course1);
        System.out.println(student3 + " is now member of course " + course1);

        //Dodawanie wykładowcy 2 do kursu 1
        universityManager.assignLecturerToCourse(lecturer2, course1);
        System.out.println(lecturer2 + " is now leader of course " + course1);

        //Sprawdzenie ilości ucześtników kursu 1 NIE DZIAŁA
        int numberOfCourseMembers = universityManager.getNumberOfStudentsEnrolledInCourse(course1);
        System.out.println("Total members of course " + course1 + ": " + numberOfCourseMembers);

        //Sprawdzanie nazw kursów występujących na pierwszym roku semestru letniego
        List <String> allCoursesNamesForSummerSemesterByYear = universityManager.getAllCourseNamesForSummerSemesterByYear(1);
        System.out.println("Names of summer courses in 1 year " + allCoursesNamesForSummerSemesterByYear);

    }
}
