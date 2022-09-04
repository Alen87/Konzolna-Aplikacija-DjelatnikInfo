package alen.util;


import java.util.List;

import alen.model.Djelatnik;

public class DjelatnikCRUD {
	
	
	public static Djelatnik unosNovog() {

		Djelatnik d = new Djelatnik();
		d.setSifra(Pomocno.ucitajInt("Unestite sifru smjera(pozitivan  broj)", true));
		d.setIme(Pomocno.ucitajString("Unesi  ime  djelatnika"));
		d.setPrezime(Pomocno.ucitajString("Unesi  prezime djelatnika"));
		d.setEmail(Pomocno.ucitajString("Unesi  email  djelatnika"));
		d.setPocetakRada(Pomocno.ucitajDatum("Datum  pocetka radnog  odnosa"));
		d.setLoyalityKartica(Pomocno.ucitajString("Sifra  kartice"));
		d.setRadnaOdjecaObuca(Pomocno.ucitajString("Radna  odjeca i obuca"));
		d.setUgovor(Pomocno.ucitajString("Opis  radnog  mjesta "));
		d.setZavrsenoZanimanje(Pomocno.ucitajString("Zavrseno  zanimanje  djelatnika"));
		System.out.println("");

		return d;

	}

	public static void ispis(List<Djelatnik> djelatnici) {
		int dj = 1;
		System.out.println();
		System.out.println("Djelatnici");
		for (Djelatnik d : djelatnici) {
			System.out.println(dj++ + "." + d.getIme() + " " + d.getPrezime() + " " + Datum.getSdf().format(d.getPocetakRada()));
		}

		System.out.println("---------------------");

	}

	public static void promjena(Djelatnik d) {
		d.setSifra(Pomocno.ucitajInt("sifra (" + d.getSifra() + ")", true));
		d.setIme(Pomocno.ucitajString("Ime ( " + d.getIme() + ")"));
		d.setPrezime(Pomocno.ucitajString("Prezime ( " + d.getPrezime() + ")"));
		d.setEmail(Pomocno.ucitajString("Email adresa ( " + d.getEmail() + ") "));
		d.setLoyalityKartica(Pomocno.ucitajString("Loyality kartica ( " + d.getLoyalityKartica() + ")"));
		d.setRadnaOdjecaObuca(Pomocno.ucitajString("Radna odjeca ( " + d.getRadnaOdjecaObuca() + ")"));
		d.setPocetakRada(Pomocno.ucitajDatum("Pocetak rada ( " + d.getPocetakRada() + ")"));
		d.setUgovor(Pomocno.ucitajString("Ugovor ( " + d.getUgovor() + ")"));
		d.setZavrsenoZanimanje(Pomocno.ucitajString("Zavrseno zanimanje ( " + d.getZavrsenoZanimanje() + ")"));
	}

}
