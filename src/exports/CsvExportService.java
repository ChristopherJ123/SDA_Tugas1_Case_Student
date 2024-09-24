package exports;

import courses.Builder;
import courses.Course;
import enrollment.Base;
import students.Student;
import students.Transcript;

public class CsvExportService extends ExportService {

    @Override
    public String exportStudent(Student student) {
        return student.getName() + "," + student.getStudentId();
    }

    @Override
    public String exportCourse(Course course) {
        return course.getCourseName();
    }

    @Override
    public String exportTranscript(Transcript transcript) {
        return "GPA," + transcript.getGPA();
    }
}
