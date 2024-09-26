package faculty;

public class AssistantFactory extends TeacherFactory {
    @Override
    public Teacher createTeacher(String name){
        return new Assistant(name);
    }
}
