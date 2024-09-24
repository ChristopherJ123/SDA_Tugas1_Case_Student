package exports;

import courses.Course;
import students.Student;
import students.Transcript;

public abstract class ExportService {
    abstract public String exportStudent(Student student);
    abstract public String exportCourse(Course course);
    abstract public String exportTranscript(Transcript transcript);
}
