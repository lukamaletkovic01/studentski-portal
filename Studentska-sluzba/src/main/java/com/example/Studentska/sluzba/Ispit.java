package com.example.Studentska.sluzba;


public class Ispit {
	private String SifraPredmeta;
	private String IspitniRok;
	private String DatumPolaganja;
	private int Ocena;
	private String IDIspitivaca;
	private int SkolskaGodina;
	private String Indeks;
	private String ime;
	private String prezime;
	private String naziv;
	
	public Ispit(String ime,String prezime,String sifraPredmeta, String ispitniRok, String datumPolaganja, int ocena, String iDIspitivaca,int skolskaGodina, String indeks,String naziv) {
		SifraPredmeta = sifraPredmeta;
		IspitniRok = ispitniRok;
		DatumPolaganja = datumPolaganja;
		Ocena = ocena;
		IDIspitivaca = iDIspitivaca;
		SkolskaGodina = skolskaGodina;
		Indeks = indeks;
		this.ime = ime;
		this.prezime = prezime;
		this.setNaziv(naziv);
	}

	public Ispit(String SifraPredmeta,String IspitniRok,String DatumPolaganja,int Ocena,String IDIspitivaca,int SkolskaGodina,String index,String naziv)
	{
		this.SifraPredmeta = SifraPredmeta;
		this.IspitniRok = IspitniRok;
		this.DatumPolaganja =DatumPolaganja;
		this.Ocena = Ocena;
		this.IDIspitivaca = IDIspitivaca;
		this.SkolskaGodina = SkolskaGodina;
		this.Indeks = index;
		this.naziv = naziv;
	}

	public Ispit(int skolskaGodina)
	{
		this.SkolskaGodina = skolskaGodina;
	}
	
	
	public String getIme() {
		return ime;
	}



	public void setIme(String ime) {
		this.ime = ime;
	}



	public String getPrezime() {
		return prezime;
	}



	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}



	public String getSifraPredmeta() {
		return SifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		SifraPredmeta = sifraPredmeta;
	}

	public String getIspitniRok() {
		return IspitniRok;
	}

	public void setIspitniRok(String ispitniRok) {
		IspitniRok = ispitniRok;
	}

	public String getDatumPolaganja() {
		return DatumPolaganja;
	}

	public void setDatumPolaganja(String datumPolaganja) {
		DatumPolaganja = datumPolaganja;
	}

	public int getOcena() {
		return Ocena;
	}

	public void setOcena(int ocena) {
		Ocena = ocena;
	}

	public String getIDIspitivaca() {
		return IDIspitivaca;
	}

	public void setIDIspitivaca(String iDIspitivaca) {
		IDIspitivaca = iDIspitivaca;
	}

	public int getSkolskaGodina() {
		return SkolskaGodina;
	}

	public void setSkolskaGodina(int skolskaGodina) {
		SkolskaGodina = skolskaGodina;
	}

	public String getIndeks() {
		return Indeks;
	}

	public void setIndeks(String indeks) {
		Indeks = indeks;
	}



	public String getNaziv() {
		return naziv;
	}



	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
	
	
	
}
