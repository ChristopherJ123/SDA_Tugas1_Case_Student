package app;

import courses.Course;
import courses.CourseBuilder;
import courses.CourseDirector;
import enrollment.EnrollStudent;
import enrollment.Base;
import exports.ExportService;
import exports.JsonExportService;
import students.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExportService exportService = new JsonExportService();
        Student student = new Student("Alice", "1001");

        CourseBuilder courseBuilder = new CourseBuilder();
        CourseDirector courseDirector = new CourseDirector();

        System.out.println("1. Enroll in Course");
        System.out.println("2. Complete Course");
        System.out.println("3. Export Transcript");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter course type (1 for Online, 2 for Onsite): ");
                int courseType = scanner.nextInt();
                Course course;
                if (courseType == 1) {
                    courseDirector.constructOnlineCourse(courseBuilder);
                    courseBuilder.setCourseId("CS101");
                    courseBuilder.setCourseName("Intro to CS");
                } else {
                    System.out.println("Enter location for the onsite course: ");
                    String location = scanner.next();
                    courseDirector.constructOnsiteCourse(courseBuilder);
                    courseBuilder.setCourseId("CS101");
                    courseBuilder.setCourseName("Intro to CS");
                    courseBuilder.setLocation(location);
                }

                course = courseBuilder.build();
                Base enrollCommand = new EnrollStudent(student, course);
                enrollCommand.execute();
                break;
            case 2:
                System.out.println("Enter grade for the course: ");
                double grade = scanner.nextDouble();
                student.completeCourse(courseBuilder.build(), grade);  // Complete the course using builder
                break;
            case 3:
                String transcript = exportService.exportTranscript(student.getTranscript());
                System.out.println("Exported Transcript: " + transcript);
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}


