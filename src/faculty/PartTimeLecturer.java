package faculty;

import courses.Course;

public class PartTimeLecturer extends Teacher {

    public PartTimeLecturer(String name) {
        super(name);
    }

    @Override
    public void assignToCourse(Course course) {
        System.out.println("Part-Time Lecturer " + name + " assigned to teach " + course.getCourseName());
    }
}