package se.lexicon;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.util.Objects;

public class Course {
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    public Course(int id, String courseName, LocalDate startDate, int weekDuration) {
        if(id==0){
            throw new IllegalArgumentException("Id cannot be null or empty");
        }
        if(courseName==null || courseName.trim().isEmpty()){
            throw new IllegalArgumentException("Name of course cannot be null or empty");
        }
        if(startDate==null) {
            throw new IllegalArgumentException("Date of start cannot be null or empty");
        }
        if(weekDuration==0){
            throw new IllegalArgumentException("Duration cannot be null or empty");
        }
        this.id=id;
        this.courseName=courseName;
        this.startDate=startDate;
        this.weekDuration=weekDuration;
        this.students=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public String getCourseName() {
        return courseName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public void register(Student student) {
        if(!students.contains(student)) {
            students.add(student);
        }
    }

    public void unregister(Student student) {
        if(students.contains(student)) {
            students.remove(student);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return id == course.id &&
                weekDuration == course.weekDuration &&
                courseName.equals(course.courseName) &&
                startDate.equals(course.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseName, startDate, weekDuration);
    }
}
