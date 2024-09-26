package middleware.transcript;

import courses.Course;
import students.Student;
import students.Transcript;

public abstract class BaseTranscriptMiddleware {
    private BaseTranscriptMiddleware next;

    public static BaseTranscriptMiddleware link(BaseTranscriptMiddleware first, BaseTranscriptMiddleware... chain) {
        BaseTranscriptMiddleware head = first;
        for (BaseTranscriptMiddleware nextInChain : chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public abstract boolean check(Course course, double grade);

    protected boolean checkNext(Course course, double grade) {
        if (next == null) {
            return true;
        }
        return next.check(course, grade);
    }
}
