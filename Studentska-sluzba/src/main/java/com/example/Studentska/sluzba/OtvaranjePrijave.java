package com.example.Studentska.sluzba;

public class OtvaranjePrijave {

	private String SifraPredmeta;
	private String IspitniRok;
	private String DatumPolaganja;
	private int skolskaGodina;
	private String datumOtvaranjaPrijave;
	private String datumZatvaranjaPrijave;
	private String nazivPredmeta;
	
	
	public OtvaranjePrijave(String SifraPredmeta,String IspitniRok,String DatumPolaganja,int skolskaGodina,String datumOtvaranjaPrijave,String datumZatvaranjaPrijave)
	{
		this.SifraPredmeta = SifraPredmeta;
		this.IspitniRok = IspitniRok;
		this.DatumPolaganja = DatumPolaganja;
		this.skolskaGodina = skolskaGodina;
		this.datumOtvaranjaPrijave = datumOtvaranjaPrijave;
		this.datumZatvaranjaPrijave = datumZatvaranjaPrijave;
	}
	
	public OtvaranjePrijave(String SifraPredmeta,String IspitniRok,String DatumPolaganja,int skolskaGodina,String datumOtvaranjaPrijave,String datumZatvaranjaPrijave,String nazivPredmeta)
	{
		this.SifraPredmeta = SifraPredmeta;
		this.IspitniRok = IspitniRok;
		this.DatumPolaganja = DatumPolaganja;
		this.skolskaGodina = skolskaGodina;
		this.datumOtvaranjaPrijave = datumOtvaranjaPrijave;
		this.datumZatvaranjaPrijave = datumZatvaranjaPrijave;
		this.nazivPredmeta= nazivPredmeta;
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
	
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setDatumPolaganja(String datumPolaganja) {
		DatumPolaganja = datumPolaganja;
	}


	public int getSkolskaGodina() {
		return skolskaGodina;
	}


	public void setSkolskaGodina(int skolskaGodina) {
		this.skolskaGodina = skolskaGodina;
	}


	public String getDatumOtvaranjaPrijave() {
		return datumOtvaranjaPrijave;
	}


	public void setDatumOtvaranjaPrijave(String datumOtvaranjaPrijave) {
		this.datumOtvaranjaPrijave = datumOtvaranjaPrijave;
	}


	public String getDatumZatvaranjaPrijave() {
		return datumZatvaranjaPrijave;
	}


	public void setDatumZatvaranjaPrijave(String datumZatvaranjaPrijave) {
		this.datumZatvaranjaPrijave = datumZatvaranjaPrijave;
	}

	
	
	
}