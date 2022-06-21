package com.example.Studentska.sluzba;


public class Predmet {
	
	private String SifraPredmeta;
	private String NazivPredmeta;
	private String imeP;
	private String prezimeP;
	private String TipPredmeta;
	private int ESPB;
	private int Semestar;
	private String SifraSmera;
	private String id;
	
	//ovo nam treba za prijavu da ne bi olaksali
	private String ispitniRok;
	private String datumPolaganja;
	private String skolskaGodina;
	private String datumZatvaranjaPrijave;
	
	public Predmet(String SifraPredmeta,String NazivPredmeta,String ImeP,String PrezimeP,String TipPredmeta,int ESPB,int Semestar, String id)
	{
		this.SifraPredmeta = SifraPredmeta;
		this.NazivPredmeta = NazivPredmeta;
		this.imeP = ImeP;
		this.prezimeP = PrezimeP;
		this.TipPredmeta = TipPredmeta;
		this.ESPB = ESPB;
		this.Semestar = Semestar;
		this.setId(id);
	}

	//konstuktor koji se korisi u prijavi ispita da bi olaksali
	public Predmet(String SifraPredmeta,String NazivPredmeta,String ImeP,String PrezimeP,String TipPredmeta,int ESPB,int Semestar, String id,String ispitniRok,String datumPolaganja,String skolskaGodina,String datumZatvaranjaPrijave)
	{
		this.SifraPredmeta = SifraPredmeta;
		this.NazivPredmeta = NazivPredmeta;
		this.imeP = ImeP;
		this.prezimeP = PrezimeP;
		this.TipPredmeta = TipPredmeta;
		this.ESPB = ESPB;
		this.Semestar = Semestar;
		this.setId(id);
		this.ispitniRok = ispitniRok;
		this.datumPolaganja = datumPolaganja;
		this.skolskaGodina = skolskaGodina;
		this.datumZatvaranjaPrijave = datumZatvaranjaPrijave;
	}
	
	public Predmet(String NazivPredmeta)
	{
		this.NazivPredmeta = NazivPredmeta;
	}
	
	public String getSifraPredmeta() {
		return SifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		SifraPredmeta = sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return NazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		NazivPredmeta = nazivPredmeta;
	}

	public String getImeP() {
		return imeP;
	}

	public void setImeP(String imeP) {
		this.imeP = imeP;
	}

	public String getPrezimeP() {
		return prezimeP;
	}

	public void setPrezimeP(String prezimeP) {
		this.prezimeP = prezimeP;
	}

	public String getTipPredmeta() {
		return TipPredmeta;
	}

	public void setTipPredmeta(String tipPredmeta) {
		TipPredmeta = tipPredmeta;
	}

	public int getESPB() {
		return ESPB;
	}

	public void setESPB(int eSPB) {
		ESPB = eSPB;
	}

	public int getSemestar() {
		return Semestar;
	}

	public void setSemestar(int semestar) {
		Semestar = semestar;
	}

	public String getSifraSmera() {
		return SifraSmera;
	}

	public void setSifraSmera(String sifraSmera) {
		SifraSmera = sifraSmera;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIspitniRok() {
		return ispitniRok;
	}

	public void setIspitniRok(String ispitniRok) {
		this.ispitniRok = ispitniRok;
	}

	public String getDatumPolaganja() {
		return datumPolaganja;
	}

	public void setDatumPolaganja(String datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}

	public String getSkolskaGodina() {
		return skolskaGodina;
	}

	public void setSkolskaGodina(String skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}

	public String getDatumZatvaranjaPrijave() {
		return datumZatvaranjaPrijave;
	}

	public void setDatumZatvaranjaPrijave(String datumZatvaranjaPrijave) {
		this.datumZatvaranjaPrijave = datumZatvaranjaPrijave;
	}
	
	
	
	
}
