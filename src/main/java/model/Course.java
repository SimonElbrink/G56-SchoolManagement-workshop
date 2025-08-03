package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;




public class Course {
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
        this.id = id;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = new ArrayList<>();
    }

    public void register(Student student) {
        students.add(student);
    }

    public void unregister(Student student) {
        students.remove(student);
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getCourseName() { return courseName; }
    public LocalDate getStartDate() { return startDate; }
    public int getWeekDuration() { return weekDuration; }
    public List<Student> getStudents() { return students; }

    public void setId(int id) { this.id = id; }
    public void setCourseName(String name) { this.courseName = name; }
    public void setStartDate(LocalDate date) { this.startDate = date; }
    public void setWeekDuration(int duration) { this.weekDuration = duration; }

    @Override
    public String toString() {
        return "[" + id + "] " + courseName + " (" + startDate + ", " + weekDuration + " weeks)";
    }



}
