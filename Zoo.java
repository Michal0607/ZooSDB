//Główne Menu

package MichalSzulierz3A;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zoo {

	static Scanner read=new Scanner(System.in);
	static MenuZwierze menuz=new MenuZwierze();
	static MenuPracownicy menup=new MenuPracownicy();
	
	public static void main(String[] args) throws IOException {
		menu();
	}
	
	public static void menu() throws IOException{
		int x=0;
		System.out.println("1.Pracownicy");
		System.out.println("2.Zwierzeta");
		boolean isNumeric=false;
		while(!isNumeric) 
			try {
			System.out.println("Wybierz opcje:");
			x=read.nextInt();
			isNumeric=true;
		}catch(InputMismatchException e){
			System.out.println("Zły znak podaj wartosc od 1 do 2");
			read.next();
		}
		
		switch(x) {
		case 1:
			menup.menu();
		case 2:
			menuz.menu();
			default:
				System.out.println("Podałeś złą wartość spróbuj jeszcze raz");
				menu();
		}
		
	}
}