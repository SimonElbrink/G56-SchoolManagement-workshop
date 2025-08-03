package dao;

import model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseDaoImpl implements CourseDao {

    private List<Course> courses = new ArrayList<>();

    public Course save(Course course) {
        courses.add(course);
        return course;
    }

    public Course findById(int id) {
        return courses.stream()
                .filter(c -> c.getId() == id)
                .findFirst().orElse(null);
    }

    public List<Course> findByName(String name) {
        return courses.stream()
                .filter(c -> c.getCourseName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Course> findByDate(LocalDate date) {
        return courses.stream()
                .filter(c -> c.getStartDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Course> findAll() {
        return new ArrayList<>(courses);
    }

    public boolean delete(Course course) {
        return courses.remove(course);
    }

}
