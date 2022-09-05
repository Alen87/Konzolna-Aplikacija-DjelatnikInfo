package alen.util;

import java.util.List;

import alen.model.Djelatnik;
import alen.model.SanitarnaIskaznica;


public class SanitarnaIskaznicaCRUD {

	public static SanitarnaIskaznica unosNove(List<Djelatnik> djelatnici) {

		SanitarnaIskaznica si = new SanitarnaIskaznica();
		si.setSifra(Pomocno.ucitajInt("Unesite sifru smjera(pozitivni broj)", true));
		si.setBrojIskaznice(Pomocno.ucitajString("Unesi  broj iskaznice "));
		si.setDatumObavljenogPregleda(Pomocno.ucitajDatum("Datum  obavljenog  pregleda :"));
		si.setVrijediDo(Pomocno.ucitajDatum("Vrijedi  do :"));
		si.setCijenaKn(Pomocno.unesiBigDecimal("Cijena  pregleda :"));
		System.out.println(" Popis djelatnika :");
		DjelatnikCRUD.ispis(djelatnici);
		si.setDjelatnik(djelatnici.get(Pomocno.ucitajInt("Odaberi djelatnika ", 1, djelatnici.size()) - 1));

		return si;

	}

	public static void ispis(List<SanitarnaIskaznica> sanitarnaIskaznica) {
		int rb = 1;
		System.out.println("");
		System.out.println("Sanitarne iskaznice  u  aplikaciji");
		for (SanitarnaIskaznica si : sanitarnaIskaznica) {
			System.out.println(rb++ + ". " + si.getSifra() + " " + si.getBrojIskaznice() + " "
					+ Datum.getSdf().format(si.getDatumObavljenogPregleda()) + " " + Datum.getSdf().format(si.getVrijediDo()) + " " + si.getDjelatnik().getIme() + " "
					+ si.getDjelatnik().getPrezime());

		}

		System.out.println("------------------------------------");

	}

	public static void promjena(SanitarnaIskaznica si, List<Djelatnik> djelatnici) {
		si.setSifra(Pomocno.ucitajInt("sifra (" + si.getSifra() + ")", true));
		si.setBrojIskaznice(Pomocno.ucitajString("broj iskaznice (" + si.getBrojIskaznice() + " ) "));
		si.setDatumObavljenogPregleda(
				Pomocno.ucitajDatum("datum pregleda (" + Datum.getSdf().format(si.getDatumObavljenogPregleda()) + " ) "));
		si.setVrijediDo(Pomocno.ucitajDatum("vrijedi do ( " + si.getBrojIskaznice() + " ) "));
		si.setCijenaKn(Pomocno.unesiBigDecimal("cijena (" + si.getCijenaKn() + " ) "));
		si.setDjelatnik(djelatnici.get(Pomocno.ucitajInt("Odaberi djelatnika :", 1, djelatnici.size()) - 1));

	}

}
