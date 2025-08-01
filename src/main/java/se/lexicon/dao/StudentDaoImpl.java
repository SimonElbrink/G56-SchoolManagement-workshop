package se.lexicon.dao;

import se.lexicon.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDaoImpl implements StudentDao {
    private List<Student> students;

    public StudentDaoImpl(){
        this.students = new ArrayList<>();
    }
    @Override
    public Student save(Student student) {
        if(!students.contains(student)) {
            students.add(student);
            return student;
        } return null;
    }
    @Override
    public Student findByEmail(String email){
        Iterator<Student> iter = students.iterator();
        while(iter.hasNext()){
            Student studentIter = iter.next();
            String gettingEmail = studentIter.getEmail();
            if(email.equalsIgnoreCase(gettingEmail)){
                return studentIter;
            }
        } return null;
    }
    @Override
    public List<Student> findByName(String name){
        return students.stream().filter(student
                -> student.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }
    @Override
    public Student findById(int id){
        return students.stream().filter(student
                -> student.getId()==id).findFirst().orElse(null);
    }
    @Override
    public List<Student> findAll(){
        return students;
    }
    @Override
    public boolean delete (Student student) {
        if(students.contains(student)){
            return students.remove(student);
        } return false;
    }

}
