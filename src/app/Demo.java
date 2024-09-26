package app;

import commands.*;
import courses.Course;
import courses.CourseBuilder;
import courses.CourseDirector;
import exports.ExportService;
import exports.JsonExportService;
import handlers.courseCompleted.BaseCompleteCourseHandler;
import handlers.courseCompleted.DuplicateCompletedCourseHandler;
import handlers.courseCompleted.ValidateGradeHandler;
import handlers.studentEnrollment.BaseStudentEnrollmentHandler;
import handlers.studentEnrollment.DuplicateStudentEnrollmentHandler;
import handlers.studentEnrollment.ValidateStudentHandler;
import students.Student;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExportService exportService = new JsonExportService();
        Student student = new Student("Alice", "c12345678");

        CourseBuilder courseBuilder = new CourseBuilder(); // Builder creational pattern
        CourseDirector courseDirector = new CourseDirector(); // Director from builder

        CommandHistory commandHistory = new CommandHistory(); // Command history
        CommandController commandController = new CommandController(commandHistory); // Interface untuk menjalankan command

        // Handler (Chain of responsibility) untuk validasi/handling data
        BaseStudentEnrollmentHandler studentEnrollmentHandler = BaseStudentEnrollmentHandler.link(
                new ValidateStudentHandler(),
                new DuplicateStudentEnrollmentHandler()
        );
        BaseCompleteCourseHandler completeCourseHandler = BaseCompleteCourseHandler.link(
                new ValidateGradeHandler(),
                new DuplicateCompletedCourseHandler()
        );

        int choice;
        Course course = courseBuilder.build();

        do {
            System.out.println("1. Enroll in Course");
            System.out.println("2. Complete Course");
            System.out.println("3. Export Transcript");
            System.out.println("4. Undo last action");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter course type (1 for Online, 2 for Onsite): ");
                    int courseType = scanner.nextInt();
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
                    Command enrollCommand = new EnrollStudentCourseCommand(studentEnrollmentHandler, student, course);
                    commandController.executeCommand(enrollCommand);
                }
                case 2 -> {
                    System.out.println("Enter grade for the course: ");
                    double grade = scanner.nextDouble();
                    Command completeCourseCommand = new CompleteCourseCommand(completeCourseHandler, student, course, grade);
                    commandController.executeCommand(completeCourseCommand);
                }
                case 3 -> {
                    String transcript = exportService.exportTranscript(student.getTranscript());
                    System.out.println("Exported Transcript: " + transcript);
                }
                case 4 -> {
                    commandController.undoCommand();
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        } while (true);
    }
}


