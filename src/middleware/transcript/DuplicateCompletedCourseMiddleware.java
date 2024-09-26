package middleware.transcript;

import courses.Course;
import middleware.student.BaseStudentCourseMiddleware;
import students.Student;

public class DuplicateCompletedCourseMiddleware extends BaseStudentCourseMiddleware {

    @Override
    public boolean check(Student student, Course course) {
        return false;
    }
}
