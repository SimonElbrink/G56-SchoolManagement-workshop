package se.lexicon;

import java.time.LocalDateTime;
import java.util.List;

public interface CourseDao {
    Course save(Course course);
    Course findById(int id);
    List<Course> findByName(String name);
    List<Course> findByDate(LocalDateTime date);
    List<Course> findAll();
    boolean delete(Course course);
}
