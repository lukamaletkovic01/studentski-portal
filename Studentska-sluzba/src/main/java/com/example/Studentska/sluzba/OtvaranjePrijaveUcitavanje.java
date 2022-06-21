package com.example.Studentska.sluzba;

public class OtvaranjePrijaveUcitavanje {
	public String naziv;
	public String sifra;
	
	public OtvaranjePrijaveUcitavanje (String nazivPredmeta, String SifraPredmeta)
	{
		this.naziv = nazivPredmeta;
		this.sifra = SifraPredmeta;
	}

	public String getNazivPredmeta() {
		return naziv;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.naziv = nazivPredmeta;
	}

	public String getSifraPredmeta() {
		return sifra;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifra = sifraPredmeta;
	}
	
	
}
