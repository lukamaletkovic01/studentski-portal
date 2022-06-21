package com.example.Studentska.sluzba;


public class Profesor {
	
	private String IDProfesora;
	private String Ime;
	private String Prezime;
	private String Jmbg;
	private String Email;
	
	public Profesor(String IDProfesora,String Ime,String Prezime,String Jmbg,String Email)
	{
		this.IDProfesora = IDProfesora;
		this.Ime = Ime;
		this.Prezime = Prezime;
		this.Jmbg = Jmbg;
		this.Email = Email;
	}

	public String getIDProfesora() {
		return IDProfesora;
	}

	public void setIDProfesora(String iDProfesora) {
		IDProfesora = iDProfesora;
	}

	public String getIme() {
		return Ime;
	}

	public void setIme(String ime) {
		Ime = ime;
	}

	public String getPrezime() {
		return Prezime;
	}

	public void setPrezime(String prezime) {
		Prezime = prezime;
	}

	public String getJmbg() {
		return Jmbg;
	}

	public void setJmbg(String jmbg) {
		Jmbg = jmbg;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
	
}
