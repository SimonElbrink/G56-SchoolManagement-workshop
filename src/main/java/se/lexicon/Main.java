package se.lexicon;

import dao.*;
import model.*;

import java.time.LocalDate;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        StudentDao studentDao = new StudentDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();
        Scanner scanner = new Scanner(System.in);
       boolean iscontinu= false;

          do {
        //while (true) {
            System.out.println("\n--- School Management CLI ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Register Student to Course");
            System.out.println("4. View All Students");
            System.out.println("5. View All Courses");
            System.out.println("0. Exit");
            System.out.print("Select option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 : {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    int id = studentDao.findAll().size() + 1;
                    Student s = new Student(id, name, email, address);
                    studentDao.save(s);
                    System.out.println("Student added.");


                }
                break;
                case 2 : {
                    System.out.print("Course Name: ");
                    String cname = scanner.nextLine();
                    System.out.print("Start Date (yyyy-mm-dd): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine());
                    System.out.print("Duration in weeks: ");
                    int weeks = scanner.nextInt();
                    scanner.nextLine();
                    int id = courseDao.findAll().size() + 1;
                    Course c = new Course(id, cname, date, weeks);
                    courseDao.save(c);
                    System.out.println("Course added.");
                }
                break;
                case 3 : {
                    System.out.print("Student ID: ");
                    int sid = scanner.nextInt();
                    System.out.print("Course ID: ");
                    int cid = scanner.nextInt();
                    scanner.nextLine();
                    Student student = studentDao.findById(sid);
                    Course course = courseDao.findById(cid);
                    if (student != null && course != null) {
                        course.register(student);
                        System.out.println("Student registered to course.");
                    } else {
                        System.out.println("Invalid student or course ID.");
                    }
                }
                break;
                case 4 : studentDao.findAll().forEach(System.out::println);
                    break;
                case 5 : courseDao.findAll().forEach(c -> {
                    System.out.println(c);
                    System.out.println(" Enrolled: " + c.getStudents().size());
                });
                    break;
                case 0 : {
                    System.out.println("Goodbye!");
                    return;
                }

                default : System.out.println("Invalid option.");

            }
              System.out.println("Do you want to perform more action:?=");
              String ans=scanner.nextLine();
              if (ans=="Y"||ans=="Yes")
              {
                  iscontinu=true;
              }
              else{
                  iscontinu=false;
              }


            }while(!iscontinu);




        }

    }
