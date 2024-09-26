package faculty;

import java.util.ArrayList;
import java.util.List;

//ini sebelumnya pakek Factory tapi kita ubah ke abstract factory

public class Faculty {
   private String facultyName;
   private List<Teacher> teachers = new ArrayList<>();
//   private List<Student> students = new ArrayList<>();



    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    public void addTeacher (Teacher teacher){
        teachers.add(teacher);
    }

//    public void addStudent (Student student){
//        students.add(student);
//    }

}
