package enrollment;

import courses.Course;
import students.Student;

public class UndoCommand implements Command {
    private EnrollmentHistory history;
    private Student student;
    private Course course;

    public UndoCommand(EnrollmentHistory history, Student student, Course course) {
        this.history = history;
        this.student = student;
        this.course = course;
    }

    @Override
    public boolean execute() {
        history.remove(this);
        return false;
    }

    @Override
    public boolean undo() {
        return false;
    }
}
