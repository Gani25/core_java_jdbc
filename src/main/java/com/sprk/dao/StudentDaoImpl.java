package com.sprk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sprk.entity.Student;

public class StudentDaoImpl implements StudentDao {
	
	private Connection conn;
	
	public StudentDaoImpl(Connection conn) {
		this.conn = conn;
	
	}

	@Override
	public List<Student> getAllStudents() throws SQLException {
		String sql = "select * from student";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Student> students = new ArrayList<>();
		
		while (rs.next())
		{
			Student student = new Student();
			student.setRollNo(rs.getInt("roll_no"));
			student.setFirstName(rs.getString(2));
			student.setLastName(rs.getString("last_name"));
			student.setEmail(rs.getString("email"));
			student.setGender(rs.getString("gender"));
			
			students.add(student);
		}
		return students;
	}

}
