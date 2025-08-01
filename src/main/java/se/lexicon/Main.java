package se.lexicon;

import se.lexicon.dao.CourseDao;
import se.lexicon.dao.CourseDaoImpl;
import se.lexicon.dao.StudentDao;
import se.lexicon.dao.StudentDaoImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static StudentDao studentDao = new StudentDaoImpl();
    private static CourseDao  courseDao = new CourseDaoImpl();

    public static void main(String[] args) {

        boolean running = true;

        while(running){
            System.out.println("--New Student--");
            System.out.println("1. Add new student");
            System.out.println("2. Find student by email");
            System.out.println("3. Find all students");
            System.out.println("4. Exit");

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    findByEmail();
                    break;
                case 3:
                    findAllStudents();
                    break;
                case 4:
                    running=false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
    private static void addStudent() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Student student = new Student(id, name, email, address);
        studentDao.save(student);
        System.out.println("Student saved.");
    }
    private static void findByEmail() {
        System.out.println("Enter email");
        String email = scanner.nextLine();

        Student student = studentDao.findByEmail(email);

        if(student != null){
            System.out.println(student);
        } else {
            System.out.println("Student not found");
        }
    }

    private static void findAllStudents() {
        List<Student> students = studentDao.findAll();
        if (students.isEmpty()){
            System.out.println("No students found.");
        } for (Student student:students){
            System.out.println(student);
        }
    }
}