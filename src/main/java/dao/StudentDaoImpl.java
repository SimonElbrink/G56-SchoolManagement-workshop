package dao;

import model.Student;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class StudentDaoImpl implements StudentDao {

    private List<Student> students = new ArrayList<>();

    public Student save(Student student) {
        students.add(student);
        return student;
    }

    public Student findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst().orElse(null);
    }

    public Student findByEmail(String email) {
        return students.stream()
                .filter(s -> s.getEmail().equalsIgnoreCase(email))
                .findFirst().orElse(null);
    }

    public List<Student> findByName(String name) {
        return students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public boolean delete(Student student) {
        return students.remove(student);
    }







}
