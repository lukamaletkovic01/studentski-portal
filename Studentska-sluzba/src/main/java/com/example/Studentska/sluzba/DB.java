package com.example.Studentska.sluzba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB {

	Connection conn = null;
	Statement stmt = null;
	String sql = null;
	String sql1 = null;
	String sql2 = null;
	
	public DB()
	{
		  conn = null;
	        
	        try {
				conn = DriverManager.getConnection(
				        "jdbc:mariadb://localhost/studentskasluzba", "root", ""  
				);
				
			stmt = conn.createStatement();	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}
	
	
	public List<Student> student()
	{
		sql = "select * from student";
		List<Student> s = new ArrayList<Student>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			while(!rs.isLast())
			{
				
				String ime = rs.getString(1);
				String imeOca = rs.getString(2);
				String Prezime = rs.getString(3);
				String Studije = rs.getString(4);
				String nazivSmera = rs.getString(5);
				String Status = rs.getString(6);
				String UpisanSemestar = rs.getString(7);
				String Jmbg = rs.getString(8);
				String Email = rs.getString(9);
				String Indeks = rs.getString(10);
				rs.next();
				s.add(new Student(ime,imeOca,Prezime,Studije,nazivSmera,Status,UpisanSemestar,Jmbg,Email,Indeks));
			}
			String ime = rs.getString(1);
			String imeOca = rs.getString(2);
			String Prezime = rs.getString(3);
			String Studije = rs.getString(4);
			String nazivSmera = rs.getString(5);
			String Status = rs.getString(6);
			String UpisanSemestar = rs.getString(7);
			String Jmbg = rs.getString(8);
			String Email = rs.getString(9);
			String Indeks = rs.getString(10);
			
			s.add(new Student(ime,imeOca,Prezime,Studije,nazivSmera,Status,UpisanSemestar,Jmbg,Email,Indeks));
			return s;
			
		} catch (Exception e) {
		}
		return null;
	}
	
	public Student dajStudenta(String indeks)
	{
		sql = "select * from student where Indeks = '" + indeks + "'";
		Student s = null;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			else
			{
				String ime = rs.getString(1);
				String imeOca = rs.getString(2);
				String Prezime = rs.getString(3);
				String Studije = rs.getString(4);
				String nazivSmera = rs.getString(5);
				String Status = rs.getString(6);
				String UpisanSemestar = rs.getString(7);
				String Jmbg = rs.getString(8);
				String Email = rs.getString(9);
				String Indeks = rs.getString(10);
				
				s = new Student(ime,imeOca,Prezime,Studije,nazivSmera,Status,UpisanSemestar,Jmbg,Email,Indeks);
			}
			
			return s;
			
		} catch (Exception e) {
		}
		return null;
	}
	
	
	public double dajProsek(String indeks)
	{
		double prosek = 0.0;
		int br = 0;
		sql = "select * from polozeni where indeks = '"+ indeks +"' and Ocena > 5";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return 0;
			while(!rs.isLast())
			{
				prosek += rs.getInt(4);
				br++;
				rs.next();
			}
			prosek += rs.getInt(4);
			br++;
			
			
			return prosek/br;
			
		} catch (Exception e) {
		}
		return 0;
	}
	
	public int dajEspb(String indeks)
	{
		sql = "SELECT * FROM polozeni i join predmet p on i.SifraPredmeta = p.SifraPredmeta and i.indeks = '" + indeks + "' where i.Ocena > 5";

		try {
			int br = 0;

			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return 0;
			while(!rs.isLast())
			{
				br += rs.getInt(12);
				rs.next();
			}
			br += rs.getInt(12);
			return br;
			
		} catch (Exception e) {
		}
		return 0;
	}
	
	public List<Profesor> profesor()
	{
		sql = "select * from profesor";
		List<Profesor> s = new ArrayList<Profesor>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			while(!rs.isLast())
			{
				String IDProfesora = rs.getString(1);
				String Ime = rs.getString(2);
				String Prezime = rs.getString(3);
				String Jmbg = rs.getString(4);
				String Email = rs.getString(5);
				rs.next();
				s.add(new Profesor(IDProfesora,Ime,Prezime,Jmbg,Email));
			}
			String IDProfesora = rs.getString(1);
			String Ime = rs.getString(2);
			String Prezime = rs.getString(3);
			String Jmbg = rs.getString(4);
			String Email = rs.getString(5);
			s.add(new Profesor(IDProfesora,Ime,Prezime,Jmbg,Email));
			return s;
			
		} catch (Exception e) {
		}
		return null;
	}
	
	
	public List<Predmet> predmet()
	{
		sql = "select predmet.SifraPredmeta,predmet.NazivPredmeta,profesor.Ime,Profesor.Prezime , predmet.TipPredmeta,predmet.ESPB,predmet.Semestar, predmet.IDProfesora"
				+ " from predmet join profesor on predmet.IDProfesora = profesor.IDProfesora";
		
		List<Predmet> s = new ArrayList<Predmet>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			while(!rs.isLast())
			{
				String SifraPredmeta = rs.getString(1);
				String NazivPredmeta = rs.getString(2);
				String ImeP = rs.getString(3);
				String PrezimeP = rs.getString(4);
				String TipPredmeta = rs.getString(5);
				int ESPB = rs.getInt(6);
				int Semestar = rs.getInt(7);
				String id = rs.getString(8);
				
				rs.next();
				s.add(new Predmet(SifraPredmeta,NazivPredmeta,ImeP,PrezimeP,TipPredmeta,ESPB,Semestar,id));
				
			}

			String SifraPredmeta = rs.getString(1);
			String NazivPredmeta = rs.getString(2);
			String ImeP = rs.getString(3);
			String prezimeP = rs.getString(4);
			String TipPredmeta = rs.getString(5);
			int ESPB = rs.getInt(6);
			int Semestar = rs.getInt(7);
			String id = rs.getString(8);
			s.add(new Predmet(SifraPredmeta,NazivPredmeta,ImeP,prezimeP,TipPredmeta,ESPB,Semestar,id));
			return s;
			
		} catch (Exception e) {
		}
		return null;
	}	
	
	public List<Predmet> dajPredmeteKojePohadjam(String index)
	{
		sql = 	"select pr.SifraPredmeta, pr.NazivPredmeta, p.Ime,p.Prezime , pr.TipPredmeta, pr.ESPB, pr.Semestar, pr.IDProfesora from predmet pr left join pohadjam po on po.SifraPredmeta = pr.SifraPredmeta join profesor p on pr.IDProfesora = p.IDProfesora where pr.SifraPredmeta not in (select SifraPredmeta from pohadjam where Indeks = '" + index + "')";
						
		sql1 = "select UpisanSemestar from student where indeks = '"+ index+ "'";
		
		int studentSemestar=0;
		
		try {
			ResultSet rs1 = stmt.executeQuery(sql1);
			if(!rs1.first()) return null;
			else{
				studentSemestar = rs1.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		List<Predmet> s = new ArrayList<Predmet>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			while(!rs.isLast())
			{
				String SifraPredmeta = rs.getString(1);
				String NazivPredmeta = rs.getString(2);
				String ImeP = rs.getString(3);
				String PrezimeP = rs.getString(4);
				String TipPredmeta = rs.getString(5);
				int ESPB = rs.getInt(6);
				int Semestar = rs.getInt(7);
				String id = rs.getString(8);
				
				if(studentSemestar >= Semestar)
					s.add(new Predmet(SifraPredmeta,NazivPredmeta,ImeP,PrezimeP,TipPredmeta,ESPB,Semestar,id));

				rs.next();
				
			}
			
			String SifraPredmeta = rs.getString(1);
			String NazivPredmeta = rs.getString(2);
			String ImeP = rs.getString(3);
			String PrezimeP = rs.getString(4);
			String TipPredmeta = rs.getString(5);
			int ESPB = rs.getInt(6);
			int Semestar = rs.getInt(7);
			String id = rs.getString(8);
			
			
			if(studentSemestar >= Semestar)
				s.add(new Predmet(SifraPredmeta,NazivPredmeta,ImeP,PrezimeP,TipPredmeta,ESPB,Semestar,id));
			
			return s;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
	
	public List<Ispit> dajIspite(String index)
	{
		sql = "select * from ispit join predmet p on p.SifraPredmeta = ispit.SifraPredmeta where ispit.indeks = '" + index + "'";
		
		List<Ispit> s = new ArrayList<Ispit>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			while(!rs.isLast())
			{
				String SifraPredmeta = rs.getString(1);
				String IspitniRok = rs.getString(2);
				String DatumPolaganja = rs.getString(3);
				int ocena = rs.getInt(4);
				String idIspitivaca = rs.getString(5);
				int skolskaGodina = rs.getInt(6);
				String nazivPredmeta = rs.getString(9);
				
				
				rs.next();
				s.add(new Ispit(SifraPredmeta,IspitniRok,DatumPolaganja,ocena,idIspitivaca,skolskaGodina,index,nazivPredmeta));
				
			}

			String SifraPredmeta = rs.getString(1);
			String IspitniRok = rs.getString(2);
			String DatumPolaganja = rs.getString(3);
			int ocena = rs.getInt(4);
			String idIspitivaca = rs.getString(5);
			int skolskaGodina = rs.getInt(6);
			String nazivPredmeta = rs.getString(9);

			s.add(new Ispit(SifraPredmeta,IspitniRok,DatumPolaganja,ocena,idIspitivaca,skolskaGodina,index,nazivPredmeta));

			return s;
			
		} catch (Exception e) {
		}
		return null;
	}	
	
	
	public List<Ispit> dajPolozeneIspite(String index)
	{
		sql = "select * from polozeni join predmet p on p.SifraPredmeta = polozeni.SifraPredmeta where polozeni.indeks = '" + index + "' and polozeni.ocena>5" ;
		
		List<Ispit> s = new ArrayList<Ispit>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			while(!rs.isLast())
			{
				String SifraPredmeta = rs.getString(1);
				String IspitniRok = rs.getString(2);
				String DatumPolaganja = rs.getString(3);
				int ocena = rs.getInt(4);
				String idIspitivaca = rs.getString(5);
				int skolskaGodina = rs.getInt(6);
				String nazivPredmeta = rs.getString(9);
				
				
				rs.next();
				s.add(new Ispit(SifraPredmeta,IspitniRok,DatumPolaganja,ocena,idIspitivaca,skolskaGodina,index,nazivPredmeta));
				
			}

			String SifraPredmeta = rs.getString(1);
			String IspitniRok = rs.getString(2);
			String DatumPolaganja = rs.getString(3);
			int ocena = rs.getInt(4);
			String idIspitivaca = rs.getString(5);
			int skolskaGodina = rs.getInt(6);
			String nazivPredmeta = rs.getString(9);

			s.add(new Ispit(SifraPredmeta,IspitniRok,DatumPolaganja,ocena,idIspitivaca,skolskaGodina,index,nazivPredmeta));

			return s;
			
		} catch (Exception e) {
		}
		return null;
	}	
	
	public List<Predmet> dajPredmeteKojeSlusam(String index)
	{
		sql = 	"SELECT pr.SifraPredmeta,pr.NazivPredmeta,p.Ime,p.Prezime , pr.TipPredmeta,pr.ESPB,pr.Semestar, pr.IDProfesora " + 
				"FROM pohadjam po JOIN predmet pr ON po.SifraPredmeta = pr.SifraPredmeta JOIN profesor p ON pr.IDProfesora = p.IDProfesora and po.Indeks = '"+ index+"' " + 
				"where not exists (select * from polozeni pp where  pr.SifraPredmeta = pp.SifraPredmeta and pp.indeks = '"+index+"')";
		List<Predmet> s = new ArrayList<Predmet>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			while(!rs.isLast())
			{
				String SifraPredmeta = rs.getString(1);
				String NazivPredmeta = rs.getString(2);
				String ImeP = rs.getString(3);
				String PrezimeP = rs.getString(4);
				String TipPredmeta = rs.getString(5);
				int ESPB = rs.getInt(6);
				int Semestar = rs.getInt(7);
				String id = rs.getString(8);
				
				rs.next();
				s.add(new Predmet(SifraPredmeta,NazivPredmeta,ImeP,PrezimeP,TipPredmeta,ESPB,Semestar,id));
				
			}

			String SifraPredmeta = rs.getString(1);
			String NazivPredmeta = rs.getString(2);
			String ImeP = rs.getString(3);
			String prezimeP = rs.getString(4);
			String TipPredmeta = rs.getString(5);
			int ESPB = rs.getInt(6);
			int Semestar = rs.getInt(7);
			String id = rs.getString(8);
			s.add(new Predmet(SifraPredmeta,NazivPredmeta,ImeP,prezimeP,TipPredmeta,ESPB,Semestar,id));
			return s;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	public List<Predmet> prijaviIspite(String index)
	{ 
		
		sql = 	"SELECT op.SifraPredmeta,p1.NazivPredmeta,p2.Ime,p2.Prezime,p1.TipPredmeta,p1.ESPB,p1.Semestar,p1.IDProfesora,op.IspitniRok,op.DatumPolaganja,op.skolskaGodina,op.datumZatvaranjaPrijave "+
				"FROM otvoreneprijave op JOIN pohadjam p on op.SifraPredmeta = p.SifraPredmeta "+
				"JOIN predmet p1 ON p.SifraPredmeta = p1.SifraPredmeta "+
				"JOIN profesor p2 ON p1.IDProfesora = p2.IDProfesora "+
				"WHERE CURRENT_DATE >= op.datumOtvaranjaPrijave AND CURRENT_DATE < op.datumZatvaranjaPrijave "+
				"AND p.Indeks = '" + index + "' "+
				"AND p.SifraPredmeta NOT IN ( SELECT SifraPredmeta FROM polozeni WHERE polozeni.indeks = '" + index +"') "+
				"AND op.SifraPredmeta NOT IN (SELECT op1.SifraPredmeta "+
				"            FROM ispit i JOIN otvoreneprijave op1 ON i.SifraPredmeta = op1.SifraPredmeta AND i.IspitniRok = op1.IspitniRok AND i.skolskaGodina = op1.skolskaGodina "+
				"            WHERE i.indeks = '"+ index +"')  ";
		
		List<Predmet> s = new ArrayList<Predmet>();
		try {
			ResultSet rs = stmt.executeQuery(sql);

			if(!rs.first()) return null;
			while(!rs.isLast())
			{
				String SifraPredmeta = rs.getString(1);
				String NazivPredmeta = rs.getString(2);
				String ImeP = rs.getString(3);
				String PrezimeP = rs.getString(4);
				String TipPredmeta = rs.getString(5);
				int ESPB = rs.getInt(6);
				int Semestar = rs.getInt(7);
				String id = rs.getString(8);
				String ispitniRok = rs.getString(9);
				String datumPolaganja = rs.getString(10);
				String skolskaGodina = rs.getString(11);
				String datumZatvaranjaPrijave = rs.getString(12);
				
				rs.next();
				s.add(new Predmet(SifraPredmeta,NazivPredmeta,ImeP,PrezimeP,TipPredmeta,ESPB,Semestar,id,ispitniRok,datumPolaganja,skolskaGodina,datumZatvaranjaPrijave));
				
			}

			String SifraPredmeta = rs.getString(1);
			String NazivPredmeta = rs.getString(2);
			String ImeP = rs.getString(3);
			String prezimeP = rs.getString(4);
			String TipPredmeta = rs.getString(5);
			int ESPB = rs.getInt(6);
			int Semestar = rs.getInt(7);
			String id = rs.getString(8);
			String ispitniRok = rs.getString(9);
			String datumPolaganja = rs.getString(10);
			String skolskaGodina = rs.getString(11);
			String datumZatvaranjaPrijave = rs.getString(12);
			s.add(new Predmet(SifraPredmeta,NazivPredmeta,ImeP,prezimeP,TipPredmeta,ESPB,Semestar,id,ispitniRok,datumPolaganja,skolskaGodina,datumZatvaranjaPrijave));
			
			
			return s;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	public List<Ispit> ispit()
	{
	
		sql = "select student.Indeks,student.Ime,student.Prezime,po.SifraPredmeta,p1.NazivPredmeta,po.IspitniRok,po.DatumPolaganja,po.Ocena, " + 
				"concat(p.Ime,' ',p.Prezime) as ImeProfesora, po.skolskaGodina " + 
				"from polozeni po join profesor p on po.IDIspitivaca = p.IDProfesora join student on po.indeks = student.Indeks join predmet p1 on p1.SifraPredmeta = po.SifraPredmeta";
		
		List<Ispit> s = new ArrayList<Ispit>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			while(!rs.isLast())
			{
				String Indeks = rs.getString(1);
				String Ime = rs.getString(2);
				String Prezime = rs.getString(3);
				String SifraPredmeta = rs.getString(4);
				String naziv = rs.getString(5);
				String IspitniRok = rs.getString(6);
				String DatumPolaganja = rs.getString(7);
				int Ocena = rs.getInt(8);
				String IDIspitivaca = rs.getString(9);
				int SkolskaGodina = rs.getInt(10);
				
				rs.next();
				s.add(new Ispit(Ime,Prezime,SifraPredmeta,IspitniRok,DatumPolaganja,Ocena,IDIspitivaca,SkolskaGodina,Indeks,naziv));
				
			}
			
			String Indeks = rs.getString(1);
			String Ime = rs.getString(2);
			String Prezime = rs.getString(3);
			String SifraPredmeta = rs.getString(4);
			String naziv = rs.getString(5);
			String IspitniRok = rs.getString(6);
			String DatumPolaganja = rs.getString(7);
			int Ocena = rs.getInt(8);
			String IDIspitivaca = rs.getString(9);
			int SkolskaGodina = rs.getInt(10);
			
			s.add(new Ispit(Ime,Prezime,SifraPredmeta,IspitniRok,DatumPolaganja,Ocena,IDIspitivaca,SkolskaGodina,Indeks,naziv));

			return s;
			
		} catch (Exception e) {
		}
		return null;
	}	
	
	public Profesor dajProfesora(String idp)
	{
		sql = "select * from profesor where IDProfesora = '" + idp + "'";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			else
			{
				String IDP = rs.getString(1);
				String ime = rs.getString(2);
				String prezime = rs.getString(3);
				String jmbg = rs.getString(4);
				String email = rs.getString(5);
				
				Profesor p = new Profesor(IDP,ime,prezime,jmbg,email);
				
				return p;
			}
			
			
		} catch (Exception e) {
		}
		return null;
	}
		
	public List<Predmet> profesorDajPredmet(String id)
	{
		sql = "select * from predmet p1 join profesor p2 on p2.IDProfesora = p1.IDProfesora where p2.IDProfesora =  '"+id+"'";

		
		List<Predmet> s = new ArrayList<Predmet>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			while(!rs.isLast())
			{
				String sifraPredmeta = rs.getString(1);
				String nazivPredmeta = rs.getString(2);
				String tipPredmeta = rs.getString(4);
				int ESPB = rs.getInt(5);
				int semestar = rs.getInt(6);
				String imeP = rs.getString(8);
				String prezP = rs.getString(9);
				
				s.add( new Predmet(sifraPredmeta,nazivPredmeta,imeP,prezP,tipPredmeta,ESPB,semestar,id));
				rs.next();
				
				
			}
			
			String sifraPredmeta = rs.getString(1);
			String nazivPredmeta = rs.getString(2);
			String tipPredmeta = rs.getString(4);
			int ESPB = rs.getInt(5);
			int semestar = rs.getInt(6);
			String imeP = rs.getString(8);
			String prezP = rs.getString(9);
			
			s.add( new Predmet(sifraPredmeta,nazivPredmeta,imeP,prezP,tipPredmeta,ESPB,semestar,id));

			return s;
			
		} catch (Exception e) {
		}
		
		return null;
		
		
	}
	
	public List<Ispit> profesorDajPrijave(String id)
	{
		
		sql ="SELECT s.ime,s.Prezime,i.SifraPredmeta,i.ispitniRok,i.DatumPolaganja,i.Ocena , i.IDIspitivaca,i.skolskaGodina , p.NazivPredmeta,s.indeks " + 
				"FROM ispit i join predmet p ON p.SifraPredmeta = i.SifraPredmeta join student s on s.Indeks = i.indeks " + 
				"where i.IDIspitivaca= '"+id+"' and i.Ocena = 0";
		
		List<Ispit> s = new ArrayList<Ispit>();
		
		ResultSet rs;
		try {
			rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			else {
				while(!rs.isLast()) {
					
					String ime = rs.getString(1);
					String prezime = rs.getString(2);
					String sifraPredmeta = rs.getString(3);
					String ispitniRok = rs.getString(4);
					String datumPolaganja = rs.getString(5);
					int ocena = rs.getInt(6);
					String idIspitivaca = rs.getString(7);
					int skolskaGodina = rs.getInt(8);
					String naziv = rs.getString(9);
					String indeks = rs.getString(10);
					
					System.out.println("proslo");
					s.add(new Ispit(ime,prezime,sifraPredmeta,ispitniRok,datumPolaganja,ocena,idIspitivaca,skolskaGodina,indeks,naziv));
					rs.next();
				}
				
				String ime = rs.getString(1);
				String prezime = rs.getString(2);
				String sifraPredmeta = rs.getString(3);
				String ispitniRok = rs.getString(4);
				String datumPolaganja = rs.getString(5);
				int ocena = rs.getInt(6);
				String idIspitivaca = rs.getString(7);
				int skolskaGodina = rs.getInt(8);
				String naziv = rs.getString(9);
				String indeks = rs.getString(10);
				
				s.add(new Ispit(ime,prezime,sifraPredmeta,ispitniRok,datumPolaganja,ocena,idIspitivaca,skolskaGodina,indeks,naziv));
				
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return null;
		
		
	}


	public void UpisiOcenu(String sifraPredmeta, String ispitniRok, String ocena, int skolskaGodina, String indeks) {
		sql ="UPDATE ispit SET Ocena = '"+ocena+"' where SifraPredmeta = '"+sifraPredmeta+"' and IspitniRok = '"+ispitniRok+"' and skolskaGodina = '"+skolskaGodina+"' and indeks = '"+indeks+"'";
		try {
			String datum = null,id = null;

			ResultSet rs = stmt.executeQuery(sql);	
			
			sql1 = "select DatumPolaganja,IDIspitivaca from ispit where SifraPredmeta = '"+sifraPredmeta+"' and IspitniRok = '"+ispitniRok+"' and skolskaGodina = '"+skolskaGodina+"' and indeks = '"+indeks+"'";
			
			rs = stmt.executeQuery(sql1);
			
			if(!rs.first()) return;
			while(!rs.isLast())
			{
				datum = rs.getString(1);
				id = rs.getString(2);
			}
			
			datum = rs.getString(1);
			id = rs.getString(2);
			
			sql2 = "INSERT INTO polozeni (SifraPredmeta, IspitniRok, DatumPolaganja, Ocena, IDIspitivaca, skolskaGodina, indeks) VALUES ('"+sifraPredmeta+"','"+ispitniRok+"','"+datum+"',"+ocena+",'"+id+"',"+skolskaGodina+",'"+indeks+"')";

			rs = stmt.executeQuery(sql2);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
	}


	public List<OtvaranjePrijaveUcitavanje> ProfesorOtvaranjePrijave(String id) {
		
		String sql = 	"SELECT p.SifraPredmeta,p.NazivPredmeta "+
						"FROM predmet p "+
						"WHERE p.SifraPredmeta NOT IN ( 	SELECT p1.SifraPredmeta " +
				        "                       			FROM predmet p1 JOIN otvoreneprijave op ON p1.SifraPredmeta = op.SifraPredmeta "+
				        "                       			WHERE CURRENT_DATE >= op.datumOtvaranjaPrijave "+
				        "                       			AND CURRENT_DATE < op.datumZatvaranjaPrijave) "+
						"AND p.IDProfesora = '" + id + "'";
		
		List<OtvaranjePrijaveUcitavanje> op = new ArrayList<OtvaranjePrijaveUcitavanje>();
		
		try {
			ResultSet rs = stmt.executeQuery(sql);
			
			if(!rs.first()) return null;
			while(!rs.isLast())
			{
				String SifraPredmeta = rs.getString(1);
				String NazivPredmeta = rs.getString(2);
				rs.next();
				op.add(new OtvaranjePrijaveUcitavanje(NazivPredmeta,SifraPredmeta));
				
			}
			String sifra = rs.getString(1);
			String naziv = rs.getString(2);
			op.add(new OtvaranjePrijaveUcitavanje(naziv,sifra));
			
			return op;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	
	}
	
	public List<Integer> ProfesorDajGodine(String id)
	{
		sql="SELECT DISTINCT skolskaGodina FROM ispit where IDIspitivaca = '"+id+"' ";
		
		try {
			List<Integer> s = new ArrayList<Integer>();
			
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			else{
				do {
					System.out.println(rs.getInt(1));
					s.add(rs.getInt(1));
					rs.next();
				}while(rs.isLast());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	

	public List<OtvaranjePrijave> PrikaziOtvorenePrijave(String id)
	{
		sql="select op.SifraPredmeta, op.IspitniRok, op.DatumPolaganja,op.skolskaGodina,op.datumOtvaranjaPrijave,op.datumZatvaranjaPrijave,pr.NazivPredmeta "
				+"from otvoreneprijave op join predmet pr on pr.SifraPredmeta = op.SifraPredmeta join profesor p on p.IDProfesora = pr.IDProfesora " + 
				"where p.IDProfesora = '"+id+"' ";
		
		try {
			List<OtvaranjePrijave> s = new ArrayList<OtvaranjePrijave>();
			
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			else{
				while(!rs.isLast())
				{
					String sifraPredmeta = rs.getString(1);
					String ispitniRok = rs.getString(2);
					String datumPolaganja = rs.getString(3);
					int skolskaGodina = rs.getInt(4);
					String datumOtvaranja = rs.getString(5);
					String datumZatvaranja = rs.getString(6);
					String nazivPredmeta =rs.getString(7);
					
					OtvaranjePrijave op = new OtvaranjePrijave(sifraPredmeta,ispitniRok,datumPolaganja,skolskaGodina,datumOtvaranja,datumZatvaranja,nazivPredmeta);
					
					System.out.println(sifraPredmeta+" "+ispitniRok+" "+datumPolaganja+" "+skolskaGodina+" "+datumOtvaranja+" "+datumZatvaranja+" "+nazivPredmeta);
					
					s.add(op);
					rs.next();
				}
				String sifraPredmeta = rs.getString(1);
				String ispitniRok = rs.getString(2);
				String datumPolaganja = rs.getString(3);
				int skolskaGodina = rs.getInt(4);
				String datumOtvaranja = rs.getString(5);
				String datumZatvaranja = rs.getString(6);
				String nazivPredmeta =rs.getString(7);
				
				OtvaranjePrijave op = new OtvaranjePrijave(sifraPredmeta,ispitniRok,datumPolaganja,skolskaGodina,datumOtvaranja,datumZatvaranja,nazivPredmeta);
				
				s.add(op);
				
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	public List<Ispit> dajGodineZaPrijave(String id)
	{
		String sql = 	"SELECT DISTINCT skolskaGodina "+
						"FROM ispit "+
						"WHERE IDIspitivaca = '" + id + "'";
		
		List<Ispit> godine = new ArrayList<Ispit>();
		
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			else{
				while(!rs.isLast())
				{
					Ispit godina = new Ispit(rs.getInt(1));
					godine.add(godina);
					System.out.println(godina + " unutra");
					rs.next();
				}
				Ispit godina = new Ispit(rs.getInt(1));
				godine.add(godina);
			
			return godine;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public List<Predmet> dajPredmete(String id)
	{
		String sql = 	"SELECT NazivPredmeta "+
						"FROM predmet "+
						"WHERE IDProfesora = '" + id + "'";
		
		List<Predmet> predmeti = new ArrayList<Predmet>();
		
		try {
			ResultSet rs = stmt.executeQuery(sql);
			if(!rs.first()) return null;
			else{
				while(!rs.isLast())
				{
					Predmet predmet = new Predmet(rs.getString(1));
					predmeti.add(predmet);
					rs.next();
				}
				Predmet predmet = new Predmet(rs.getString(1));
				predmeti.add(predmet);
			
			return predmeti;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
