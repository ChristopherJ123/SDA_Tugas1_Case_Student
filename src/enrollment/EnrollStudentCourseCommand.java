package enrollment;

import courses.Course;
import middleware.student.BaseStudentCourseMiddleware;
import students.Student;

public class EnrollStudentCourseCommand implements Command {
    private BaseStudentCourseMiddleware middleware;
    private Student student;
    private Course course;

    public EnrollStudentCourseCommand(BaseStudentCourseMiddleware middleware, Student student, Course course) {
        this.middleware = middleware;
        this.student = student;
        this.course = course;
    }

    @Override
    public boolean execute() {
        if (!middleware.check(student, course)) {
            return false;
        }
        student.enrollInCourse(this.course);
        return true;
    }

    @Override
    public boolean undo() {
        student.unEnrollInCourse(this.course);
        return true;
    }
}
