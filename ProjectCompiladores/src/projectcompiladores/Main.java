package projectcompiladores;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static Scanner entrada;
	static Lexico lexico = new Lexico();
	public static void main(String[] args) {
		
            entrada = new Scanner(System.in);
            String frase = entrada.nextLine();
            ArrayList<ClassificaPalavra> palavras = new ArrayList<ClassificaPalavra>();
		
            palavras = lexico.executaLexico(frase);
            //System.out.println(palavras);
            Sintatico sintatico = new Sintatico(palavras);
            sintatico.texto();
          
	}
	

}
