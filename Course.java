package pl.wsb.university.Class;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private static String courseId;
    private static String name;
    private static int year;
    private static Semester semester;
    private static String leader;
    private static ArrayList <String> members;

    public Course(String courseId, String name, int year, Semester semester, String leader, ArrayList members) {
        this.courseId = courseId;
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.leader = leader;
        this.members = members;
    }
    //GETTERY
    public static String getCourseId() { return courseId; }
    public static String getName() { return name; }
    public static int getYear() { return year; }
    public static Semester getSemester() { return semester; }
    public static String getLeader() { return leader; }
    public static List getMembers() { return members; }

    //SETTERY
    public void setCourseId (String courseId) { this.courseId = courseId;}
    public void setName (String name) { this.name = name; }
    public void setYear (int year) { this.year = year; }
    public void setSemester (Semester semester) { this.semester = semester; }
    public void setLeader (String leader) { this.leader = leader; }
    public void setMembers (String member) { this.members.add(member); }
}
