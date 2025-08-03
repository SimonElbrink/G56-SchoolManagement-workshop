package dao;



import model.Student;

import java.util.List;

public interface StudentDao {
    Student save(Student student);
    Student findById(int id);
    Student findByEmail(String email);
    List<Student> findByName(String name);
    List<Student> findAll();
    boolean delete(Student student);

}
