package pl.wsb.university;

public class LecturerAlreadyAssignedException extends Exception {
    public LecturerAlreadyAssignedException (String errorMessage) {
        super(errorMessage);
    }
}
