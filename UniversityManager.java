package pl.wsb.university;

import java.time.LocalDate;
import java.util.*;

public class UniversityManager implements University {

          //METODA 1 Tworzenie studenta
  public List <Student> Students = new ArrayList<>();
  @Override
  public String recruitNewStudent(String firstName, String lastName, LocalDate birthDate) {
    //throw new RuntimeException("Method 1 not implemented yet!");
    String studentId = String.valueOf(studentRandomId());
    Student newStudent = new Student(studentId, firstName, lastName, birthDate);
    Students.add(newStudent);
    return newStudent.getStudentId();
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
    } while (isStudentIdTaken(studentRandomNumber));

    return studentRandomNumber;
  }
//Sprawdzanie czy wygenerowane ID jest wolne
  private boolean isStudentIdTaken(int studentId) {
    //Sprawdzanie czy wylosowane ID nie jest już używane
    for (Student student : Students) {
      if (String.valueOf(studentId).equals(student.getStudentId())) {
        return true;
      }
    }
    return false;
  }



          //METODA 2 Tworzenie wykładowcy
  public List <Lecturer> Lecturers = new ArrayList<>();
  @Override
  //W poniższej metodzie pozwoliłem zmienić nazwę zmiennej z "birtDate" na "birthDate"
  public String hireNewLecturer(String firstName, String lastName, LocalDate birthDate) {
    //throw new RuntimeException("Method 2 not implemented yet!");
    String lecturerId = String.valueOf(lecturerRandomId());
    Lecturer newLecturer = new Lecturer(lecturerId, firstName, lastName, birthDate);
    Lecturers.add(newLecturer);
    return newLecturer.getLecturerId();
  }
  //Losowanie ID dla Wykadowcy
  private int lecturerRandomId() {
    //Losowanie ID
    int lecturerRandomNumber;
    //Zakres losowanego ID
    int min = 1;
    int max = 9999;
    do {
      lecturerRandomNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
    } while (isLecturerIdTaken(lecturerRandomNumber));

    return lecturerRandomNumber;
  }
  //Sprawdzanie czy wygenerowane ID jest wolne
  private boolean isLecturerIdTaken(int lecturerId) {
    //Sprawdzanie czy wylosowane ID nie jest już używane
    for (Lecturer lecturer : Lecturers) {
      if (String.valueOf(lecturerId).equals(lecturer.getLecturerId())) {
        return true;
      }
    }
    return false;
  }

          //METODA 3 Tworzenie kursu
  public List <Course> Courses = new ArrayList<>();
  @Override
  public String openNewCourse(String name, int year, Semester semester) {
    String courseId = String.valueOf(courseRandomId());
    String leader = "";
    ArrayList <String> members = new ArrayList<>();
    Course newCourse = new Course(courseId, name, year, semester, leader, members);
    Courses.add(newCourse);
    return newCourse.getCourseId();
    //throw new RuntimeException("Method 3 not implemented yet!");
  }
  //Losowanie ID dla kursu
  private int courseRandomId() {
    //Losowanie ID
    int courseRandomNumber;
    //Zakres losowanego ID
    int min = 1;
    int max = 9999;
    do {
      courseRandomNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);
    } while (isCourseIdTaken(courseRandomNumber));

    return courseRandomNumber;
  }
  //Sprawdzanie czy wygenerowane ID jest wolne
  private boolean isCourseIdTaken(int courseId) {
    //Sprawdzanie czy wylosowane ID nie jest już używane
    for (Course course : Courses) {
      if (String.valueOf(courseId).equals(course.getCourseId())) {
        return true;
      }
    }
    return false;
  }

        //METODA 4 Przypisywanie studenta do kursu
@Override
public void enrollStudentInCourse(String studentId, String courseId) throws CourseNotFoundException, PersonNotFoundException, StudentAlreadyEnrolledException {
  if (!VerificationMethods.verifyIfCourseIdFound(courseId, Courses)){
    throw new CourseNotFoundException("Kurs " + courseId + " nie istnieje");
  }
  if (!VerificationMethods.verifyIfStudentIdFound(studentId, Students)){
    throw new PersonNotFoundException("Student " + studentId + " nie istnieje");
  }
  for (Course course : Courses) {
    if (courseId.equals(course.getCourseId())) {
      if (course.getMembers().contains(studentId)){
        throw new StudentAlreadyEnrolledException("Student " + studentId + " jest już zapisany na kurs " + courseId);
      } else {
        course.setMembers(studentId);
      }
      break;
    }
  }
}

          //METODA 5 Przypisywanie studentów do kursu
  @Override
  public void enrollStudentsInCourse(Set<String> studentIds, String courseId) throws CourseNotFoundException, StudentAlreadyEnrolledException, PersonNotFoundException {
    if (!VerificationMethods.verifyIfCourseIdFound(courseId, Courses)){
      throw new CourseNotFoundException("Kurs " + courseId + " istnieje");
    }
    List<String> studentIdsList = new ArrayList<>(studentIds);
    for (String studentId : studentIdsList) {
      if (!VerificationMethods.verifyIfStudentIdFound(studentId, Students)){
        throw new PersonNotFoundException("Student " + studentId + " nie istnieje");
      }
      for (Course course : Courses) {
        if (courseId.equals(course.getCourseId())) {
          if (course.getMembers().contains(studentId)){
            throw new StudentAlreadyEnrolledException("Student " + studentId + " jest już zapisany na kurs " + courseId);
          } else {
            course.setMembers(studentId);
          }
          break;
        }
      }
    }
  }

          //METODA 6 Przypisywanie wykładowcy do kursu
  @Override
  public void assignLecturerToCourse(String lecturerId, String courseId) throws CourseNotFoundException, PersonNotFoundException, LecturerAlreadyAssignedException {
    if (!VerificationMethods.verifyIfCourseIdFound(courseId, Courses)){
      throw new CourseNotFoundException("Kurs " + courseId + " nie istnieje");
    }
    if (!VerificationMethods.verifyIfLecturerIdFound(lecturerId, Lecturers)){
      throw new PersonNotFoundException("Wykładowca " + lecturerId + " nie istnieje");
    }
    for (Course course : Courses) {
      if (courseId.equals(course.getCourseId())) {
        if (course.getMembers().contains(lecturerId)){
          throw new LecturerAlreadyAssignedException("Wykładowca " + lecturerId + " jest już prowadzącym kursu " + courseId);
        } else {
          course.setMembers(lecturerId);
        }
        break;
      }
    }
  }

          //METODA 7 Zliczanie ilości studentów przypisanych do kursu
  @Override
  public int getNumberOfStudentsEnrolledInCourse(String courseId) {
    List <String> listNumberOfStudentsEnrolledInCourse = new ArrayList<>();
    for (Course course : Courses) {
      if (courseId.equals(course.getCourseId())) {
        listNumberOfStudentsEnrolledInCourse = course.getMembers();
      }
    }
    return listNumberOfStudentsEnrolledInCourse.size();
  }

  @Override
  public int getNumberOfCoursesAssignedToLecturer(String lecturerId) {
    throw new RuntimeException("Method 8 not implemented yet!");
  }

  @Override
  public int getNumberOfCoursesAssignedToStudent(String studentId) {
    throw new RuntimeException("Method 9 not implemented yet!");
  }

        //METODA 10 Zliczanie ilości studentów nie przypisanych do żadnego kursu
  @Override
  public int getNumberOfStudentsNotEnrolledInAnyCourse() {
    List<String> studentsEnrolledInAnyCourse = new ArrayList<>();

    for (Course course : Courses) {
      for (Object member : course.getMembers()) {
        studentsEnrolledInAnyCourse.add(String.valueOf(member));
      }
    }

    int numberOfStudentsNotEnrolledInAnyCourse = 0;
    for (Student student : Students) {
      if (!studentsEnrolledInAnyCourse.contains(student.getStudentId())) {
        numberOfStudentsNotEnrolledInAnyCourse++;
      }
    }

    return numberOfStudentsNotEnrolledInAnyCourse;
  }

  @Override
  public int getNumberOfCoursesWithoutAnyLecturer() {
    throw new RuntimeException("Method 11` not implemented yet!");
  }

  @Override
  public int getNumberOfStudentsTaughtByLecturer(String lecturerId) {
    throw new RuntimeException("Method 12 not implemented yet!");
  }

          //METODA 13 Wymienianie nazw kursów semestru letniego w zadaniym roku
  @Override
  public List<String> getAllCourseNamesForSummerSemesterByYear(int year) {
    List <String> namesOfCoursesForSummerSemesterByYear = new ArrayList<>();
    for (Course course : Courses) {
      if (year == course.getYear() && course.getSemester() == Semester.SUMMER) {
        namesOfCoursesForSummerSemesterByYear.add(course.getName());
      }
    }
    return namesOfCoursesForSummerSemesterByYear;
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

          //METODA 17 Zliczanie ilości studentów
  @Override
  public int getNumberOfAllStudents() {
    int numberOfAllStudents = 0;
    for (Student student : Students) {
      numberOfAllStudents++;
    }
    return numberOfAllStudents;
  }

          //METODA 18 Zliczanie ilości wykładowców
  @Override
  public int getNumberOfAllLecturers() {
    int numberOfAllLecturers = 0;
    for (Lecturer lecturer : Lecturers) {
      numberOfAllLecturers++;
    }
    return numberOfAllLecturers;
  }

         //METODA 19 Zliczanie ilości kursów
  @Override
  public int getNumberOfAllCourses() {
    int numberOfAllCourses = 0;
    for (Course course : Courses) {
      numberOfAllCourses++;
    }
    return numberOfAllCourses;

  }
}