//Baza Pracowników

package MichalSzulierz3A;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuPracownicy extends Pracownik implements Funkcje{
	
	private static final String FILE = "./src/MichalSzulierz3A/Pracownicy.txt";
	private static final Path PATH = Paths.get(FILE);
	
	Scanner read=new Scanner(System.in);
	ArrayList<Pracownik> lista=new ArrayList<>();
	byte[] output = lista.toString().getBytes();
	Pracownik p=new Pracownik();
	
	public void menu() throws IOException {
		System.out.println("Która opcje wybierasz?");
		System.out.println("1.Dodaj Pracownika");
		System.out.println("2.Zamień Pracownika");
		System.out.println("3.Usun Pracownika");
		System.out.println("4.Odczyt z pliku");
		System.out.println("5.Wróć do głównego menu");
		int x=read.nextInt();
		switch(x) {
		case 1:
			dodaj();
		case 2:
			zamien();
		case 3:
			usun();
		case 4:
			odczyt();
		case 5:
			Zoo.menu();
		}
	}
	public void dodaj() throws IOException {
		Pracownik p=new Pracownik();
		System.out.println("Ilu pracownikow chcesz dodac?");
		int x=read.nextInt();
		for(int i=0;i<x;i++) {
			System.out.println("Podaj imie pracownika");
			String name=read.next();
			p.setName(name);
			System.out.println("Podaj nazwisko pracownika");
			String surname=read.next();
			p.setSurname(surname);
			System.out.println("Podaj plec pracownika");
			String gender=read.next();
			p.setGender(gender);
			System.out.println("Podaj wiek pracownika");
			int age=read.nextInt();
			p.setAge(age);
			System.out.println("Podaj telefon pracownika");
			int phone=read.nextInt();
			p.setPhone(phone);
			System.out.println("Podaj pesel pracownika");
			int pesel=read.nextInt();
			p.setPesel(pesel);
			System.out.println("Podaj stanowisko pracownika");
			String stand=read.next();
			p.setPosition(stand);
			lista.add(p);
			output = lista.toString().getBytes();
			writeFile(output);
		}
		menu();
	}
	public void usun() throws IOException {
		System.out.println("Którego pracownika chcesz usunac?");
		int x=read.nextInt()-1;
		if(x>lista.size()) {
			System.out.println("Wprowadzony pracownik nie istnieje,spróbuj jeszcze raz");
			usun();
		}
		lista.remove(x);
		output = lista.toString().getBytes();
		writeFile(output);
		menu();
	}
	public void zamien() throws IOException {
		System.out.println("Którego pracownika dane chcesz zamienic?");
		int index=read.nextInt()-1;
		System.out.println("1.Imie");
		System.out.println("2.Nazwisko");
		System.out.println("3.Plec");
		System.out.println("4.Wiek");
		System.out.println("5.Telefon");
		System.out.println("6.Pesel");
		System.out.println("7.Stanowisko");
		int wybor=read.nextInt();
		switch(wybor) {
		case 1:
			System.out.println("Podaj nowe imie");
			String name=read.next();
			p.setName(name);
			lista.set(index, p);
			output = lista.toString().getBytes();
			writeFile(output);
			break;
		case 2:
			System.out.println("Podaj nowe nazwisko");
			String surname=read.next();
			p.setSurname(surname);
			lista.set(index, p);
			output = lista.toString().getBytes();
			writeFile(output);
			break;
		case 3:
			System.out.println("Podaj nową płeć");
			String gender=read.next();
			p.setGender(gender);
			lista.set(index, p);
			output = lista.toString().getBytes();
			writeFile(output);
			break;
		case 4:
			System.out.println("Podaj nowy wiek Pracownika");
			int age=read.nextInt();
			p.setAge(age);
			lista.set(index, p);
			output = lista.toString().getBytes();
			writeFile(output);
			break;
		case 5:
			System.out.println("Podaj nowy telefon pracownika");
			int phone=read.nextInt();
			p.setPhone(phone);
			lista.set(index, p);
			output = lista.toString().getBytes();
			writeFile(output);
			break;
		case 6:
			System.out.println("Podaj nowy pesel pracownika");
			int pesel=read.nextInt();
			p.setPesel(pesel);
			lista.set(index, p);
			output = lista.toString().getBytes();
			writeFile(output);
			break;
		case 7:
			System.out.println("Podaj nowe stanowisko pracownika");
			String stand=read.next();
			p.setPosition(stand);
			lista.set(index, p);
			output = lista.toString().getBytes();
			writeFile(output);
			break;
			default:
				System.out.println("Zła opcja spróbuj jeszcze raz");
				zamien();
		}
		menu();
	}
	private static byte[] readFile(String fileName) throws IOException {
		return Files.readAllBytes(PATH);
	}
  
	private static void writeFile(byte[] bytes) throws IOException {
		Files.write(PATH, bytes);
	}
	public void odczyt() throws IOException{
		byte[]input=readFile(FILE);
		String text=new String(input);
		System.out.println(text);
		menu();
	}
}