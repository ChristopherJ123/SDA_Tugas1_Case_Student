package faculty;

public class PartTimeLecturerFactory {
    public Teacher createTeacher(String name){
        return new PartTimeLecturer(name);
    }
}
