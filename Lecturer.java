package pl.wsb.university.Class;

import java.time.LocalDate;

public class Lecturer {

    private String lecturerId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    public Lecturer(String lecturerId, String firstName, String lastName, LocalDate birthDate) {
        this.lecturerId = lecturerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    //GETTERY
    public String getLecturerId() { return lecturerId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getBirthDate() { return birthDate; }

    //Settery
    public void setLecturerId (String lecturerId) { this.lecturerId = lecturerId; }
    public void setFirstName (String firstName) { this.firstName = firstName; }
    public void setLastName (String lastName) { this.lastName = lastName; }
    public void setBirthDate (LocalDate birthDate) { this.birthDate = birthDate; }

}