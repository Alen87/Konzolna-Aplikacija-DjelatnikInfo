package alen;

import java.util.List;

import alen.model.Djelatnik;
import alen.model.Edukacija;
import alen.model.Mobitel;
import alen.model.SanitarnaIskaznica;

public class Spremanje {

	private List<Djelatnik> djelatnici;
	private List<Edukacija> edukacije;
	private List<Mobitel> mobiteli;
	private List<SanitarnaIskaznica> saniterneIskaznice;

	public List<Djelatnik> getDjelatnici() {
		return djelatnici;
	}

	public void setDjelatnici(List<Djelatnik> djelatnici) {
		this.djelatnici = djelatnici;
	}

	public List<Edukacija> getEdukacije() {
		return edukacije;
	}

	public void setEdukacije(List<Edukacija> edukacije) {
		this.edukacije = edukacije;
	}

	public List<Mobitel> getMobiteli() {
		return mobiteli;
	}

	public void setMobiteli(List<Mobitel> mobiteli) {
		this.mobiteli = mobiteli;
	}

	public List<SanitarnaIskaznica> getSaniterneIskaznice() {
		return saniterneIskaznice;
	}

	public void setSaniterneIskaznice(List<SanitarnaIskaznica> saniterneIskaznice) {
		this.saniterneIskaznice = saniterneIskaznice;
	}

}
