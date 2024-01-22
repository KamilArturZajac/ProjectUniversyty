package pl.wsb.university;

public class Course {
    private String courseId;
    private String name;
    private int year;
    private Semester semester;

    public Course(String courseId, String name, int year, Semester semester) {
        this.courseId = courseId;
        this.name = name;
        this.year = year;
        this.semester = semester;
    }
    //GETTERY
    public String getCourseId() { return courseId; }
    public String getName() { return name; }
    public int getYear() { return year; }
    public Semester getSemester() { return semester; }

    //SETTERY
    public void setCourseId (String courseId) { this.courseId = courseId;}
    public void setName (String name) { this.name = name; }
    public void setYear (int year) { this.year = year; }
    public void setSemester (Semester semester) { this.semester = semester; }
}
