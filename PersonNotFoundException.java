package pl.wsb.university;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException (String errorMessage) {
        super(errorMessage);
    }
}
