package pl.wsb.university;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.util.*;

public class UniversityManager implements University {

  //Tworzenie studenta
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



  //Tworzenie wykładowcy
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

  //Tworzenie kursu
  public List <Course> Courses = new ArrayList<>();
  @Override
  public String openNewCourse(String name, int year, Semester semester) {
    String courseId = String.valueOf(courseRandomId());
    String leader = "";
    List members = Collections.singletonList("");
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
//Przypisywanie studenta do kursu
  @Override
  public void enrollStudentInCourse(String studentId, String courseId) {
    for (Course course : Courses) {
      if (courseId.equals(course.getCourseId())) { //IF nie wykonuje się prawidłowo i działa break w elsie
        for (Student student : Students) {
          if (studentId.equals(student.getStudentId())) {
            course.setMembers(studentId);
            System.out.println("JAKIMŚ CUDEM DZIAŁA");
            break;
          } else { break; }
        }
        break;
      } else  { break; }
    }
    //throw new RuntimeException("Method 4 not implemented yet!");
  }

  @Override
  public void enrollStudentsInCourse(Set<String> studentIds, String courseId) {
    throw new RuntimeException("Method 5 not implemented yet!");
  }

  //Przypisywanie wykładowcy do kursu
  @Override
  public void assignLecturerToCourse(String lecturerId, String courseId) {
    for (Course course : Courses) {
      if (courseId.equals(course.getCourseId())) {
        for (Lecturer lecturer : Lecturers) {
          if (lecturerId.equals(lecturer.getLecturerId())) {
            course.setLeader(lecturerId);
          } else { break; }
        }
      } else  { break; }
    }
    //throw new RuntimeException("Method 6 not implemented yet!");
  }

  //Zliczanie ilości studentów przypisanych do kursu
  @Override
  public int getNumberOfStudentsEnrolledInCourse(String courseId) {
    List <String> listNumberOfStudentsEnrolledInCourse = new ArrayList<>();
    for (Course course : Courses) {
      if (courseId.equals(course.getCourseId())) {
        listNumberOfStudentsEnrolledInCourse = course.getMembers();
        System.out.println(course.getMembers());  //Póki co zwraca pustą listę czyli metoda enrollStudentInCourse nie działa poprawnie
      }
    }
    return listNumberOfStudentsEnrolledInCourse.size();
    //throw new RuntimeException("Method 7 not implemented yet!");
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

  //Wymienianie nazw kursów semestru letniego w zadaniym roku
  @Override
  public List<String> getAllCourseNamesForSummerSemesterByYear(int year) {
    //throw new RuntimeException("Method 13 not implemented yet!");
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