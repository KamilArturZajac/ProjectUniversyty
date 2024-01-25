package pl.wsb.university;

import java.util.ArrayList;
import java.util.List;

public class VerificationMethods {

    public VerificationMethods(){
    }

    public static boolean verifyIfStudentIdFound(String studentId, List<Student> List) {
        List<String> studentIdsList = new ArrayList<>();
        for (Student student : List) {
            studentIdsList.add(student.getStudentId());
        }
        if (studentIdsList.contains(studentId)){
            return true;
        } else {
            return false;
        }
    }

    public static boolean verifyIfLecturerIdFound(String studentId, List<Lecturer> List) {
        List<String> lecturerIdsList = new ArrayList<>();
        for (Lecturer lecturer : List) {
            lecturerIdsList.add(lecturer.getLecturerId());
        }
        if (lecturerIdsList.contains(studentId)) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean verifyIfCourseIdFound(String courseId, List<Course> List) {
        List<String> courseIdsList = new ArrayList<>();
        for (Course course : List) {
            courseIdsList.add(course.getCourseId());
        }
        if (courseIdsList.contains(courseId)){
            return true;
        } else {
            return false;
        }
    }
}