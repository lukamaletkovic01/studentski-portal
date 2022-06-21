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
public class ProfesorController {
	
	//PROFESOR - HOME STRANA POCETAK
			@GetMapping("/HomeProf")
			public String profesorHome(Model m1) {
				
				DB db = new DB();
				
				Profesor p1 = db.dajProfesora("3");
				
				m1.addAttribute("profesori",p1);
				
				return "profesorIndex";
			} 
	//PROFESOR - HOME STRANA KRAJ
	
			
	
	//ANDRIJIN DEO - ODAVDE PA NA DALJE TREBA RADITI I CEO THYMELEAF
	//DODATI I SVE POTREBNE REDIREKCIJE ZA BILO KAKVU IZMENU BAZE PODATAKA
			
	//PROFESOR - PREGLED PREDMETA POCETAK
			
			@GetMapping("/profesorPredmeti")
			public String profesorPredmeti(Model m1) {
				
				DB db = new DB();
				
				List<Predmet> p1 = db.profesorDajPredmet("3");
				
				
				m1.addAttribute("predmeti",p1);
				
				return "profesorPredmeti";
			} 
			
	//PROFESOR - PREGLED PREDMETA KRAJ
			
	//PROFESOR - OTVARANJE I ZATVARENJE PRIJAVA POCETAK
			
			@GetMapping("/profesorPrijave")
			public String profesorPrijave(Model m1) {
				
				DB db = new DB();
				
				List<OtvaranjePrijaveUcitavanje> op1 = db.ProfesorOtvaranjePrijave("3");
				
				List<OtvaranjePrijave> op2 = db.PrikaziOtvorenePrijave("3");
				
				m1.addAttribute("op",op1);
				
				m1.addAttribute("opp",op2);
				
				return "profesorPrijave";
			} 
	//PROFESOR - OTVARANJE I ZATVARENJE PRIJAVA KRAJ
	
	//PROFESOR - PREGLED PRIJAVA I UPIS OCENA POCETAK
			@GetMapping("/profesorUpisiPregled")
			public String profesorUpisiPregledi(Model m1) {
				
				DB db = new DB();
				
				List<Ispit> p1 = db.profesorDajPrijave("3");
				
				List<Ispit> godine = new ArrayList<Ispit>();
				List<Predmet> predmeti = new ArrayList<Predmet>();
				
				godine = db.dajGodineZaPrijave("3");
				predmeti = db.dajPredmete("3");
				
				m1.addAttribute("ispiti", p1);
				m1.addAttribute("godine",godine);
				m1.addAttribute("predmeti", predmeti);
				
				//m1.addAttribute("godine",god);
				
				return "profesorUpisiPregled";
			} 
	//PROFESOR - PREGLED PRIJAVA I UPIS OCENA KRAJ
			
	//PROFESOR - UPIS OCENE POCETAK
			@GetMapping("/profesorUpisiPregled/UpisOcene")
			public RedirectView upisiOcenu(@RequestParam(name = "sifraPredmeta")String sifraPredmeta,@RequestParam(name = "ispitniRok")String ispitniRok,@RequestParam(name = "ocena")String ocena,@RequestParam(name = "skolskaGodina")int skolskaGodina,@RequestParam(name = "indeks")String indeks)
			{
				DB db = new DB();
				db.UpisiOcenu(sifraPredmeta,ispitniRok,ocena,skolskaGodina,indeks);
				
				RedirectView rv = new RedirectView();
				
				rv.setUrl("localhost:8080/profesorUpisiPregled");
				
				return rv;
						
				
				//NEDOVRSENO
			}
			//PROFESOR - UPIS OCENE KRAJ
			
			//PROFESOR - OTBARANJE PRIJAVA POCETAK
			
			@GetMapping("/profesorPrijave/OtvoriPrijavu")
			public RedirectView otvoriPrijavu(@RequestParam(name="datumPolaganja")String datumPolaganja,@RequestParam(name = "ispitniRok")String ispitniRok,
					@RequestParam(name="sifraPredmeta")String sifraPredmeta,@RequestParam(name="skolskaGodina")int skolskaGodina,
					@RequestParam(name= "datumOtvaranja")String datumOtvaranja, @RequestParam(name="datumZatvaranja")String datumZatvaranja)
			{
				DB db = new DB();
				OtvaranjePrijave o = new OtvaranjePrijave(sifraPredmeta,ispitniRok,datumPolaganja,skolskaGodina,datumOtvaranja,datumZatvaranja);
				add a = new add();
				
				a.dodajOtvorenePrijave(o, db.conn);
				
				RedirectView rv = new RedirectView();
				
				rv.setUrl("localhost:8080/profesorPrijave");
				
				return rv;
				
			}
			
			//PROFESOR - OTBARANJE PRIJAVA KRAJ
			
			@GetMapping("/profesorPrijave/IzmeniPrijavu")
			public RedirectView izmeniPrijavu(@RequestParam(name="datumPolaganja")String datumPolaganja,@RequestParam(name = "ispitniRok")String ispitniRok,
					@RequestParam(name="sifraPredmeta")String sifraPredmeta,@RequestParam(name="skolskaGodina")int skolskaGodina,
					@RequestParam(name= "datumOtvaranja")String datumOtvaranja, @RequestParam(name="datumZatvaranja")String datumZatvaranja)
			{
				DB db = new DB();
				OtvaranjePrijave o = new OtvaranjePrijave(sifraPredmeta,ispitniRok,datumPolaganja,skolskaGodina,datumOtvaranja,datumZatvaranja);
				add a = new add();
				
				
				
				a.izmeniOtvorenePrijave(o, db.conn);
				
				RedirectView rv = new RedirectView();
				
				rv.setUrl("localhost:8080/profesorPrijave");
				
				return rv;
				
			}
}
