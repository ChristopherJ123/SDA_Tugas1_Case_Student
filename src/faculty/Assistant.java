package faculty;

import courses.Course;

public class Assistant extends Teacher {

    public Assistant(String name) {
        super(name);
    }

    @Override
    public void assignToCourse(Course course) {
        System.out.println("Assistant " + name + " assigned to assist " + course.getCourseName());
    }
}
