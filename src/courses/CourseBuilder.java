package courses;

import java.util.ArrayList;

public class CourseBuilder implements Builder {
    private String courseId;
    private String courseName;
    private boolean isOnline;
    private String location;
    private ArrayList<Course> prerequisites = new ArrayList<>();

    @Override
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public void setOnline(boolean online) {
        this.isOnline = online;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void setPrerequisite(ArrayList<Course> prerequisite) {
        this.prerequisites = prerequisite;
    }

    public Course build() {
        return new Course(courseId, courseName, isOnline, location, prerequisites);
    }
}
