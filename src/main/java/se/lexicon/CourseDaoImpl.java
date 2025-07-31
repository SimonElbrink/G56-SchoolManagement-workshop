package se.lexicon;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao{
    private final List<Course> courses = new ArrayList<>();

    @Override
    public Course save(Course course) {
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {

        for(Course course: courses){
            if (course.getId() == id){
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> matched = new ArrayList<>();

        for (Course course: courses) {
            if (course.getCourseName().equals(name)) {
                matched.add(course);
            }
        }

        return matched;
    }

    @Override
    public List<Course> findByDate(LocalDateTime date) {
        List<Course> matched = new ArrayList<>();

        for (Course course: courses) {
            if (course.getLocalDate().equals(date)) {
                matched.add(course);
            }
        }

        return matched;
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses);
    }

    @Override
    public boolean delete(Course course) {
        return courses.remove(course);
    }
}
