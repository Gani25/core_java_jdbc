package com.sprk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertStudent {
	
	public static void main(String[] args) {

		try {
			// Copy Qualified name - com.mysql.cj.jdbc.Driver.class
			// 1st Register Driver Class (Optional)		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2nd Get Connection object
			String username = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/core_java";
			
//			"jdbc:mysql://localhost:3306/database_name";
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			System.out.println(conn);
			
			// 3rd Create SQL statement
			String sql = "insert into student(first_name, last_name, gender, email) values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, "Rohan");
			ps.setString(2, "Sable");
			ps.setString(3, "Male");
			ps.setString(4, "rohan12@gmail.com");
			
			// 4th Execute Statement
			int result = ps.executeUpdate();
			if(result>0) {
				System.out.println("Insert Successfull");
			}else {
				System.out.println("Something bad happen on server!!");
				
			}
			
			// 5th Close all
			conn.close();
			ps.close();
			
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
