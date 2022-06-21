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

@SuppressWarnings("unused")
@Controller
public class StudentController {
	
	//STUDENT - HOME STRANA POCETAK
		@GetMapping("/Home")
		public String studentStudent(Model m1) {
			
			DB db = new DB();
			double s2;
			int s3;
			Student s1 = null;

			s1 = db.dajStudenta("57/2018");
			s2 = db.dajProsek("57/2018");
			s3 = db.dajEspb("57/2018");
			
		
			
			s1.setProsek(s2);
			s1.setEspb(s3);
			m1.addAttribute("stud",s1);
			m1.addAttribute("studenti",s1);
			
			return "indexStudenti";
		} //STUDENT - HOME STRANA KRAJ
		
		//STUDENT PREDMETI POCETAK
		
		@GetMapping("/StudentPredmeti")
		public String studentPredmeti(Model m1) {
			
			DB db = new DB();
			
			List<Predmet> s1 =  new ArrayList<Predmet>();
			
			s1 = db.dajPredmeteKojePohadjam("57/2018");
			
			m1.addAttribute("predmeti",s1);
			
			return "studentPredmeti";
		}
		
		//STUDENT PREDMETI KRAJ
		
		
		//STUDENT PREDMETI PREGLED POCETAK
		
		@GetMapping("/studentPregledPredmeti")
		public String studentPregledPredmeti(Model m1) {
			
			DB db = new DB();
			
			List<Predmet> s1 =  new ArrayList<Predmet>();
			
			s1 = db.dajPredmeteKojeSlusam("57/2018");
			
			m1.addAttribute("predmeti",s1);
			

			return "studentPregledPredmeti";
		}
		
		//STUDENT PREGLEDI  KRAJ
		
		//STUDENT ISPITI PREGLED POCETAK
		
		@GetMapping("/studentPregledIspiti")
		public String studentPregledIspiti(Model m1) {
			
			DB db = new DB();
			
			List<Ispit> s1 =  new ArrayList<Ispit>();
			
			s1 = db.dajIspite("57/2018");
			
			m1.addAttribute("ispiti",s1);
			

			return "studentPregledIspiti";
		}
		
		
		@GetMapping("/studentPregledPolozenihIspita")
		public String studentPregledPolozenihIspita(Model m1) {
			
			DB db = new DB();
			
			List<Ispit> s1 =  new ArrayList<Ispit>();
			
			s1 = db.dajPolozeneIspite("57/2018");
			
			m1.addAttribute("ispiti",s1);
			

			return "studentPregledPolozenihIspita";
		}
		
		
		
		//STUDENT ISPITI KRAJ
		
		//STUDENT PRIJAVA POCETAK
		
		@GetMapping("/StudentPrijava")
		public String studentPrijava(Model m1)
		{
			DB db = new DB();
			
			List<Predmet> s1 = new ArrayList<Predmet>();
			
			s1 = db.prijaviIspite("57/2018");
			
			m1.addAttribute("predmeti",s1);
			
			return "studentPrijava";
		}
		//STUDENT PRIJAVA KRAJ
		
		//STUDENT UPISIVANJE OCENJE POCETAK
		@GetMapping("/StudentPredmeti/UpisiPredmet")
		public RedirectView upisiPredmet(@RequestParam(name = "indeks")String indeks,
				@RequestParam(name = "sifraPredmeta")String sifraPredmeta) {
			
			Statement stmt = null;
			
			Pohadjam p = new Pohadjam(indeks,sifraPredmeta);
			add a = new add();
			
			RedirectView rv = new RedirectView();
			rv.setUrl("http://localhost:8080/StudentPredmeti");
			
			Connection conn;
			try {
				conn = DriverManager.getConnection(
				        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
				);
				a.dodajPohadjam(p, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
			return rv;
		}
		
		//STUDENT ISPISIVANJE SA PREDMETA
		@GetMapping("/StudentPregledPredmeti/IspisiPredmeti")
		public RedirectView ispisiPredmet(@RequestParam(name = "indeks")String indeks, @RequestParam(name = "sifraPredmeta")String sifraPredmeta)
		{
			Statement stmt = null;
			add a = new add();
			
			RedirectView rv = new RedirectView();
			rv.setUrl("http://localhost:8080/studentPregledPredmeti");
			
			Connection conn;
			
			try {
				conn = DriverManager.getConnection(
				        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
				);
				
				a.ispisiPohadjam(indeks, sifraPredmeta, conn);
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
			return rv;
			
		}
		//STUDENT UPISIVANJE OCENJE KRAJ
		
		//STUDENT PRIJAVA ISPITA POCETAK
		
		@GetMapping("/StudentPrijava/PrijaviIspit")
		
		public RedirectView prijaviIspit(@RequestParam(name = "sifraPredmeta")String sifraPredmeta,@RequestParam(name = "ispitniRok")String ispitniRok,
				@RequestParam(name = "datumPolaganja")String datumPolaganja,@RequestParam(name = "ocena")int ocena,
				@RequestParam(name = "imeProfesora")String imeProfesora,@RequestParam(name = "prezimeProfesora")String prezimeProfesora,
				@RequestParam(name="skolskaGodina") int skolskaGodina,
				@RequestParam(name = "indeks")String indeks,@RequestParam(name = "naziv")String naziv)
		{
			
			RedirectView rv = new RedirectView();
			rv.setUrl("http://localhost:8080/StudentPrijava");
			
			try {
				Connection conn;
				conn= DriverManager.getConnection("jdbc:mariadb://localhost/studentskasluzba", "root", "");
				
				add dodaj = new add();
				
				String sql = "SELECT IDProfesora FROM profesor WHERE ime = '" + imeProfesora + "' AND prezime = '" + prezimeProfesora +"'"; 
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				if(rs.next())
				{
					String IDProfesora = rs.getString(1);
					dodaj.dodajIspit(new Ispit(sifraPredmeta,ispitniRok,datumPolaganja,ocena,IDProfesora,skolskaGodina,indeks,naziv), conn);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return rv;
			
		}
		
		//STUDENT PRIJAVA ISPITA KRAJ
}
