package handlers.courseCompleted;

import courses.Course;
import students.Student;

public class ValidateGradeHandler extends BaseCompleteCourseHandler {
    @Override
    public boolean check(Student student, Course course, double grade) {
        if (grade > 4 || grade < 0) {
            System.out.println("[Validation error!] Grade must be between 0 and 4");
            return false;
        }
        return checkNext(student, course, grade);
    }
}
