package se.lexicon.DAO;

import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.List;

public interface CourseDAO {

    Course save(Course course);
    List<Course> findByName(String name);
    List<Course> findByDate(LocalDate date);
    Course findById(int id);
    List<Course> findAll();
    boolean delete(Course course);

}
