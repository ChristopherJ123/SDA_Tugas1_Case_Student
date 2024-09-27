package students;
import courses.Course;
import observer.Observer;

import java.util.ArrayList;

public class Student implements Observer {
    private String name;
    private String nrp; // Rename ke NRP agar lebih merefleksikan sistem penamaan NRP petra
    private ArrayList<Course> enrolledCourses;
    private Transcript transcript;
    private boolean isHonorRoll;

    public Student(String name, String studentId) {
        this.name = name;
        this.nrp = studentId;
        this.enrolledCourses = new ArrayList<>();
        this.transcript = new Transcript();
        this.isHonorRoll = false;
        // subscribe to transcript
        this.transcript.addObserver(this);
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    public void unEnrollInCourse(Course course) {
        enrolledCourses.remove(course);
        System.out.println(name + " unenrolled in " + course.getCourseName());
    }

    public void completeCourse(Course course, double grade) {
        if (enrolledCourses.contains(course)) {
            transcript.addCourse(course, grade);
            enrolledCourses.remove(course);
            System.out.println(name + " completed " + course.getCourseName() + " with grade " + grade);
        } else {
            System.out.println("Student not enrolled in the course.");
        }
    }

    public void unCompleteCourse(Course course) {
        enrolledCourses.remove(course);
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void addHonorRollStatus() {
        this.isHonorRoll = true;
    }

    public boolean isHonorRoll() {
        return isHonorRoll;
    }

    public String getNrp() { return nrp; }

    public String getName() { return name; }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public void update() {
        System.out.println("Update");
        if (this.transcript.getGPA() > 3.5) {
            this.isHonorRoll = true;
            System.out.println("[Observer] Selamat kamu mencapai GPA untuk cumlaude! Pertahankan!");
        }
        else {
            if (this.isHonorRoll) {
                this.isHonorRoll = false;
                System.out.println("[Observer] Kamu telah kehilangan status cumlaude :( Tingkatkan nilai mu 💪");
            }
        }
    }
}
