package middleware.student;

import courses.Course;
import enrollment.EnrollmentManager;
import students.Student;

public class ValidateStudentMiddleware extends BaseStudentCourseMiddleware{
    private EnrollmentManager manager;

    public ValidateStudentMiddleware(EnrollmentManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean check(Student student, Course course) {
        // Cek format student ID menyesuaikan dengan NRP petra.
        if (student.getNrp().length() != 8) {
            System.out.println("[Validation error!] Format panjang NRP harus 8!");
            return false;
        } else if (String.valueOf(student.getNrp().charAt(0)).matches("[a-z]")) {
            System.out.println("[Validation error!] Format penamaan NRP harus dimulai dengan huruf abjad!");
            return false;
        } else if (student.getNrp().substring(1).matches(".*[a-zA-Z].*")) {
            System.out.println("[Validation error!] Format penamaan NRP tidak boleh memiliki huruf abjad kecuali huruf pertama pada NRP!");
            return false;
        }
        return true;
    }
}
