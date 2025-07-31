package se.lexicon;


import org.junit.Test;
import se.lexicon.DAO.CourseDaoImpl;
import se.lexicon.DAO.StudentDAO;
import se.lexicon.DAO.StudentDaoImpl;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class ModelTest {

    @Test
    public void modelClassesTest(){
        Student st1 = new Student(1, "student 1", "student1@email.se", "student 1 home Stockholm" );
        Student st2 = new Student(2, "student 2", "student2@email.se", "student 2 home Stockholm" );
        Student st3 = new Student(3, "student 3", "student3@email.se", "student 3 home Stockholm" );
        Student st4 = new Student(4, "student 4", "student4@email.se", "student 4 home Stockholm" );
        Student st5 = new Student(5, "student 5", "student5@email.se", "student 5 home Stockholm" );

        Course course1 = new Course(1, "pottery", LocalDate.parse(("2025-08-31")), 27, new ArrayList<>());

        Course course2 = new Course(2, "woodworking", LocalDate.parse(("2025-09-30")), 14, new ArrayList<>());

        Course course3 = new Course(3, "Cooking", LocalDate.parse(("2025-05-27")), 5, new ArrayList<>());

        Course course4 = new Course(4, "Maths", LocalDate.parse(("2025-12-31")), 105, new ArrayList<>());

        Course course5 = new Course(5, "Physics", LocalDate.parse(("2025-08-31")), 200, new ArrayList<>());

        assertTrue(st1 != null);
        assertTrue(st4.getAddress() != null);


        assertEquals(course1.getCourseName(),"pottery");
        assertTrue(course4.getStartDate().isAfter(LocalDate.now()));

        List<Student> list = course1.getStudents();
        list.add(st1);
        list.add(st3);
        list.add(st4);
        course1.setStudents(list);

        assertTrue(course1.getStudents().size() == 3);

    }


    @Test
    public void courseImplTest(){
        CourseDaoImpl cdi = new CourseDaoImpl();

        Course pottery = new Course(1, "pottery", LocalDate.parse(("2025-08-31")), 27, new ArrayList<>());
        Course woodworking = new Course(2, "woodworking", LocalDate.parse(("2025-09-30")), 14, new ArrayList<>());
        Course cooking = new Course(3, "Cooking", LocalDate.parse(("2025-05-27")), 5, new ArrayList<>());
        Course maths = new Course(4, "Maths", LocalDate.parse(("2025-12-31")), 105, new ArrayList<>());
        Course physics = new Course(5, "Physics", LocalDate.parse(("2025-08-31")), 200, new ArrayList<>());

        cdi.save(pottery);
        cdi.save(cooking);
        cdi.save(maths);

        assertEquals(3, cdi.findAll().size());

        assertTrue(cdi.findAll().contains(maths));
        assertNotNull(cdi.findByDate(LocalDate.parse("2025-12-31")));

        assertFalse(cdi.delete(physics));
        assertNotNull(cdi.findByName("Cooking"));
    }

    @Test
    public void studentImplTest(){

        StudentDaoImpl sdi = new StudentDaoImpl();
        Student simon = new Student(1, "simon e", "simon@lexicon.se", "växjö");
        Student marcus = new Student(2, "Markus g", "marcus@lexicon.se", "Jönköping");
        Student sebbe = new Student(3, "Sebbe f", "sebbe@gotmail.com", "Åkersberga");

        assertNotNull(sdi);

        sdi.save(simon);
        assertFalse(sdi.findAll().isEmpty());

        sdi.delete(simon);

        assertTrue(sdi.findAll().isEmpty());

        sdi.save(simon);
        sdi.save(marcus);
        sdi.save(sebbe);

        assertEquals(3, sdi.findAll().size());

        assertNotNull(sdi.findByName("simon e"));

        assertTrue(sdi.findById(3) == sebbe);

        assertNotNull(sdi.findByEmail(marcus.getEmail()));
        assertTrue(sdi.findAll().contains(sebbe));
    }
}
