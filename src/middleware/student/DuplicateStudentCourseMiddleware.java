package middleware.student;

import courses.Course;
import enrollment.EnrollmentManager;
import students.Student;

public class DuplicateStudentCourseMiddleware extends BaseStudentCourseMiddleware {
    private EnrollmentManager manager;

    public DuplicateStudentCourseMiddleware(EnrollmentManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean check(Student student, Course course) {
        if (this.manager.isStudentEnrolledInCourse(student, course)) {
            System.out.println("Duplicate student enrolled in course");
            return false;
        }
        return true;
    }
}
