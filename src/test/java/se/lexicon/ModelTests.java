package se.lexicon;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;

public class ModelTests {

    @Test
    public void testModelClasses(){
        Student st1 = new Student(1, "student 1", "student1@email.se", "student 1 home Stockholm" );
        Student st2 = new Student(2, "student 2", "student2@email.se", "student 2 home Stockholm" );
        Student st3 = new Student(3, "student 3", "student3@email.se", "student 3 home Stockholm" );
        Student st4 = new Student(4, "student 4", "student4@email.se", "student 4 home Stockholm" );
        Student st5 = new Student(5, "student 5", "student5@email.se", "student 5 home Stockholm" );

        //int id, String courseName, LocalDate startDate, int weekDuration, List<Student> students
        Course course1 = new Course(1, "pottery", LocalDate.parse(("2025-08-31")), 27, new ArrayList<>());
        Course course2 = new Course(2, "woodworking", LocalDate.parse(("2025-09-31")), 14, new ArrayList<>());
        Course course3 = new Course(3, "Cooking", LocalDate.parse(("2025-05-27")), 5, new ArrayList<>());
        Course course4 = new Course(4, "Maths", LocalDate.parse(("2025-12-31")), 105, new ArrayList<>());
        Course course5 = new Course(5, "Physics", LocalDate.parse(("2025-08-31")), 200, new ArrayList<>());


    }
}
