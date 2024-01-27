package pl.wsb.university.Class;

import java.time.LocalDate;

public class Student {
    private static String studentId;
    private static String firstName;
    private static String lastName;
    private static LocalDate birthDate;
    public Student(String studentId, String firstName, String lastName, LocalDate birthDate) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    //GETTERY
    public static String getStudentId() { return studentId; }
    public static String getFirstName() { return firstName; }
    public static String getLastName() { return lastName; }
    public static LocalDate getBirthDate() { return birthDate; }

    //Settery
    public void setStudentId (String studentId) { this.studentId = studentId; }
    public void setFirstName (String firstName) { this.firstName = firstName; }
    public void setLastName (String lastName) { this.lastName = lastName; }
    public void setBirthDate (LocalDate birthDate) { this.birthDate = birthDate; }

}
