package handlers.courseCompleted;

import courses.Course;
import students.Student;

public abstract class BaseCompleteCourseHandler {
    private BaseCompleteCourseHandler next;

    public static BaseCompleteCourseHandler link(BaseCompleteCourseHandler first, BaseCompleteCourseHandler... chain) {
        BaseCompleteCourseHandler head = first;
        for (BaseCompleteCourseHandler nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean check(Student student, Course course, double grade);

    protected boolean checkNext(Student student, Course course, double grade) {
        if (next == null) {
            return true;
        }
        return next.check(student, course, grade);
    }
}
