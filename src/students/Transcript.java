package students;

import courses.Course;
import observer.Observer;
import observer.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Transcript implements Subject {
    private List<Observer> observers;
    private HashMap<Course, Double> completedCourses;
    private double gpa;

    public Transcript() {
        this.observers = new ArrayList<>();
        this.completedCourses = new HashMap<>();
    }

    public void addCourse(Course course, double grade) {
        completedCourses.put(course, grade);
        updateGPA();
    }

    private void updateGPA() {
        double totalGrades = 0;
        for (double grade : completedCourses.values()) {
            totalGrades += grade;
        }
        gpa = totalGrades / completedCourses.size();
        System.out.println("GPA updated to " + gpa);

        notifyObserver(); //call interface Observer
    }

    public boolean hasDuplicateCourseFinished(Course course) {
        return completedCourses.containsKey(course);
    }

    public double getGPA() {
        return gpa;
    }

    public HashMap<Course, Double> getCompletedCourses() {
        return completedCourses;
    }

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers)
            observer.update();
    }
}

