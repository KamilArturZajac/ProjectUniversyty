package pl.wsb.university;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface University {

  /* method: 1 */
  String recruitNewStudent(String firstName, String lastName, LocalDate birthDate);

  /* method: 2 */
  String hireNewLecturer(String firstName, String lastName, LocalDate birtDate);

  /* method: 3 */
  String openNewCourse(String name, int year, Semester semester);


  /* method: 4 */
  void enrollStudentInCourse(String studentId, String courseId)
      throws PersonNotFoundException, StudentAlreadyEnrolledException, CourseNotFoundException;

  /* method: 5 */
  void enrollStudentsInCourse(Set<String> studentIds, String courseId)
      throws PersonNotFoundException, StudentAlreadyEnrolledException, CourseNotFoundException;

  /* method: 6 */
  void assignLecturerToCourse(String lecturerId, String courseId)
      throws PersonNotFoundException, LecturerAlreadyAssignedException, CourseNotFoundException;


  /* method: 7 */
  int getNumberOfStudentsEnrolledInCourse(String courseId);

  /* method: 8 */
  int getNumberOfCoursesAssignedToLecturer(String lecturerId);

  /* method: 9 */
  int getNumberOfCoursesAssignedToStudent(String studentId);

  /* method: 10 */
  int getNumberOfStudentsNotEnrolledInAnyCourse();

  /* method: 11 */
  int getNumberOfCoursesWithoutAnyLecturer();

  /* method: 12 */
  int getNumberOfStudentsTaughtByLecturer(String lecturerId);


  /* method: 13 */
  List<String> getAllCourseNamesForSummerSemesterByYear(int year);

  /* method: 14 */
  List<String> getAllCourseNamesForWinterSemesterByYear(int year);

  /* method: 15 */
  List<String> getStudentFullNamesSortedFromTheYoungestToTheOldestByCourse(String courseId);

  /* method: 16 */
  List<String> getStudentIdsOlderThanLecturerForCourse(String courseId);


  /* method: 17 */
  int getNumberOfAllStudents();

  /* method: 18 */
  int getNumberOfAllLecturers();

  /* method: 19 */
  int getNumberOfAllCourses();

}
