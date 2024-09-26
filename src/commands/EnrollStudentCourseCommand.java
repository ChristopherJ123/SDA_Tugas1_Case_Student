package commands;

import courses.Course;
import handlers.studentEnrollment.BaseStudentEnrollmentHandler;
import students.Student;

public class EnrollStudentCourseCommand implements Command {
    private BaseStudentEnrollmentHandler handler;
    private Student student;
    private Course course;

    public EnrollStudentCourseCommand(BaseStudentEnrollmentHandler handler, Student student, Course course) {
        this.handler = handler;
        this.student = student;
        this.course = course;
    }

    @Override
    public boolean execute() {
        if (!handler.check(student, course)) {
            return false;
        }
        student.enrollInCourse(this.course);
        return true;
    }

    @Override
    public void undo() {
        student.unEnrollInCourse(course);
    }
}
