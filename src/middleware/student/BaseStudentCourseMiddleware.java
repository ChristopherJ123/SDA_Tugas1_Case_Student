package middleware.student;

import courses.Course;
import students.Student;

public abstract class BaseStudentCourseMiddleware {
    private BaseStudentCourseMiddleware next;

    public static BaseStudentCourseMiddleware link(BaseStudentCourseMiddleware first, BaseStudentCourseMiddleware... chain) {
        BaseStudentCourseMiddleware head = first;
        for (BaseStudentCourseMiddleware nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean check(Student student, Course course);

    protected boolean checkNext(Student student, Course course) {
        if (next == null) {
            return true;
        }
        return next.check(student, course);
    }
}
