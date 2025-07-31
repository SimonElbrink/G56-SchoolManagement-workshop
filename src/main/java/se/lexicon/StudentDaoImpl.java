package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private final List<Student> students = new ArrayList<>();
    @Override
    public Student save(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        if (email == null) return null;

        for(Student student: students){
            if (student.getEmail().equals(email)){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> matched = new ArrayList<>();

        for (Student student : students) {
            if (student.getName().equals(name)) {
                matched.add(student);
            }
        }

        return matched;
    }

    @Override
    public Student findById(int id) {
        for(Student student: students){
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public boolean delete(Student student) {
        return students.remove(student);
    }
}
