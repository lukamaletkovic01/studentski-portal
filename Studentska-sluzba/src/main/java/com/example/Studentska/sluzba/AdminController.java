package com.example.Studentska.sluzba;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AdminController {

	//ADMIN STRANA POCETAK
	@GetMapping("/adminStudenti")
	public String adminStudent(Model m1) {
		
		DB db = new DB();
		
		List<Student> s1 =  new ArrayList<Student>();
		
		s1 = db.student();
		
		m1.addAttribute("studenti",s1);
		
		return "index";
	}
	@GetMapping("/adminIspiti")
	public String adminIspiti(Model m1) {
	
		DB db = new DB();
		
		List<Ispit> s1 =  new ArrayList<Ispit>();
		
		s1 = db.ispit();
		
		m1.addAttribute("ispiti",s1);
		
		return "ispiti";
	}
	
	
	@GetMapping("/adminPredmeti")
	public String adminPredmeti(Model m1) {
		DB db = new DB();
		
		List<Predmet> s1 =  new ArrayList<Predmet>();
		
		s1 = db.predmet();
		
		m1.addAttribute("predmeti",s1);
		

		return "predmeti";
	}
	
	
	@GetMapping("/adminProfesori")
	public String adminProfesori(Model m1) {

		DB db = new DB();
		
		List<Profesor> s1 =  new ArrayList<Profesor>();
		
		s1 = db.profesor();
		
		m1.addAttribute("profesori",s1);
		
		return "profesori";
	}
	
	//ADMIN STRANA KRAJ
	
	@GetMapping("/adminStudenti/insertStudent")
	public RedirectView studentInsert(@RequestParam(name = "ime") String ime, @RequestParam(name = "prezime") String prezime, @RequestParam(name = "imeoca") String imeoca,
			@RequestParam(name = "indeks") String indeks, @RequestParam(name = "studije") String studije, @RequestParam(name = "nazivsmera") String nazivsmera, @RequestParam(name = "status") String status,
			@RequestParam(name = "upisansemestar") String upisansemestar, @RequestParam(name = "jmbg") String jmbg, @RequestParam(name = "email") String email)
	{
		Student s = new Student(ime,imeoca,prezime,studije,nazivsmera,status,upisansemestar,jmbg,email,indeks);
		add a = new add();
		
		RedirectView rv = new RedirectView();
		rv.setUrl("http://localhost:8080/adminStudenti");
		
		try {
			Connection conn = DriverManager.getConnection(
			        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
			);
			
			a.dodajStudenta(s, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rv;
	}
	
	@SuppressWarnings("unused")
	@GetMapping("/adminStudenti/updateStudent")
	public RedirectView studentUpdate(@RequestParam(name = "ime") String ime, @RequestParam(name = "prezime") String prezime, @RequestParam(name = "imeoca") String imeoca,
			@RequestParam(name = "indeks") String indeks, @RequestParam(name = "studije") String studije, @RequestParam(name = "nazivsmera") String nazivsmera, @RequestParam(name = "status") String status,
			@RequestParam(name = "upisansemestar") String upisansemestar, @RequestParam(name = "jmbg") String jmbg, @RequestParam(name = "email") String email)
	{
		Statement stmt = null;
		
		Student s = new Student(ime,imeoca,prezime,studije,nazivsmera,status,upisansemestar,jmbg,email,indeks);
		add a = new add();
		
		RedirectView rv = new RedirectView();
		rv.setUrl("http://localhost:8080/adminStudenti");
			
			try {
				Connection conn = DriverManager.getConnection(
				        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
				);
				
				String sql = "DELETE FROM student WHERE Indeks = '"+ s.getIndeks() + "'";
		        
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				Connection conn = DriverManager.getConnection(
				        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
				);
				
				a.dodajStudenta(s, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return rv;
	}
	
	@GetMapping("/adminStudenti/deleteStudent")
	public RedirectView studentDelete(@RequestParam(name = "indeks") String indeks)
	{
		
		
		RedirectView rv = new RedirectView();
		rv.setUrl("http://localhost:8080/adminStudenti");
		
		try {
			Connection conn = DriverManager.getConnection(
			        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
			);
			
			String sql = "DELETE FROM student WHERE Indeks = '"+ indeks + "'";
	        
			   PreparedStatement pstmt = conn.prepareStatement(sql);
		         	            
		            pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rv;
	}
	
	
	@GetMapping("/adminProfesori/insertProfesor")
	public RedirectView profesorInsert(@RequestParam(name = "ime") String ime, @RequestParam(name = "prezime") String prezime, @RequestParam(name = "jmbg") String jmbg,
			@RequestParam(name = "id") String id, @RequestParam(name = "email") String email)
	{
		Profesor s = new Profesor(id,ime,prezime,jmbg,email);
		add a = new add();
		
		RedirectView rv = new RedirectView();
		rv.setUrl("http://localhost:8080/adminProfesori");
		
		try {
			Connection conn = DriverManager.getConnection(
			        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
			);
			
			a.dodajProfesora(s, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rv;
	}
	
	@SuppressWarnings("unused")
	@GetMapping("/adminProfesori/updateProfesor")
	public RedirectView profesorUpdate(@RequestParam(name = "ime") String ime, @RequestParam(name = "prezime") String prezime, @RequestParam(name = "jmbg") String jmbg,
			@RequestParam(name = "id") String id, @RequestParam(name = "email") String email)
	{
		Profesor s = new Profesor(id,ime,prezime,jmbg,email);
		
		RedirectView rv = new RedirectView();
		rv.setUrl("http://localhost:8080/adminProfesori");
			
		try {
				Connection conn = DriverManager.getConnection(
				        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
				);
				
				String sql = "DELETE FROM profesor WHERE IDProfesora = "+ id + "";
		        
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection(
			        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
			);
			add a = new add();
			a.dodajProfesora(s, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rv;
	}
	
	@GetMapping("/adminProfesori/deleteProfesor")
	public RedirectView profesorDelete(@RequestParam(name = "id") String id)
	{
		
		
		RedirectView rv = new RedirectView();
		rv.setUrl("http://localhost:8080/adminProfesori");
		
		try {
			Connection conn = DriverManager.getConnection(
			        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
			);
			
			String sql = "DELETE FROM profesor WHERE IDProfesora = "+ id + "";
	        
			PreparedStatement pstmt = conn.prepareStatement(sql);
		         	            
		    pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rv;
	}
	
	@GetMapping("/adminPredmeti/insertPredmet")
	public RedirectView predmetInsert(@RequestParam(name = "sifra") String sifra, @RequestParam(name = "naziv") String naziv, @RequestParam(name = "imeprofesora") String imeprofesora,
			@RequestParam(name = "prezimeprofesora") String prezimeprofesora, @RequestParam(name = "tip") String tip,@RequestParam(name = "espb") String espb,@RequestParam(name = "semestar") String semestar)
	{
		String sql = "select IDProfesora from profesor where Ime = '" + imeprofesora + "' and Prezime = '" + prezimeprofesora + "'";
		add a = new add();
		Statement stmt = null;
		RedirectView rv = new RedirectView();
		rv.setUrl("http://localhost:8080/adminPredmeti");
		
		try {
			Connection conn = DriverManager.getConnection(
			        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
			);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			String id = rs.getString(1);
			Predmet p = new Predmet(sifra,naziv,imeprofesora,prezimeprofesora,tip,Integer.parseInt(espb),Integer.parseInt(semestar),id);
			
			a.dodajPredmet(p, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rv;
	}
	
	@GetMapping("/adminPredmeti/updatePredmet")
	public RedirectView predmetUpdate(@RequestParam(name = "sifra") String sifra, @RequestParam(name = "naziv") String naziv, @RequestParam(name = "imeprofesora") String imeprofesora,
			@RequestParam(name = "prezimeprofesora") String prezimeprofesora, @RequestParam(name = "tip") String tip,@RequestParam(name = "espb") String espb,@RequestParam(name = "semestar") String semestar)
	{
		String sql = "SELECT IDProfesora FROM profesor WHERE Ime = '" + imeprofesora + "' AND Prezime = '" + prezimeprofesora + "'";
		add a = new add();
		Statement stmt = null;
		RedirectView rv = new RedirectView();
		rv.setUrl("http://localhost:8080/adminPredmeti");
		
		try {
			Connection conn = DriverManager.getConnection(
			        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
			);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			String id = rs.getString(1);
			Predmet p = new Predmet(sifra,naziv,imeprofesora,prezimeprofesora,tip,Integer.parseInt(espb),Integer.parseInt(semestar),id);
			
			this.predmetDelete(p.getSifraPredmeta());
			a.dodajPredmet(p, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rv;
	}
	
	@GetMapping("/adminPredmeti/deletePredmet")
	public RedirectView predmetDelete(@RequestParam(name = "sifra") String sifra)
	{
		RedirectView rv = new RedirectView();
		rv.setUrl("http://localhost:8080/adminPredmeti");
		
		try {
			Connection conn = DriverManager.getConnection(
			        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
			);
			
			String sql1 = "DELETE FROM predmet WHERE SifraPredmeta = '"+ sifra + "'";
	        
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		         	            
		    pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rv;
	}
	
	@GetMapping("/adminIspiti/deletePolozeni")
	public RedirectView polozeniDelete(@RequestParam(name = "sifraPredmeta") String sifraPredmeta,
			@RequestParam(name = "indeks") String indeks, @RequestParam(name = "ispitniRok") String ispitniRok)
	{
		RedirectView rv = new RedirectView();
		rv.setUrl("http://localhost:8080/adminIspiti");
		
		try {
			Connection conn = DriverManager.getConnection(
			        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
			);
			
			add a = new add();
			a.ponistiIspit(indeks, sifraPredmeta, ispitniRok, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rv;
	}
}
