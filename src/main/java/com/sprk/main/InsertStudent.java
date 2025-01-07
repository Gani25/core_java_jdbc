package com.sprk.main;

import com.sprk.connection.CreateConnection;
import com.sprk.dao.StudentDao;
import com.sprk.dao.StudentDaoImpl;
import com.sprk.entity.Student;

public class InsertStudent {

	public static void main(String[] args) {
		try {
			StudentDao studentDao = new StudentDaoImpl(CreateConnection.getConnection());

			Student student = new Student();
			student.setFirstName("Pranjal");
			student.setLastName("Sharma");
			student.setGender("Female");
			student.setEmail("pranjal12@gmail.com");
			int result = studentDao.saveStudent(student);
			if (result > 0) {
				System.out.println("Student saved successfully");
			} else {
				System.out.println("Something went wrong");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
