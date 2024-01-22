package pl.wsb.university;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        UniversityManager universityManager = new UniversityManager();
        //Tworzenie przykładowych klientów
        String student1 = universityManager.recruitNewStudent("Jan", "Kowalski", LocalDate.of(1991, 1, 1));
        String student2 = universityManager.recruitNewStudent("Mateusz", "Nowak", LocalDate.of(1992, 2, 2));
        String student3 = universityManager.recruitNewStudent("Janina", "Kowalczyk", LocalDate.of(1993, 3, 3));

        //Wywoływanie pełnego imienia i nazwiska studenta 1
        //String studentFullName = universityManager.getStudentFullName(student1);
        //System.out.println(studentFullName);
    }
}
