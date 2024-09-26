package handlers.courseCompleted;

import courses.Course;
import students.Student;

public class DuplicateCompletedCourseHandler extends BaseCompleteCourseHandler {
    @Override
    public boolean check(Student student, Course course, double grade) {
        if (student.getTranscript().hasDuplicateCourseFinished(course)) {
            System.out.println("[Validation error!] Duplicate course found in transcript");
            return false;
        }
        return checkNext(student, course, grade);
    }
}
