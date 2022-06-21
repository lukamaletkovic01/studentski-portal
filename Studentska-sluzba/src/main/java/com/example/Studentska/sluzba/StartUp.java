package com.example.Studentska.sluzba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class StartUp {

	public void dodajStraneKljuceve(Connection conn)
	{
		Statement stmt = null;

		String sql1 = "ALTER TABLE pohadjam " + "ADD FOREIGN KEY (Indeks) REFERENCES student(Indeks), " + "ADD FOREIGN KEY (SifraPredmeta) REFERENCES predmet(SifraPredmeta)"; 
		String sql2 = "ALTER TABLE predmet " +  "ADD FOREIGN KEY (IDProfesora) REFERENCES profesor(IDProfesora) ;";
		String sql3 = "ALTER TABLE ispit " + "ADD FOREIGN KEY (indeks) REFERENCES student(Indeks), " + "ADD FOREIGN KEY (SifraPredmeta) REFERENCES pohadjam(SifraPredmeta), " + "ADD FOREIGN KEY (IDIspitivaca) REFERENCES profesor(IDProfesora); ";
		String sql4 = "ALTER TABLE polozeni " + "ADD FOREIGN KEY (SifraPredmeta) REFERENCES ispit(SifraPredmeta);";
		
		 try {
	        	stmt = conn.createStatement();
	        	ResultSet rs = stmt.executeQuery(sql1);
	        	stmt.executeQuery(sql2);
	        	stmt.executeQuery(sql3);
	        	stmt.executeQuery(sql4);
			} catch (SQLException e) {
				
			}
		
	}
	
	public void kreirajTabeluStudent(Connection conn)
	{
		Statement stmt = null;
		String sql = "CREATE TABLE student"
                + "(Ime VARCHAR(30), "
                + " ImeOca VARCHAR(30), "
                + " Prezime VARCHAR(30), "
                + " Studije VARCHAR(30), "
                + " NazivSmera VARCHAR(30), "
                + " Status VARCHAR(30), "
                + " UpisanSemestar VARCHAR(30), "
                + " Jmbg VARCHAR(13), "
                + " Email VARCHAR(30), "
                + " Indeks VARCHAR(10), "
                + " PRIMARY KEY ( Indeks ) ) ";

        try {
        	stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			
		}
	}
	
	public void kreirajTabeluPohadjam(Connection conn)
	{
		Statement stmt = null;
		String sql = "CREATE TABLE pohadjam"
                + "(ID int not NULL AUTO_INCREMENT, "
                + " Indeks VARCHAR(10), "
                + " SifraPredmeta VARCHAR(10), "
                + " PRIMARY KEY ( ID ) ) ";

        try {
        	stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			
		}
	}
	
	public void kreirajTabeluKorisnici(Connection conn)
	{
		Statement stmt = null;
		String sql = "CREATE TABLE korisnici"
                + "(Username VARCHAR(30), "
                + " Password VARCHAR(30), "
                + " Tip int, "
                + " ID VARCHAR(30), "
                + " PRIMARY KEY ( Username ) ) ";

        try {
        	stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			
			
		}
	}
	
	public void kreirajTabeluProfesor(Connection conn)
	{
		Statement stmt = null;
		String sql = "CREATE TABLE profesor"
                + "(IDProfesora VARCHAR(30), "
                + " Ime VARCHAR(30), "
                + " Prezime VARCHAR(30), "
                + " Jmbg VARCHAR(13), "
                + " Email VARCHAR(30), "
                + " PRIMARY KEY ( IDProfesora ) ) ";

        try {
        	stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
	
			
		}
	}
	
	public void kreirajTabeluPredmet(Connection conn)
	{
		Statement stmt = null;
		String sql = "CREATE TABLE predmet"
                + "(SifraPredmeta VARCHAR(30), "
                + " NazivPredmeta VARCHAR(30), "
                + " IDProfesora VARCHAR(30), "
                + " TipPredmeta VARCHAR(30), "
                + " ESPB int, "
                + " Semestar int, "
                + " PRIMARY KEY ( SifraPredmeta ) ) ";

        try {
        	stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
	
			
		}	
	}
	
	public void kreirajTabeluIspit(Connection conn)
	{
		Statement stmt = null;
		String sql = "CREATE TABLE ispit"
                + "(SifraPredmeta VARCHAR(30), "
                + " IspitniRok VARCHAR(30), "
                + " DatumPolaganja VARCHAR(30), "
                + " Ocena int, "
                + " IDIspitivaca VARCHAR(30), "
                + " skolskaGodina int, "
                + " indeks VARCHAR(10), "
                + " CONSTRAINT PK_ispit PRIMARY KEY (SifraPredmeta,IspitniRok,indeks));";

        try {
        	stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
	
			
		}	
	}
	
	public void kreirajTabeluPolozeni(Connection conn)
	{
		Statement stmt = null;
		String sql = "CREATE TABLE polozeni"
                + "(SifraPredmeta VARCHAR(30), "
                + " IspitniRok VARCHAR(30), "
                + " DatumPolaganja VARCHAR(30), "
                + " Ocena int, "
                + " IDIspitivaca VARCHAR(30), "
                + " skolskaGodina int, "
                + " indeks VARCHAR(10), "
                + " CONSTRAINT PK_ispit PRIMARY KEY (SifraPredmeta,IspitniRok,indeks));";

        try {
        	stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
	
			
		}
	}
	
	
	public void kreirajTabeluOtvorenePrijave(Connection conn)
	{
		Statement stmt = null;
		String sql = "CREATE TABLE otvoreneprijave"
                + "(SifraPredmeta VARCHAR(30), "
                + " IspitniRok VARCHAR(30), "
                + " DatumPolaganja DATE, "
                + " skolskaGodina int, "
                + " datumOtvaranjaPrijave VARCHAR(30), "
                + " datumZatvaranjaPrijave VARCHAR(30), "
                + " CONSTRAINT PK_ispit PRIMARY KEY (SifraPredmeta,IspitniRok));";

        try {
        	stmt = conn.createStatement();
        	ResultSet rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
	
			
		}
	}
}
