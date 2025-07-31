package se.lexicon;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();

        Student s1 = new Student(1, "Alice", "alice@mail.com", "Stockholm");
        Student s2 = new Student(2, "Bob", "bob@mail.com", "Skillingaryd");
        studentDao.save(s1);
        studentDao.save(s2);

        Course c1 = new Course(1, "Java", 5);
        courseDao.save(c1);

        Course c2 = new Course(2, "Spring Boot", 15);
        courseDao.save(c2);

        System.out.println("Find by email:");
        System.out.println(studentDao.findByEmail("bob@mail.com"));

        System.out.println("Find by name:");
        System.out.println(studentDao.findByName("Alice"));

        System.out.println("\nAll students:");
        System.out.println(studentDao.findAll());

        System.out.println("\nAll courses:");
        System.out.println(courseDao.findAll());

        c1.register(s1);
        c1.register(s2);
        System.out.println("\nStudents in Java course:");
        System.out.println(c1.getStudents());

        studentDao.delete(s2);
        System.out.println("\nAfter deleting Bob:");
        System.out.println(studentDao.findAll());

        courseDao.delete(c2);
        System.out.println("\nAfter deleting Spring Boot course:");
        System.out.println(courseDao.findAll());
    }
}