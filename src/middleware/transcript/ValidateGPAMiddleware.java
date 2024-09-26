package middleware.transcript;

import courses.Course;
import students.Transcript;

public class ValidateGPAMiddleware extends BaseTranscriptMiddleware {

    @Override
    public boolean check(Course course, double grade) {
        if (grade > 4 || grade < 0) {
            return false;
        }
        return true;
    }
}
