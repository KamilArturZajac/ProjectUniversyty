package pl.wsb.university.Class;

import java.time.LocalDate;

public class Lecturer {

    private static String lecturerId;
    private static String firstName;
    private static String lastName;
    private static LocalDate birthDate;
    public Lecturer(String lecturerId, String firstName, String lastName, LocalDate birthDate) {
        this.lecturerId = lecturerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    //GETTERY
    public static String getLecturerId() { return lecturerId; }
    public static String getFirstName() { return firstName; }
    public static String getLastName() { return lastName; }
    public static LocalDate getBirthDate() { return birthDate; }

    //Settery
    public void setLecturerId (String lecturerId) { this.lecturerId = lecturerId; }
    public void setFirstName (String firstName) { this.firstName = firstName; }
    public void setLastName (String lastName) { this.lastName = lastName; }
    public void setBirthDate (LocalDate birthDate) { this.birthDate = birthDate; }

}