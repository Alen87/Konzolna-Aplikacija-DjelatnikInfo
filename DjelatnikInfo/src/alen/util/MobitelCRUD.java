package alen.util;

import java.util.List;

import alen.model.Djelatnik;
import alen.model.Mobitel;


public class MobitelCRUD {
	public static Mobitel unosNovog(List<Djelatnik> djelatnici) {

		Mobitel m = new Mobitel();
		m.setSifra(Pomocno.ucitajInt("Unestite sifru smjera(pozitivan  broj)", true));
		m.setNaziv(Pomocno.ucitajString("Naziv mobilnog uredaja"));
		m.setBroj(Pomocno.ucitajString("Kontakt broj "));
		m.setDatumZaprimanja(Pomocno.ucitajDatum("Datum  zaprmanja uredaja:"));
		m.setPravoNaSlijedeci(Pomocno.ucitajDatum("Pravo  na  slijedeci:"));
		m.setSerijskiBroj(Pomocno.ucitajString("Unesite  serijski  broj  uredaja "));
		System.out.println(" Popis djelatnika :");
		DjelatnikCRUD.ispis(djelatnici);
		m.setDjelatnik(djelatnici.get(Pomocno.ucitajInt("Odaberi djelatnika ", 1, djelatnici.size()) - 1));
		return m;
	}

	public static void ispis(List<Mobitel> mobiteli) {
		int rb = 1;
		System.out.println("");
		System.out.println("Mobiteli  u  aplikaciji");
		for (Mobitel m : mobiteli) {
			System.out.println(rb++ + "." + m.getSifra() + " " + m.getNaziv() + " " + m.getBroj() + " "
					+ Datum.getSdf().format(m.getDatumZaprimanja()) + " " + Datum.getSdf().format(m.getPravoNaSlijedeci()) + " " + m.getSerijskiBroj() + " "
					+ m.getDjelatnik().getIme() + " " + m.getDjelatnik().getPrezime());
		}

		System.out.println("------------------------------------");
	}

	public static void promjena(Mobitel m, List<Djelatnik> djelatnici) {
		m.setSifra(Pomocno.ucitajInt("sifra (" + m.getSifra() + ")", true));
		m.setNaziv(Pomocno.ucitajString("Naziv mobilnog uredaja (" + m.getNaziv() + " ) "));
		m.setBroj(Pomocno.ucitajString("Kontakt  broj ( " + m.getBroj() + " ) "));
		m.setDatumZaprimanja(Pomocno.ucitajDatum(" Datum zaprimanja ( " + Datum.getSdf().format(m.getDatumZaprimanja()) + " ) "));
		m.setPravoNaSlijedeci(Pomocno.ucitajDatum(" Pravo na  slijedeci ( " + Datum.getSdf().format(m.getPravoNaSlijedeci())+ " ) "));
		m.setSerijskiBroj(Pomocno.ucitajString("Serijeski broj uredaja (" + m.getSerijskiBroj() + " ) "));
		m.setDjelatnik(djelatnici.get(Pomocno.ucitajInt("Odaberi djelatnika", 1, djelatnici.size()) - 1));
	}

}
