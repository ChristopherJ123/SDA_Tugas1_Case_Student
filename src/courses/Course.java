package courses;

import java.util.ArrayList;

public class Course {
    private final String courseId;
    private final String courseName;
    private final boolean isOnline;
    private final String location;
    private final ArrayList<Course> prerequisites;

    public Course(String courseId, String courseName, boolean isOnline, String location, ArrayList<Course> prerequisites) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.isOnline = isOnline;
        this.location = location;
        this.prerequisites = prerequisites;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<Course> getPrerequisites() {
        return prerequisites;
    }
}
