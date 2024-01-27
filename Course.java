package pl.wsb.university.Class;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String name;
    private int year;
    private Semester semester;
    private String leader;
    private ArrayList <String> members;

    public Course(String courseId, String name, int year, Semester semester, String leader, ArrayList members) {
        this.courseId = courseId;
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.leader = leader;
        this.members = members;
    }
    //GETTERY
    public String getCourseId() { return courseId; }
    public String getName() { return name; }
    public int getYear() { return year; }
    public Semester getSemester() { return semester; }
    public String getLeader() { return leader; }
    public List getMembers() { return members; }

    //SETTERY
    public void setCourseId (String courseId) { this.courseId = courseId;}
    public void setName (String name) { this.name = name; }
    public void setYear (int year) { this.year = year; }
    public void setSemester (Semester semester) { this.semester = semester; }
    public void setLeader (String leader) { this.leader = leader; }
    public void setMembers (String member) { this.members.add(member); }
}
