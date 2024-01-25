package pl.wsb.university;

public class CourseNotFoundException extends Exception {
    public CourseNotFoundException (String errorMessage) {
        super(errorMessage);
    }
}
