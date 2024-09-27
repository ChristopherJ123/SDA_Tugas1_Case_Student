package faculty;

public class PartTimeLecturerFactory extends TeacherFactory {
    @Override
    public Teacher createTeacher(String name){
        return new PartTimeLecturer(name);
    }
}
