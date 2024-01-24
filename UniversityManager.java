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
  public void enrollStudentInCourse(String studentId, String courseId) {
    for (Course course : Courses) {
      if (courseId.equals(course.getCourseId())) {
        course.setMembers(studentId);
        break;
      }
    }
  }

  //METODA 5
  @Override
  public void enrollStudentsInCourse(Set<String> studentIds, String courseId) {
    throw new RuntimeException("Method 5 not implemented yet!");
  }

  //METODA 6 Przypisywanie wykładowcy do kursu
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
    int numberOfStudentsNotEnrolledInAnyCourse = 0;
    List <String> StudentsEnrolledInAnyCourse = new ArrayList<>();
    StudentsEnrolledInAnyCourse.add("member");
    System.out.println("Zawartość listy " + StudentsEnrolledInAnyCourse);
    for (Course course : Courses) {
      System.out.println('\n' + "Przeszukiwanie kursu " + course.getName());
      for (Object member : course.getMembers()){

        System.out.println("Wykryto użytkownika " + member);
        //for (String ignored : StudentsEnrolledInAnyCourse ){
          System.out.println("Sprawdzanie listy zapisanych studentów");
          //if (!member.equals(StudentsEnrolledInAnyCourse)) {
            //System.out.println("Sprawdzanie czy użytkownik " + member + " jest już na liście");
            StudentsEnrolledInAnyCourse.add(String.valueOf(member));
            System.out.println("Zawartość listy " + StudentsEnrolledInAnyCourse);
         // } else { System.out.println("IF SIĘ JEBIE");}
        //}
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