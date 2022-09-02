package alen.model;

import java.math.BigDecimal;

public class DjelatnikEdukacija extends Entitet {
	
	private Djelatnik djelatnik;
	private Edukacija edukacija;
	private BigDecimal ocijena;
	
	
	
	
	
	
	public DjelatnikEdukacija() {
		super();
	}
	public DjelatnikEdukacija(Integer sifra, Djelatnik djelatnik, Edukacija edukacija, BigDecimal ocijena) {
		super(sifra);
		this.djelatnik = djelatnik;
		this.edukacija = edukacija;
		this.ocijena = ocijena;
	}
	public Djelatnik getDjelatnik() {
		return djelatnik;
	}
	public void setDjelatnik(Djelatnik djelatnik) {
		this.djelatnik = djelatnik;
	}
	public Edukacija getEdukacija() {
		return edukacija;
	}
	public void setEdukacija(Edukacija edukacija) {
		this.edukacija = edukacija;
	}
	public BigDecimal getOcijena() {
		return ocijena;
	}
	public void setOcijena(BigDecimal ocijena) {
		this.ocijena = ocijena;
	}
	
	
	
	

}
