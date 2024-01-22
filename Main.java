package pl.wsb.university;

import java.time.LocalDate;

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
        String course2 = universityManager.openNewCourse("Matematyka", 2, Semester.WINTER);

        //Wywoływanie ID kursu 1
        System.out.println("ID kursu 1: " + course1);
    }
}
