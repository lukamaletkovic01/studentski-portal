package com.example.Studentska.sluzba;


public class Student {
	
	private String ime;
	private String imeoca;
	private String prezime;
	private String studije;
	private String nazivsmera;
	private String status;
	private String upisansemestar;
	private String jmbg;
	private String email;
	private String indeks;
	private double prosek;
	private int espb;
	
	
	public Student(String ime,String imeOca,String Prezime,String Studije,String nazivSmera,String Status,String UpisanSemestar,String Jmbg,String Email,String Indeks)
	{
		this.ime = ime;
		this.imeoca = imeOca;
		this.prezime = Prezime;
		this.studije = Studije;
		this.nazivsmera = nazivSmera;
		this.status = Status;
		this.upisansemestar = UpisanSemestar;
		this.jmbg = Jmbg;
		this.email = Email;
		this.indeks = Indeks;
	}

	public void setEspb(int espb)
	{
		this.espb = espb;
	}
	
	public int getEspb()
	{
		return espb;
	}
	
	public void setProsek(double prosek)
	{
		this.prosek = prosek;
	}
	
	public double getProsek()
	{
		return prosek;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getImeOca() {
		return imeoca;
	}

	public void setImeOca(String imeOca) {
		this.imeoca = imeOca;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getStudije() {
		return studije;
	}

	public void setStudije(String studije) {
		this.studije = studije;
	}

	public String getNazivSmera() {
		return nazivsmera;
	}

	public void setNazivSmera(String nazivSmera) {
		this.nazivsmera = nazivSmera;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpisanSemestar() {
		return upisansemestar;
	}

	public void setUpisanSemestar(String upisanSemestar) {
		upisansemestar = upisanSemestar;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}
	
	
}
