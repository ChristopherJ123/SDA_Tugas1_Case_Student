package handlers.studentEnrollment;

import courses.Course;
import students.Student;

public class DuplicateStudentEnrollmentHandler extends BaseStudentEnrollmentHandler {
    @Override
    public boolean check(Student student, Course course) {
        if (student.getEnrolledCourses().contains(course)) {
            System.out.println("[Validation error!] Duplicate student enrolled in course");
            return false;
        }
        return checkNext(student, course);
    }
}
