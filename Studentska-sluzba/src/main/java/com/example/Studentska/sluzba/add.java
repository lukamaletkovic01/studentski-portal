package com.example.Studentska.sluzba;

import java.sql.*;
public class add {
	
	public void dodajStudenta(Student student,Connection conn) throws SQLException
	{

		String sql = "INSERT INTO student (Ime, ImeOca, Prezime, Studije, NazivSmera, Status, UpisanSemestar, Jmbg, Email, Indeks)"
				   + " VALUES (?,?,?,?,?,?,?,?,?,?) ";
        
		   try (
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, student.getIme());
	            pstmt.setString(2, student.getImeOca());
	            pstmt.setString(3, student.getPrezime());
	            pstmt.setString(4, student.getStudije());
	            pstmt.setString(5, student.getNazivSmera());
	            pstmt.setString(6, student.getStatus());
	            pstmt.setString(7, student.getUpisanSemestar());
	            pstmt.setString(8, student.getJmbg());
	            pstmt.setString(9, student.getEmail());
	            pstmt.setString(10, student.getIndeks());
	            
	            
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	
	public void dodajProfesora(Profesor profesor,Connection conn) throws SQLException
	{

		String sql = "INSERT INTO profesor (IDProfesora, Ime, Prezime, Jmbg, Email)"
				   + " VALUES (?,?,?,?,?) ";
        
		   try (
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, profesor.getIDProfesora());
	            pstmt.setString(2, profesor.getIme());
	            pstmt.setString(3, profesor.getPrezime());
	            pstmt.setString(4, profesor.getJmbg());
	            pstmt.setString(5, profesor.getEmail());
	            
	            
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	
	public void dodajPredmet(Predmet predmet,Connection conn) throws SQLException
	{

		String sql = "INSERT INTO predmet (SifraPredmeta, NazivPredmeta, IDProfesora, TipPredmeta, ESPB,Semestar)"
				   + " VALUES (?,?,?,?,?,?) ";
        
		   try (
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, predmet.getSifraPredmeta());
	            pstmt.setString(2, predmet.getNazivPredmeta());
	            pstmt.setString(3, predmet.getId());
	            pstmt.setString(4, predmet.getTipPredmeta());
	            pstmt.setInt(5,predmet.getESPB());
	            pstmt.setInt(6, predmet.getSemestar());
	            
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("asdasdasd" + e.getMessage());
	        }
	}
	
	public void dodajIspit(Ispit ispit,Connection conn) throws SQLException
	{

		String sql = "INSERT INTO ispit (SifraPredmeta, IspitniRok, DatumPolaganja, Ocena,IDIspitivaca,SkolskaGodina,Indeks)"
				   + " VALUES (?,?,?,?,?,?,?) ";
        
		   try (
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, ispit.getSifraPredmeta());
	            pstmt.setString(2, ispit.getIspitniRok());
	            pstmt.setString(3, ispit.getDatumPolaganja());
	            pstmt.setInt(4, ispit.getOcena());
	            pstmt.setString(5, ispit.getIDIspitivaca());
	            pstmt.setInt(6, ispit.getSkolskaGodina());
	            pstmt.setString(7, ispit.getIndeks());
	            
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	
	public void dodajPolozeniIspit(Connection conn) throws SQLException
	{

		String sql = "INSERT INTO polozeni "
				+"SELECT * FROM ispit i "
				+"WHERE i.Ocena > 5;";
        
		   try (
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {  
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public void deleteStudent(Student s, Connection conn)
	{
		String sql = "DELETE FROM student WHERE Indeks = "+ s.getIndeks();
        
		   try (
	            PreparedStatement pstmt = conn.prepareStatement(sql)) {
	         	            
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	
	public void dodajPohadjam (Pohadjam p , Connection conn)
	{
		String sql = "INSERT INTO `pohadjam` (`Indeks`, `SifraPredmeta`) VALUES ('"+p.indeks+"','"+p.sifraPredmeta+"')";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ispisiPohadjam (String indeks, String sifraPredmeta , Connection conn)
	{
		String sql = "DELETE FROM pohadjam WHERE Indeks = '" + indeks + "' AND SifraPredmeta = '" + sifraPredmeta + "'";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dodajOtvorenePrijave(OtvaranjePrijave op, Connection conn)
	{
		String sql = "INSERT INTO `otvoreneprijave`(`SifraPredmeta`, `IspitniRok`, `DatumPolaganja`, `skolskaGodina`, `datumOtvaranjaPrijave`, `datumZatvaranjaPrijave`) "
				+ "VALUES ('" + op.getSifraPredmeta() + "','" + op.getIspitniRok() + "','" + op.getDatumPolaganja() + "', " + op.getSkolskaGodina() + ",'" + op.getDatumOtvaranjaPrijave() + "','" + op.getDatumZatvaranjaPrijave() +"')";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void izmeniOtvorenePrijave(OtvaranjePrijave o, Connection conn) {
		
		String sql = "UPDATE otvoreneprijave o SET IspitniRok = '"+o.getIspitniRok()+"', DatumPolaganja = '"+o.getDatumPolaganja()+"',skolskaGodina = "+o.getSkolskaGodina()+",datumOtvaranjaPrijave = '"+o.getDatumOtvaranjaPrijave()+"',datumZatvaranjaPrijave = '"+o.getDatumZatvaranjaPrijave()+"'"
                + " where o.SifraPredmeta = '"+o.getSifraPredmeta()+"' and o.IspitniRok= '"+o.getIspitniRok() + "' and o.skolskaGodina= '"+o.getSkolskaGodina()+"'";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ponistiIspit(String indeks, String sifraPredmeta, String ispitniRok, Connection conn)
	{
		String sql = "DELETE FROM polozeni WHERE SifraPredmeta = '" + sifraPredmeta + 
				"' AND IspitniRok = '" + ispitniRok + "' AND indeks = '" + indeks + "'";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
