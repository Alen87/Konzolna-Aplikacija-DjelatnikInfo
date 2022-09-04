package alen.util;

import java.math.BigDecimal;


import java.util.Date;

import java.util.Scanner;

public class Pomocno {

	public static Scanner ulaz;
	

	/**
	 * Metoda osigurava unos cjelog broja koji može biti u cijelom rasponu int tip
	 * podatka
	 * 
	 * @param poruka Koja se prikazuje korisniku
	 * @return Uèitani cjeli broj
	 */
	public static int ucitajInt(String poruka) {
		while (true) {
			System.out.print(poruka + ": ");
			try {
				return Integer.parseInt(ulaz.nextLine());
			} catch (Exception e) {
				System.out.println("Niste unijeli cijeli broj");
			}
		}
	}

	public static int ucitajInt(String poruka, boolean pozitivni) {
		int i = ucitajInt(poruka);
		if (!pozitivni) {
			return i;
		}
		while (true) {
			if (i < 0) {
				System.out.println("Uèitani broj mora biti pozitivan");
				i = ucitajInt(poruka);
				continue;
			}
			return i;
		}
	}

	public static int ucitajInt(String poruka, int min, int max) {
		int i = ucitajInt(poruka);
		while (true) {
			if (i >= min && i <= max) {
				return i;
			} else {
				System.out.println("Broj mora biti izmeðu " + min + " " + max);
				i = ucitajInt(poruka);
			}
		}
	}

	public static String ucitajString(String poruka) {
		String s;
		while (true) {
			System.out.print(poruka + ": ");
			s = ulaz.nextLine();
			if (s.trim().isEmpty()) {
				System.out.println("Obavezan unos");
				continue;
			}
			return s;
		}
	}

	/**
	 * https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int slucajniBroj(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	public static String ucitajString(String poruka, boolean prazno) {
		String s;
		while (true) {
			System.out.print(poruka + ": ");
			s = ulaz.nextLine();
			if (!prazno && s.trim().isEmpty()) {
				System.out.println("Obavezan unos");
				continue;
			}
			return s;
		}
	}

	public static BigDecimal unesiBigDecimal(String poruka) {
		BigDecimal i = BigDecimal.ZERO;

		while (true) {
			System.out.print(poruka + " ");

			try {
				i = new BigDecimal(ulaz.nextLine());
			} catch (Exception e) {
				System.out.println("Unos more biti broj");
				continue;
			}
			if (i.compareTo(BigDecimal.ONE) < 0) {
				System.out.println("Broj mora biti pozitivan");
				continue;
			}
			return i;
		}
	}

	public static Date ucitajDatum(String poruka) {

		while (true) {
			System.out.print(poruka);
			try {
				return  Datum.getSdf().parse(ulaz.nextLine());
			} catch (Exception e) {
				System.out.println("Neispravan format datuma. Primjer unosa: " + Datum.getSdf().format(new Date()));
			}
		}
	}

}
