package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.dao.StudentDao;
import se.lexicon.dao.StudentDaoImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDaoImplTest {

    private StudentDao studentDao;
    private Student student1;
    private Student student2;
    private Student student3;


    @BeforeEach
void setUp(){
        studentDao = new StudentDaoImpl();
        student1 = new Student(1, "Anna Iol", "anna@ex.se", "One St.");
        student2 = new Student(2, "Michel", "michel@ex.se", "Two St.");
        student3 = new Student(3, "Anna", "anna_two@ex.se", "Three St.");

        }

    @Test
void testSaveStudentSuccess(){

        Student savedStudOne = studentDao.save(student1);

        assertNotNull(student1);
        assertEquals("Anna Iol", savedStudOne.getName());
        assertEquals(1, studentDao.findAll().size());
    }

    @Test
    void testSaveNoDuplicates(){
        Student studentDuplicate = new Student(1, "Anna Iol", "anna@ex.se", "One St.");
        Student savedStudOne = studentDao.save(student1);//(1, "Anna Iol", "anna@ex.se", "One St.");
        Student savedStudDupl = studentDao.save(studentDuplicate);

        assertEquals("Anna Iol", savedStudOne.getName());
        assertEquals(1, studentDao.findAll().size());
        assertNull(savedStudDupl);
    }

    @Test
    void testFindByEmail() {
        Student savedStudOne = studentDao.save(student1);//(1, "Anna Iol", "anna@ex.se", "One St.");

        Student savedStudTwo = studentDao.save(student2);

        Student foundEmail = studentDao.findByEmail("michel@ex.se");

        assertNotNull(foundEmail);
        assertEquals("michel@ex.se", foundEmail.getEmail());
    }
    @Test
    void testFindByName() {

        Student savedStudOne = studentDao.save(student1);//(1, "Anna Iol", "anna@ex.se", "One St.")

        Student savedStudTree = studentDao.save(student3);

        List<Student> foundName = studentDao.findByName("anna");

        assertNotNull(foundName);
        assertEquals(2, foundName.size());
    }

    @Test
    void testFindById(){
        Student savedStudOne = studentDao.save(student1);//(1, "Anna Iol", "anna@ex.se", "One St.")
        Student savedStudTwo = studentDao.save(student2);//(2, "Michel", "michel@ex.se", "Two St.");
        Student savedStudTree = studentDao.save(student3);//(3, "Anna", "anna_two@ex.se", "Three St.");

        Student foundStudent = studentDao.findById(2);

        assertNotNull(foundStudent);
        assertEquals("Michel", foundStudent.getName());
        assertEquals("michel@ex.se", foundStudent.getEmail());
    }

    @Test
    void testFindAll(){
        Student savedStudOne = studentDao.save(student1);//(1, "Anna Iol", "anna@ex.se", "One St.")
        Student savedStudTwo = studentDao.save(student2);//(2, "Michel", "michel@ex.se", "Two St.");
        Student savedStudTree = studentDao.save(student3);//(3, "Anna", "anna_two@ex.se", "Three St.");

        List<Student> foundStudent = studentDao.findAll();

        assertNotNull(foundStudent);
        assertEquals(3, foundStudent.size());
        assertTrue(foundStudent.contains(student1));
        assertTrue(foundStudent.contains(student2));
        assertTrue(foundStudent.contains(student3));
    }

    @Test
    void testDelete(){
        Student savedStudOne = studentDao.save(student1);//(1, "Anna Iol", "anna@ex.se", "One St.")
        Student savedStudTwo = studentDao.save(student2);//(2, "Michel", "michel@ex.se", "Two St.");
        Student savedStudTree = studentDao.save(student3);//(3, "Anna", "anna_two@ex.se", "Three St.");

       boolean foundStudent = studentDao.delete(savedStudOne);

        assertTrue(foundStudent);
        assertEquals(2, studentDao.findAll().size());


    }
}
