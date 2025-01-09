package com.sprk.main;

import java.util.List;
import java.util.Scanner;

import com.sprk.connection.CreateConnection;
import com.sprk.dao.StudentDao;
import com.sprk.dao.StudentDaoImpl;
import com.sprk.entity.Student;

public class CrudApp {
	private static StudentDao getStudentDao() throws Exception {
		return new StudentDaoImpl(CreateConnection.getConnection());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {

			int choice;

			do {

				System.out.println(
						"Welcome to Student App\n1. Register New Student\n2. View All Student\n3. View Student By Rollno\n4. Update Student\n5. Delete Student\n6. Exit");
				choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					insertStudent();
					break;
				case 2:
					getAllStudentList();
					break;
				case 3:
					getStudentByRollNo();
					break;
				case 6:
					System.out.println("\n\nThanks for using\n\n");
					break;
				default:
					System.out.println("Please select correct options\n");

				}

			} while (choice != 6);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void insertStudent() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first name:");
		String firstName = sc.next();
		System.out.println("Enter last name:");
		String lastName = sc.next();
		System.out.println("Enter gender:");
		String gender = sc.next();
		System.out.println("Enter email:");
		String email = sc.next();

		Student student = new Student(0, firstName, lastName, email, gender);
		StudentDao dao = getStudentDao();
		int res = dao.saveStudent(student);
		if (res > 0) {
			System.out.println("Student Saved Successfully\n\n");
			getAllStudentList();
		} else {
			System.out.println("Something bad happen");

		}
	}

	private static void getAllStudentList() throws Exception {
		StudentDao dao = getStudentDao();

		List<Student> allStudent = dao.getAllStudents();
		for (Student tempStudent : allStudent) {
			System.out.println("\n"+tempStudent+"\n");
		}

	}

	private static void getStudentByRollNo() throws Exception {
		StudentDao dao = getStudentDao();
		System.out.println("Enter rollno: ");
		Scanner sc = new Scanner(System.in);
		int rollNo = sc.nextInt();
		sc.nextLine();

		Student student = dao.getStudentByRollNo(rollNo);
		if (student.getRollNo() != 0) {
			System.out.println(student);
		} else {
			System.out.println(String.format("Student with roll no: %d not found!", rollNo));
		}

	}
}
