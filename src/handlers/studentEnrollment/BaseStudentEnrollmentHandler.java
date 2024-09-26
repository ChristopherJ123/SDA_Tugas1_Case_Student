package handlers.studentEnrollment;

import courses.Course;
import students.Student;

public abstract class BaseStudentEnrollmentHandler {
    private BaseStudentEnrollmentHandler next;

    public static BaseStudentEnrollmentHandler link(BaseStudentEnrollmentHandler first, BaseStudentEnrollmentHandler... chain) {
        BaseStudentEnrollmentHandler head = first;
        for (BaseStudentEnrollmentHandler nextInChain : chain) {
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
