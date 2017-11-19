package projectcompiladores;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	private static Scanner entrada;
	static Lexico lexico = new Lexico();
	public static void main(String[] args) {
		
            entrada = new Scanner(System.in);
            String frase = entrada.nextLine();
            LinkedList<ClassificaPalavra> palavras = new LinkedList<ClassificaPalavra>();
		
            palavras = lexico.executaLexico(frase);
		
            Sintatico sintatico = new Sintatico(palavras);
            sintatico.sentenca(palavras);
	}
	

}
