package bancomat;

import java.io.*;
import java.util.Scanner;

public class Contocorrente {
	public static void main (String args []) throws IOException {

		/*InputStreamReader input=new InputStreamReader(System.in); 
		BufferedReader h= new BufferedReader(input);*/

		//creo un oggetto di tipo Scanner per leggere gli input che immette l'utente da tastiera
		Scanner input = new Scanner(System.in);

		char ch;
		int somma;
		Cc c = new Cc();
		do{
			System.out.println("v-Versamento");
			System.out.println("p-Prelievo");
			System.out.println("s-Saldo");
			System.out.println("e-Exit");

            //assegno alla variabile "ch" l'input che proviene dall'utente, lo rendo minuscolo e prendo in considerazione solo la prima letttera
			ch =(input.next().toLowerCase()).charAt(0);
			switch (ch) {

			case 'v':
				System.out.print("somma da versare:");  
				somma=input.nextInt();
				c.versamento(somma);
				break;

			case 'p':
				if(c.saldo()<=0) {
					System.out.println("Non puoi prelevare! Il tuo saldo è in rosso");
				}

				else {
					System.out.print("somma da prelevare:");  
					somma=input.nextInt();
					if(somma>c.saldo()){
						System.out.println("la somma inserita è maggiore del saldo"); 
					}
					else {
						c.prelievo(somma);
					}

				}



				break;
			case 's': System.out.println(c.saldo()); break;

			case 'e': System.out.println("EXIT"); break;

			default: System.out.println("selezione non valida"); break;

			}//fine switch
		}while(ch!='x');
		input.close();
	}//fine main

}// fine classe main


