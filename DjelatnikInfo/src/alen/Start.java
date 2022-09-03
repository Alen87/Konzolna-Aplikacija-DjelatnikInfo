package alen;

import java.awt.Window.Type;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import alen.model.Djelatnik;
import alen.model.DjelatnikEdukacija;
import alen.model.Edukacija;
import alen.model.Mobitel;
import alen.model.SanitarnaIskaznica;
import alen.util.DjelatnikCRUD;
import alen.util.EdukacijaCRUD;
import alen.util.MobitelCRUD;
import alen.util.Pomocno;
import alen.util.SanitarnaIskaznicaCRUD;

public class Start {
	private List<DjelatnikEdukacija> djelatniciNaEdukacijama;
	private List<Mobitel> mobiteli;
	private List<SanitarnaIskaznica> sanitarnaIskaznica;
	private List<Djelatnik> djelatnici;
	private List<Edukacija> edukacije;

	public Start() {
		mobiteli = new ArrayList();
		sanitarnaIskaznica = new ArrayList();
		djelatnici = new ArrayList();
		edukacije = new ArrayList();
		djelatniciNaEdukacijama = new ArrayList();
		procitajSDiska();
		Pomocno.ulaz = new Scanner(System.in);
		System.out.println("********* Djelatnik info aplikacija V1 *********");
		izbornik();
		Pomocno.ulaz.close();

	}

	private void pokreniProgram() {
		switch (Pomocno.ucitajInt("Odaberi program", 1, 5)) {
		case 1:
			djelatnici();
			break;
		case 2:
			edukacije();
			break;
		case 3:
			mobiteli();
			break;
		case 4:
			sanitarneIskaznice();
			break;
		case 5:
			System.out.println("Doviðenja");

		}

	}

	private void djelatnici() {
		System.out.println("Program djelatnici");
		izbornikProgram();
		pokreniDjelatniciAkcija();

	}

	private void pokreniDjelatniciAkcija() {
		switch (Pomocno.ucitajInt("Odaberi akciju", 1, 5)) {
		case 1:
			djelatnici.add(DjelatnikCRUD.unosNovog());
			djelatnici();
			break;
		case 2:
			DjelatnikCRUD.ispis(djelatnici);
			djelatnici();
			break;
		case 3:
			DjelatnikCRUD.ispis(djelatnici);
			DjelatnikCRUD.promjena(djelatnici.get(Pomocno.ucitajInt("Odaberi djelatnika", 1, djelatnici.size()) - 1));
			djelatnici();
			break;
		case 4:
			DjelatnikCRUD.ispis(djelatnici);
			djelatnici.remove(Pomocno.ucitajInt("Odaberi djelatnika", 1, djelatnici.size()) - 1);
			djelatnici();
			break;
		case 5:
			izbornik();

		}

	}

	private void edukacije() {
		System.out.println("Program edukacije");
		izbornikProgram();
		pokreniEdukacijeAkcija();

	}

	private void pokreniEdukacijeAkcija() {
		switch (Pomocno.ucitajInt("Odaberi akciju", 1, 5)) {
		case 1:
			edukacije.add(EdukacijaCRUD.unosNove(djelatnici, djelatniciNaEdukacijama));
			edukacije();
			break;
		case 2:
			EdukacijaCRUD.ispis(edukacije, djelatniciNaEdukacijama);
			edukacije();
			break;
		case 3:
			EdukacijaCRUD.ispis(edukacije, djelatniciNaEdukacijama);
			EdukacijaCRUD.promjena(edukacije.get(Pomocno.ucitajInt("Odaberi edukaciju", 1, edukacije.size()) - 1),
					djelatnici, djelatniciNaEdukacijama);
			edukacije();
			break;
		case 4:
			EdukacijaCRUD.ispis(edukacije, djelatniciNaEdukacijama);
			edukacije.remove(Pomocno.ucitajInt("Odaberi edukaciju", 1, edukacije.size()) - 1);
			edukacije();
			break;
		case 5:
			izbornik();

		}

	}

	private void mobiteli() {
		System.out.println("Program Mobiteli");
		izbornikProgram();
		pokreniMobitelAkcija();

	}

	private void pokreniMobitelAkcija() {
		switch (Pomocno.ucitajInt("Odaberi akciju", 1, 5)) {

		case 1:
			mobiteli.add(MobitelCRUD.unosNovog(djelatnici));
			mobiteli();
			break;
		case 2:
			MobitelCRUD.ispis(mobiteli);
			mobiteli();
			break;
		case 3:
			MobitelCRUD.ispis(mobiteli);
			MobitelCRUD.promjena(mobiteli.get(Pomocno.ucitajInt("Odaberi mobitel", 1, mobiteli.size()) - 1),
					djelatnici);
			break;
		case 4:
			MobitelCRUD.ispis(mobiteli);
			mobiteli.remove(Pomocno.ucitajInt("Odaberi mobitel", 1, mobiteli.size()) - 1);
			break;
		case 5:
			izbornik();
			break;

		}

	}

	private void sanitarneIskaznice() {
		System.out.println("Program Sanitarne iskaznice");
		izbornikProgram();
		pokreniSanitarnaIskaznicaAkcija();

	}

	private void pokreniSanitarnaIskaznicaAkcija() {
		switch (Pomocno.ucitajInt("Odaberi akciju", 1, 5)) {
		case 1:
			sanitarnaIskaznica.add(SanitarnaIskaznicaCRUD.unosNove(djelatnici));
			sanitarneIskaznice();
			break;
		case 2:
			SanitarnaIskaznicaCRUD.ispis(sanitarnaIskaznica);
			sanitarneIskaznice();
			break;
		case 3:
			SanitarnaIskaznicaCRUD.ispis(sanitarnaIskaznica);
			SanitarnaIskaznicaCRUD.promjena(
					sanitarnaIskaznica
							.get(Pomocno.ucitajInt("Odaberi sanitarnu iskaznicu", 1, sanitarnaIskaznica.size()) - 1),
					djelatnici);
			sanitarneIskaznice();
			break;
		case 4:
			SanitarnaIskaznicaCRUD.ispis(sanitarnaIskaznica);
			sanitarnaIskaznica
					.remove(Pomocno.ucitajInt("Odaberi sanitarnu iskaznicu", 1, sanitarnaIskaznica.size()) - 1);
			break;
		case 5:
			izbornik();
			break;

		}
	}

	private void izbornikProgram() {
		System.out.println("1. Unos");
		System.out.println("2. Pregled");
		System.out.println("3. Promjena");
		System.out.println("4. Brisanje");
		System.out.println("5. povratak na glavni izbornik");
	}

	private void izbornik() {
		System.out.println("");
		System.out.println("Glavni izbornik");
		System.out.println("1. Djelatnici");
		System.out.println("2. Edukacije");
		System.out.println("3. Mobiteli");
		System.out.println("4. Sanitarne iskaznice");
		System.out.println("5. Izlaz");
		System.out.println("");
		pokreniProgram();

	}

	public static void main(String[] args) {
		new Start();
	}
	
	
	private void procitajSDiska() {
		Gson g=new Gson();
		
		Type dataType = (new TypeToken<Spremanje>()
		{
		}).getType();

		try {
			Spremanje s = g.fromJson(Files.readString(Path.of("podaci.json")), dataType);
			this.djelatnici=s.getDjelatnici();
			this.edukacije=s.getEdukacije();
			this.mobiteli=s.getMobiteli();
			this.sanitarnaIskaznica=s.getSaniterneIskaznice();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	private void spremiNaDisk() {
		Spremanje s = new Spremanje();
		s.setDjelatnici(djelatnici);
		s.setEdukacije(edukacije);
		s.setMobiteli(mobiteli);
		s.setSaniterneIskaznice(sanitarnaIskaznica);	
		
		ExclusionStrategy strategija = new ExclusionStrategy(){
            @Override
            public boolean shouldSkipField(FieldAttributes fa) {
                if(fa.getDeclaringClass()==DjelatnikEdukacija.class && fa.getName().equals("edukacija")){
                    return true;
                }
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> type) {
                return false;
            }
            
        };
        
        
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(strategija)
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .create();
		
		try {
			FileWriter fw = new FileWriter("podaci.json");
			fw.write(gson.toJson(s));
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
