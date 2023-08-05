package com.data;

import java.util.ArrayList;
import java.util.Scanner;

public class STUDENT_MANAGEMENT_SYSTEM {
    private ArrayList<Student> students;

    public STUDENT_MANAGEMENT_SYSTEM() {

        students = new ArrayList<>();

    }

    // Add a new student to the system

    public void addStudent(Student student) {

        students.add(student);

    }

    // Remove a student from the system by roll number

    public boolean removeStudent(int rollNumber) {

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getRollNumber() == rollNumber) {

                students.remove(i);

                return true;

            }

        }

        return false;

    }

    // Search for a student by roll number

    public Student searchStudent(int rollNumber) {

        for (Student student : students) {

            if (student.getRollNumber() == rollNumber) {

                return student;

            }

        }

        return null;

    }

 

    // Display all students

    public void displayAllStudents() {

        for (Student student : students) {

            System.out.println(student);

        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        STUDENT_MANAGEMENT_SYSTEM system = new STUDENT_MANAGEMENT_SYSTEM();


        while (true) {

            System.out.println("\nStudent Management System");

            System.out.println("1. Add a new student");

            System.out.println("2. Remove a student");

            System.out.println("3. Search for a student");

            System.out.println("4. Display all students");

            System.out.println("5. Exit");

 

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            scanner.nextLine(); // Consume the newline character after reading the integer

 

            switch (choice) {

                case 1:

                    System.out.print("Enter student name: ");

                    String name = scanner.nextLine();

                    System.out.print("Enter roll number: ");

                    int rollNumber = scanner.nextInt();

                    scanner.nextLine(); // Consume the newline character after reading the integer

                    System.out.print("Enter grade: ");

                    String grade = scanner.nextLine();

 

                    // Input validation

                    if (!name.isEmpty() && !grade.isEmpty()) {

                        Student newStudent = new Student(name, rollNumber, grade);

                        system.addStudent(newStudent);

                        System.out.println("Student added successfully!");

                    } else {

                        System.out.println("Error: Name and Grade cannot be empty.");

                    }

                    break;

 

                case 2:

                    System.out.print("Enter roll number of the student to remove: ");

                    int removeRollNumber = scanner.nextInt();

                    scanner.nextLine(); // Consume the newline character after reading the integer

                    boolean removed = system.removeStudent(removeRollNumber);

                    if (removed) {

                        System.out.println("Student removed successfully!");

                    } else {

                        System.out.println("Student with the specified roll number not found.");

                    }

                    break;

 

                case 3:

                    System.out.print("Enter roll number of the student to search: ");

                    int searchRollNumber = scanner.nextInt();

                    scanner.nextLine(); // Consume the newline character after reading the integer

                    Student foundStudent = system.searchStudent(searchRollNumber);

                    if (foundStudent != null) {

                        System.out.println("Student found:\n" + foundStudent);

                    } else {

                        System.out.println("Student with the specified roll number not found.");

                    }

                    break;

 

                case 4:

                    System.out.println("All students:");

                    system.displayAllStudents();

                    break;

 

                case 5:

                    System.out.println("Exiting the application.");

                    scanner.close();

                    System.exit(0);

                    break;

 

                default:

                    System.out.println("Invalid choice. Please try again.");

                    break;

            }

        }

    }
    
}

class Student {

    private String name;

    private int rollNumber;

    private String grade;

 

    // Constructor

    public Student(String name, int rollNumber, String grade) {

        this.name = name;

        this.rollNumber = rollNumber;

        this.grade = grade;

    }

 

    // Getters and Setters

    public String getName() {

        return name;

    }

 

    public void setName(String name) {

        this.name = name;

    }

 

    public int getRollNumber() {

        return rollNumber;

    }

 

    public void setRollNumber(int rollNumber) {

        this.rollNumber = rollNumber;

    }

 

    public String getGrade() {

        return grade;

    }

 

    public void setGrade(String grade) {

        this.grade = grade;

    }

 

    @Override

    public String toString() {

        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;

    }

}