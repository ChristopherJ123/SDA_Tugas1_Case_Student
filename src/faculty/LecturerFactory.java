package faculty;

public class LecturerFactory extends TeacherFactory {
    @Override
    public Teacher createTeacher(String name){
        return new Lecturer(name);
    }
}
