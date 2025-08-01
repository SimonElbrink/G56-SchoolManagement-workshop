package se.lexicon.dao;

import se.lexicon.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseDaoImpl implements CourseDao {
    private List<Course> courses;

    public CourseDaoImpl() {
        this.courses = new ArrayList<>();
    }
    @Override
    public Course save (Course course) {
        if(!courses.contains(course)){
            courses.add(course);
            return course;
        } return null;
    }
    @Override
    public Course findById(int id){
        return courses.stream().filter(course -> course.getId()==id)
                .findFirst().orElse(null);
    }
    @Override
    public List<Course> findByName(String name){
        return courses.stream().filter(course
                -> course.getCourseName().equalsIgnoreCase(name)).collect(Collectors.toList());
    }
    @Override
    public List<Course> findByDate(LocalDate date){
        return courses.stream().filter(course
                -> course.getStartDate().equals(date)).collect(Collectors.toList());
    }
    @Override
    public List<Course> findAll(){
        return courses;
    }
    @Override
    public boolean delete (Course course) {
        return courses.remove(course);
    }
}
