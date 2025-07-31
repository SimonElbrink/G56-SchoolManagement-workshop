package se.lexicon;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Course {
//    id: int
//    courseName: String
//    startDate: LocalDate
//    weekDuration: int
//    students: List<Student>
//    Methods:
//    register(Student student)
//    unregister(Student student)
    private final int id;
    private String courseName;
    private final LocalDateTime startDate;
    private int weekDuration;
    private List<Student> students = new ArrayList<>();

    public Course(int id, String courseName, int weekDuration){
        this.id = id;
        setCourseName(courseName);
        this.startDate = LocalDateTime.now();
        setWeekDuration(weekDuration);
    }

    public String getCourseName() {
        return courseName;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getLocalDate() {
        return startDate;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public List<Student> getStudents() {
        return students;
    }


    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void register(Student student){
        students.add(student);
    }

    public void unregister(Student student){
        students.remove(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", Course Name='" + courseName + '\'' +
                ", starting='" + startDate + '\'' +
                ", week duration='" + weekDuration + '\'' +
                '}';
    }
}
