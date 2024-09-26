package commands;

import courses.Course;
import handlers.courseCompleted.BaseCompleteCourseHandler;
import students.Student;

public class CompleteCourseCommand implements Command {
    private final BaseCompleteCourseHandler handler;
    private Student student;
    private Course course;
    private double grade;

    public CompleteCourseCommand(BaseCompleteCourseHandler handler, Student student, Course course, double grade) {
        this.handler = handler;
        this.student = student;
        this.course = course;
        this.grade = grade;
    }

    @Override
    public boolean execute() {
        if (!handler.check(student, course, grade)) {
            return false;
        }
        student.completeCourse(this.course, grade);
        return true;
    }

    @Override
    public void undo() {
        student.unCompleteCourse(course);
    }
}
