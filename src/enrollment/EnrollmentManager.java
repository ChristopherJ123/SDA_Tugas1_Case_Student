package enrollment;

import commands.Command;
import courses.Course;
import middleware.student.BaseStudentCourseMiddleware;
import students.Student;

import java.util.*;

public class EnrollmentManager {
    private EnrollmentHistory history = new EnrollmentHistory();
    private Map<Student, Course> studentsCourse = new HashMap<>();
    private BaseStudentCourseMiddleware middleware;

    public void setMiddleWare(BaseStudentCourseMiddleware middleware) {
        this.middleware = middleware;
    }

    public void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    public void undoCommand(Command command) {
        if (command.undo()) {
            history.pop();
        }
    }

    public boolean isStudentEnrolledInCourse(Student student, Course course) {
        for (Map.Entry<Student, Course> entry : studentsCourse.entrySet()) {
            if (entry.getKey().equals(student) && entry.getValue().equals(course)) {
                return true;
            }
        }
        return false;
    }

    public void enrollStudentInCourse(Student student, Course course) {
        studentsCourse.put(student, course);
    }
}
