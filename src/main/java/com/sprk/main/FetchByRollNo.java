package com.sprk.main;

import com.sprk.connection.CreateConnection;
import com.sprk.dao.StudentDao;
import com.sprk.dao.StudentDaoImpl;
import com.sprk.entity.Student;

public class FetchByRollNo {

	public static void main(String[] args) {

		try {
			StudentDao dao = new StudentDaoImpl(CreateConnection.getConnection());

			Student student = dao.getStudentByRollNo(30);

			if (student.getRollNo() != 0) {
				System.out.println(student);
			} else {
				System.out.println("Student not found!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
