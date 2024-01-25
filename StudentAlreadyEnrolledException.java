package pl.wsb.university;

public class StudentAlreadyEnrolledException extends Exception {
    public StudentAlreadyEnrolledException (String errorMessage) {
        super(errorMessage);
    }
}
