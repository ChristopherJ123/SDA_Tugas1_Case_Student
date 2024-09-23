package courses;

import java.util.ArrayList;

public interface Builder {
    void setCourseId(String courseId);
    void setCourseName(String courseName);
    void setOnline(boolean online);
    void setLocation(String location);
    void setPrerequisite(ArrayList<Course> prerequisite);
}
