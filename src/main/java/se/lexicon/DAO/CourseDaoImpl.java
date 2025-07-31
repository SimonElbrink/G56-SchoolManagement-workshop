package se.lexicon.DAO;

import se.lexicon.model.Course;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseDaoImpl implements CourseDAO{

    private List<Course> courses;

    public CourseDaoImpl(){
        courses = new ArrayList<>();
    }

    @Override
    public Course save(Course course) {
        if(courses.contains(course)) return course;

        courses.add(course);
        return course;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> c = courses.stream()
                .filter(s -> s.getCourseName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        return c;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        //Fråga Simon om det är startdatum? eller vilket datum som ska jämföras.

        List<Course> list = courses.stream()
                .filter(d -> d.getStartDate().isEqual(date))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public Course findById(int id) {
        Optional<Course> c = courses.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        return c.get();
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean delete(Course course) {
        if(!courses.contains(course)) return false;

        courses.remove(course);
        return true;
    }
}
