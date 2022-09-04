package alen.util;

import java.util.List;

import alen.model.Djelatnik;
import alen.model.DjelatnikEdukacija;
import alen.model.Edukacija;

public class EdukacijaCRUD {

	public static Edukacija unosNove(List<Djelatnik> djelatnici, List<DjelatnikEdukacija> djelatniciNaEdukacijama) {
		Edukacija e = new Edukacija();
		e.setSifra(Pomocno.ucitajInt("Unestite sifru smjera(pozitivan  broj)", true));
		e.setNaziv(Pomocno.ucitajString("Unesi naziv edukacije"));
		e.setDatum(Pomocno.ucitajDatum("Unesi datum  odrzavanja  edukacije"));
		e.setVoditeljEdukacije(Pomocno.ucitajString("Ime voditelja  edukacije "));
		e.setTrajanjeEdukacijeMin(Pomocno.unesiBigDecimal("Vrijeme trajanja  edukacije"));
		dodajDjelatnikeNaEdukacije(e, djelatnici, djelatniciNaEdukacijama);
		return e;
	}

	private static void dodajDjelatnikeNaEdukacije(Edukacija e, List<Djelatnik> djelatnici,
			List<DjelatnikEdukacija> djelatniciNaEdukacijama) {
		while (true) {
			if (Pomocno.ucitajInt("1 za dodavanje  djelatnika,0 za NE") == 0) {
				break;

			}

			DjelatnikCRUD.ispis(djelatnici);
			DjelatnikEdukacija dj = new DjelatnikEdukacija();
			dj.setEdukacija(e);
			dj.setDjelatnik(djelatnici.get(Pomocno.ucitajInt("Odaberi djelatnika", 1, djelatnici.size()) - 1));
			dj.setOcijena(Pomocno.unesiBigDecimal("Unesi ocijenu"));
			e.getDjelatniciNaEdukacijama().add(dj);

		}

	}

	public static void ispis(List<Edukacija> edukacije, List<DjelatnikEdukacija> djelatniciNaEdukacijama) {
		int rb = 1;

		System.out.println("");
		System.out.println("Edukacije  u  aplikaciji");
		for (Edukacija e : edukacije) {
			System.out.println(rb++ + ". " + e.getNaziv() + " " + e.getVoditeljEdukacije() + " " + Datum.getSdf().format(e.getDatum())+ "  "
					+ e.getTrajanjeEdukacijeMin());

			for (DjelatnikEdukacija dj : e.getDjelatniciNaEdukacijama()) {
				System.out.println("\t" + dj.getDjelatnik().getIme() + " " + dj.getDjelatnik().getPrezime() + " "
						+ dj.getOcijena());
			}

		}
		System.out.println("----------------");
	}

	public static void promjena(Edukacija e, List<Djelatnik> djelatnici,
			List<DjelatnikEdukacija> djelatniciNaEdukacijama) {
		e.setSifra(Pomocno.ucitajInt("sifra (" + e.getSifra() + ")", true));
		e.setNaziv(Pomocno.ucitajString("Naziv ( " + e.getNaziv() + ")"));
		e.setDatum(Pomocno.ucitajDatum("Datum odrzavanja  edukacije ( " + Datum.getSdf().format(e.getDatum()) + ")"));
		e.setVoditeljEdukacije(Pomocno.ucitajString("Voditelj edukacije ( " + e.getVoditeljEdukacije() + ")"));
		e.setTrajanjeEdukacijeMin(Pomocno.unesiBigDecimal("Unesi vrijeme trajanja  edukacije"));

		while (e.getDjelatniciNaEdukacijama().size() > 0) {
			System.out.println("Brisanje  djelatnika na  edukacijama ");
			int rb = 1;
			for (DjelatnikEdukacija dj : e.getDjelatniciNaEdukacijama()) {
				System.out.println(rb++ + "." + dj.getDjelatnik().getIme() + " " + dj.getDjelatnik().getPrezime() + " "
						+ dj.getOcijena());

			}

			System.out.println("----------------");
			int b = Pomocno.ucitajInt("redni broj za brisanje 0 nemoj brisati", 0,
					e.getDjelatniciNaEdukacijama().size());
			if (b == 0) {
				break;

			} else {
				e.getDjelatniciNaEdukacijama().remove(b - 1);
			}

		}

		dodajDjelatnikeNaEdukacije(e, djelatnici, djelatniciNaEdukacijama);
	}

}
