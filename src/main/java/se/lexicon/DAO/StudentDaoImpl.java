package se.lexicon.DAO;

import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentDaoImpl implements StudentDAO{

    private List<Student> students;


    public StudentDaoImpl(){
        students = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        if(!students.contains(student)){
            students.add(student);
            return student;
        }
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        Optional<Student> student = students.stream()
                .filter(s -> s.getEmail().equalsIgnoreCase(email))
                .findFirst();

        return student.get();
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student> list = students.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public Student findById(int id) {
        Optional<Student> stud = students.stream().filter(s -> s.getId() == id).findFirst();
        return stud.get();
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean delete(Student student) {
        if(!students.contains(student)) return false;

        students.remove(student);
        return true;
    }
}
