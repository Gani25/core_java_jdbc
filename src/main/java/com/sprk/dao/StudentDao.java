package com.sprk.dao;

import java.sql.SQLException;
import java.util.List;

import com.sprk.entity.Student;

public interface StudentDao {
	
	List<Student> getAllStudents() throws SQLException;

}
