package se.lexicon.DAO;

import se.lexicon.model.Student;

import java.util.List;

public interface StudentDAO {

    Student save(Student student);
    Student findByEmail(String email);
    List<Student> findByName(String name);
    Student findById(int id);
    List<Student> findAll();
    boolean delete(Student student);
}
