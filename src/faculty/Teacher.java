package faculty;

import courses.Course;

public abstract class Teacher {
    protected String name;

    public Teacher(String name) {
        this.name = name;
    }

    public abstract void assignToCourse (Course course);
}
