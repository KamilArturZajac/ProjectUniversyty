package pl.wsb.university;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UniversityManager implements University {
  public List <Student> Students = new ArrayList<>();
  @Override
  public String recruitNewStudent(String firstName, String lastName, LocalDate birthDate) {
    String studentId = String.valueOf(studentRandomId());
    Student newStudent = new Student(studentId, firstName, lastName, birthDate);
    Students.add(newStudent);
    //if XXXX
    return newStudent.getStudentId();
    //else
    //throw new RuntimeException("Method 1 not implemented yet!");
  }
  //Losowanie ID dla Studenta
  private int studentRandomId() {
    //Losowanie ID
    int studentRandomNumber;
    //Zakres losowanego ID
    int min = 1;
    int max = 9999;
    do {
      studentRandomNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
    } while (isClientIdTaken(studentRandomNumber));

    return studentRandomNumber;
  }
//Sprawdzanie czy wygenerowane ID jest wolne
  private boolean isClientIdTaken(int studentId) {
    //Sprawdzanie czy wylosowane ID nie jest już używane
    for (Student student : Students) {
      if (Students.equals(student.getStudentId())) {
        return true;
      }
    }
    return false;
  }
  @Override
  public String getStudentFullName (String studentID) {
    //Wywoływanie pełnego imienia i nazwiska studenta
    String commentGetStudentFullName = null;
    for (Student StudentClass : Students) {
      if (Students.equals(StudentClass.getStudentId())) {
        String firstName = StudentClass.getFirstName();
        String lastName = StudentClass    .getLastName();
        commentGetStudentFullName = studentID + " full name is " + firstName + " " + lastName;
        break;
      }
      else {
        commentGetStudentFullName = "Error - can't find this user";
      }
    }
    return commentGetStudentFullName;
  }

  @Override
  //W poniższej metodzie pozwoliłem zmienić nazwę zmiennej z "birtDate" na "birthDate"
  public String hireNewLecturer(String firstName, String lastName, LocalDate birthDate) {
    throw new RuntimeException("Method 2 not implemented yet!");
  }

  @Override
  public String openNewCourse(String name, int year, Semester semester) {
    throw new RuntimeException("Method 3 not implemented yet!");
  }

  @Override
  public void enrollStudentInCourse(String studentId, String courseId) {
    throw new RuntimeException("Method 4 not implemented yet!");
  }

  @Override
  public void enrollStudentsInCourse(Set<String> studentIds, String courseId) {
    throw new RuntimeException("Method 5 not implemented yet!");
  }

  @Override
  public void assignLecturerToCourse(String lecturerId, String courseId) {
    throw new RuntimeException("Method 6 not implemented yet!");
  }

  @Override
  public int getNumberOfStudentsEnrolledInCourse(String courseId) {
    throw new RuntimeException("Method 7 not implemented yet!");
  }

  @Override
  public int getNumberOfCoursesAssignedToLecturer(String lecturerId) {
    throw new RuntimeException("Method 8 not implemented yet!");
  }

  @Override
  public int getNumberOfCoursesAssignedToStudent(String studentId) {
    throw new RuntimeException("Method 9 not implemented yet!");
  }

  @Override
  public int getNumberOfStudentsNotEnrolledInAnyCourse() {
    throw new RuntimeException("Method 10 not implemented yet!");
  }

  @Override
  public int getNumberOfCoursesWithoutAnyLecturer() {
    throw new RuntimeException("Method 11` not implemented yet!");
  }

  @Override
  public int getNumberOfStudentsTaughtByLecturer(String lecturerId) {
    throw new RuntimeException("Method 12 not implemented yet!");
  }

  @Override
  public List<String> getAllCourseNamesForSummerSemesterByYear(int year) {
    throw new RuntimeException("Method 13 not implemented yet!");
  }

  @Override
  public List<String> getAllCourseNamesForWinterSemesterByYear(int year) {
    throw new RuntimeException("Method 14 not implemented yet!");
  }

  @Override
  public List<String> getStudentFullNamesSortedFromTheYoungestToTheOldestByCourse(String courseId) {
    throw new RuntimeException("Method 15 not implemented yet!");
  }

  @Override
  public List<String> getStudentIdsOlderThanLecturerForCourse(String courseId) {
    throw new RuntimeException("Method 16 not implemented yet!");
  }

  @Override
  public int getNumberOfAllStudents() {
    throw new RuntimeException("Method 17 not implemented yet!");
  }

  @Override
  public int getNumberOfAllLecturers() {
    throw new RuntimeException("Method 18 not implemented yet!");
  }

  @Override
  public int getNumberOfAllCourses() {
    throw new RuntimeException("Method 19 not implemented yet!");
  }
}