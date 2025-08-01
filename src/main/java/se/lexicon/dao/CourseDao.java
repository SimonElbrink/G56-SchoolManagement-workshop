package se.lexicon.dao;

import se.lexicon.Course;
import se.lexicon.Student;

import java.time.LocalDate;
import java.util.List;

public interface CourseDao {
    Course save(Course course);
    Course findById(int id);
    List<Course> findByName(String name);
    List<Course> findByDate(LocalDate date);
    List<Course> findAll();
    boolean delete (Course course);

}
