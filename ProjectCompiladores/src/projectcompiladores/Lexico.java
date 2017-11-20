package projectcompiladores;

import java.util.ArrayList;

public class Lexico {

	public Lexico(){}
	
	public ArrayList<ClassificaPalavra> executaLexico(String frase){
		int pInicial = 0, pFinal = 0, cont = 0;//pInicial e pFinal sao usadas para demarcar o inicio e fim de uma palavra na string
		ArrayList<ClassificaPalavra> palavras = new ArrayList<ClassificaPalavra>();
		String palavra; 
		ArrayList<String> classificacao = null;
                ArrayList<String> adicional = null;
                Dicionario dicionario = new Dicionario();
                
		//While executa ate o fim da string para separar as palavras
		while(cont < frase.length()){
			cont++;
			
			//Atualiza o tamanho da palavra se entrar no if, caso nao entre, pula para proxima palavra
			if(cont < frase.length() && frase.charAt(cont) != ' ' && !pontuacaoFinal(frase.charAt(cont)) && frase.charAt(cont) != ','){
				pFinal++;
			} else {
				pFinal++;
				
                                classificacao = new ArrayList<String>();
                                adicional = new ArrayList<String>();
				palavra = frase.substring(pInicial, pFinal);
                                
				classificacao = dicionario.classificaPalavra(palavra, "infinitivo");
				//adicional = dicionario.classificaPalavra(palavra, "adicional");
                                adicional = null;
				palavras.add(new ClassificaPalavra(palavra, classificacao, adicional));//Coloca a palavra, classificacao e conteudo adicional na lista
				
				pInicial = cont + 1; //Pula para a proxima palavra
				pFinal = pInicial; //Atualiza posicao final
				
				if(cont < frase.length())
					if(frase.charAt(cont) == ',' || pontuacaoFinal(frase.charAt(cont))){
						
						if(frase.charAt(cont) == ',')
							palavras.add(new ClassificaPalavra(frase.substring(cont, cont + 1), null, null));
						else
							palavras.add(new ClassificaPalavra(frase.substring(cont, cont + 1), null, null));
						pInicial++;
					}
				cont++;
				
			}	
			
		}
		
		for(int i = 0; i < palavras.size(); i++){
			System.out.print(palavras.get(i).getPalavra() + " | ");
              
                        System.out.print(palavras.get(i).getClassificacao() + " | ");
			System.out.println(palavras.get(i).getInformacoesAdicionais());
		}
		return palavras;
		
	}
	
	public boolean pontuacaoFinal(char x){
            return x == '.' || x == '!' || x == '?';
		
	}
	
	
}
