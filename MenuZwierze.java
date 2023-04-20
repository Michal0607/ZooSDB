//Baza Zwierzeta

package MichalSzulierz3A;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuZwierze extends Zwierze implements Funkcje{
	
	private static final String FILE = "./src/MichalSzulierz3A/Zwierzeta.txt";
	private static final Path PATH = Paths.get(FILE);
	
	Scanner read=new Scanner(System.in);
	ArrayList<Zwierze> lista=new ArrayList<>();
	byte[] output = lista.toString().getBytes();
	Zwierze z=new Zwierze();
	
	public void menu() throws IOException {
		System.out.println("Która opcje wybierasz?");
		System.out.println("1.Dodaj Zwierze");
		System.out.println("2.Zamień Zwierze");
		System.out.println("3.Usun zwierze");
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
		Zwierze z=new Zwierze();
		System.out.println("Ile Zwierzat chcesz dodac?");
		int x=read.nextInt();
		for(int i=0;i<x;i++) {
			System.out.println("Podaj imie");
			String name=read.next();
			z.setName(name);
			System.out.println("Podaj gatunek");
			String type=read.next();
			z.setType(type);
			System.out.println("Podaj numer klatki");
			int homeId=read.nextInt();
			z.setHomeID(homeId);
			lista.add(z);
			output=lista.toString().getBytes();
			writeFile(output);
		}
		menu();
	}
	public void usun() throws IOException {
		System.out.println("Którego pracownika chcesz usunac?");
		int x=read.nextInt()-1;
		lista.remove(x);
		output = lista.toString().getBytes();
		writeFile(output);
		
		menu();
	}
	public void zamien() throws IOException {
		System.out.println("Którego Zwierzecia dane chcesz zamienic?");
		int index=read.nextInt()-1;
		System.out.println("1.Ksywka");
		System.out.println("2.Gatunek");
		System.out.println("3.Numer klatki");
		int wybor=read.nextInt();
		switch(wybor) {
		case 1:
			String name=read.next();
			z.setName(name);
			lista.set(index,z);
			output = lista.toString().getBytes();
			writeFile(output);
		case 2:
			String type=read.next();
			z.setType(type);
			lista.set(index,z);
			output = lista.toString().getBytes();
			writeFile(output);
		case 3:
			int homeId=read.nextInt();
			z.setHomeID(homeId);
			lista.set(index,z);
			output = lista.toString().getBytes();
			writeFile(output);
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
		byte[] input=readFile(FILE);
		String text=new String(input);
		System.out.println(text);
		menu();
	}
	

}