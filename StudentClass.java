package pl.wsb.university;

import java.time.LocalDate;

public class StudentClass {
    private String studentId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    public Student (String studentId, String firstName, String lastName, LocalDate birthDate) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

//GETTERY
    public String getStudentId {
        return studentId;
    }
    public String getFirstName {
        return firstName;
    }
    public String getLastName {
        return lastName;
    }
    public LocalDate getBirthDate {
        return birthDate;
    }

//Settery
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }
    public void setStudentId (String studentId) {
        this.studentId = studentId;
    }
    public void setBirthDate (LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
