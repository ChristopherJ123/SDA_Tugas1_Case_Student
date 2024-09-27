package students;

public class StudentBuilder implements Builder{
    private String name;
    private String studentId;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Student buildStudent(String name, String studentId) {
        return new Student(name, studentId);
    }
}
