package pl.wsb.university;

import java.time.LocalDate;

public class LecturerClass {

    private String lecturerId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    public Lecturer (String lecturerId, String firstName, String lastName, LocalDate birthDate) {
        this.lecturerId = lecturerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
}
