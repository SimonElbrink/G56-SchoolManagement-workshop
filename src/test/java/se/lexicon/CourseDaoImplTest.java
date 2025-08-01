package se.lexicon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.dao.CourseDao;
import se.lexicon.dao.CourseDaoImpl;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CourseDaoImplTest {

    private CourseDao courseDao;
    private Course course1;
    private Course course2;
    private Course course3;
    private Course course4;

    @BeforeEach
    void setUp(){
        courseDao = new CourseDaoImpl();
        course1 = new Course(1, "Web Design", LocalDate.of(2025, 10, 8),  4);
        course2 = new Course(2, "Data Science", LocalDate.of(2025,9,10), 6);
        course3 = new Course(3, "Photography", LocalDate.of(2025, 10,10), 6);
        course4 = new Course(4, "Web Design", LocalDate.of(2025, 12, 1), 8);

    }
    @Test
    void testSaveCourseSuccess(){

        Course savedCourseOne = courseDao.save(course1);

        assertNotNull(course1);
        assertEquals("Web Design", savedCourseOne.getCourseName());
        assertEquals(1, courseDao.findAll().size());
    }
    @Test
    void testSaveNoDuplicates(){
        Course courseDuplicate = new Course(1, "Web Design", LocalDate.of(2025, 10, 8),  4);
        Course savedCourseOne = courseDao.save(course1);//(1, "Web Design", LocalDate.of(2025, 10, 8),  4);
        Course savedCourseDupl = courseDao.save(courseDuplicate);

        assertEquals("Web Design", savedCourseOne.getCourseName());
        assertEquals(1, courseDao.findAll().size());
        assertNull(savedCourseDupl);
    }
    @Test
    void testFindById(){
        Course savedCourseOne = courseDao.save(course1);//(1, "Web Design", LocalDate.of(2025, 10, 8),  4);
        Course savedCourseTwo = courseDao.save(course2);//(2, "Data Science", LocalDate.of(2025,9,10), 6);
        Course savedCourseTree = courseDao.save(course3);//(3, "Photography", LocalDate.of(2025, 10,10), 6);

        Course foundCourse = courseDao.findById(2);

        assertNotNull(foundCourse);
        assertEquals("Data Science", foundCourse.getCourseName());
        assertEquals(6, foundCourse.getWeekDuration());
    }

    @Test
    void testFindByName() {

        Course saveCourseOne = courseDao.save(course1);//(1, "Web Design", LocalDate.of(2025, 10, 8),  4);
        Course saveCourseTwo = courseDao.save(course2);//(2, "Data Science", LocalDate.of(2025,9,10), 6);
        Course savedCourseTree = courseDao.save(course3);//(3, "Photography", LocalDate.of(2025, 10,10), 6);
        Course savedCourseFour = courseDao.save(course4);// (4, "Web Design", LocalDate.of(2025, 12, 1), 8);


        List<Course> foundName = courseDao.findByName("Web Design");

        assertNotNull(foundName);
        assertEquals(2, foundName.size());
    }

    @Test
    void testFindByDate() {

        Course saveCourseOne = courseDao.save(course1);//(1, "Web Design", LocalDate.of(2025, 10, 8),  4);
        Course saveCourseTwo = courseDao.save(course2);//(2, "Data Science", LocalDate.of(2025,9,10), 6);
        Course savedCourseTree = courseDao.save(course3);//(3, "Photography", LocalDate.of(2025, 10,10), 6);
        Course savedCourseFour = courseDao.save(course4);// (4, "Web Design", LocalDate.of(2025, 12, 1), 8);


        List<Course> foundName = courseDao.findByDate(LocalDate.of(2025, 10, 8));

        assertNotNull(foundName);
        assertEquals(1, foundName.size());
    }
    @Test
    void testFindAll(){
        Course saveCourseOne = courseDao.save(course1);//(1, "Web Design", LocalDate.of(2025, 10, 8),  4);
        Course saveCourseTwo = courseDao.save(course2);//(2, "Data Science", LocalDate.of(2025,9,10), 6);
        Course savedCourseTree = courseDao.save(course3);//(3, "Photography", LocalDate.of(2025, 10,10), 6);
        Course savedCourseFour = courseDao.save(course4);// (4, "Web Design", LocalDate.of(2025, 12, 1), 8);

        List<Course> foundCourse = courseDao.findAll();

        assertNotNull(foundCourse);
        assertEquals(4, foundCourse.size());
        assertTrue(foundCourse.contains(course1));
        assertTrue(foundCourse.contains(course2));
        assertTrue(foundCourse.contains(course3));
        assertTrue(foundCourse.contains(course4));
    }

    @Test
    void testDelete(){
        Course saveCourseOne = courseDao.save(course1);//(1, "Web Design", LocalDate.of(2025, 10, 8),  4);
        Course saveCourseTwo = courseDao.save(course2);//(2, "Data Science", LocalDate.of(2025,9,10), 6);
        Course savedCourseTree = courseDao.save(course3);//(3, "Photography", LocalDate.of(2025, 10,10), 6);
        Course savedCourseFour = courseDao.save(course4);// (4, "Web Design", LocalDate.of(2025, 12, 1), 8);

        boolean foundCourse = courseDao.delete(saveCourseOne);

        assertTrue(foundCourse);
        assertEquals(3, courseDao.findAll().size());
    }
}
