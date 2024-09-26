package faculty;

public class AssistantFactory {
    public Teacher createTeacher(String name){
        return new Assistant(name);
    }
}
