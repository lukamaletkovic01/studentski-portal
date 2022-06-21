package com.example.Studentska.sluzba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MAINBazaKreiranje {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {

		
		
		 Connection conn = null;
	        
	        conn = DriverManager.getConnection(
	                "jdbc:mariadb://localhost/studentskasluzba", "root", ""
	        );
	}
	

}
