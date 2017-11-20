package projectcompiladores;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Dicionario {
	
	private Document document;
	
	public Dicionario(){}
	/** M�todo que retorna a classifica��o de cada palavra atrav�s do site www.dicio.com.b*/
	public ArrayList<String> classificaPalavra(String elemento, String infinitivoOuAdicional){
		ArrayList<String> classificacao = new ArrayList<String>();
		
		try{
			Document document = Jsoup.connect("https://www.dicio.com.br/" + elemento + "/").get();
			this.document = document;
			classificacao = getClassificacao(infinitivoOuAdicional);
			
		} catch (IOException e){
			e.printStackTrace();
		}
                
		return classificacao;
	}
	
	private ArrayList<String> getClassificacao(String infinitivoOuAdicional) {
		
                ArrayList<String> classificacao = new ArrayList<String>();
                String classifica = null;
		Elements elements = document.getElementsByTag("span");
               
		classifica = getSpanPaginas(elements.eq(7), infinitivoOuAdicional);
                classificacao.add(classifica);
                
                for(int i = 8; i < elements.size(); i++){
                    classifica = elements.eq(i).text();
                    if(classifica.length() < 29){
                        classifica = getSpanPaginas(elements.eq(i), infinitivoOuAdicional);
                        if(classificacoesGerais(classifica) && classifica.length() < 29){   

                            classificacao.add(classifica);
                        }
                    }
                }
		
		return classificacao;
	}

	private String getSpanPaginas(Elements elements, String infinitivoOuAdicional) {
		String classifica;
		
		classifica = elements.text(); // Pega o texto da tag para classificar a palavra
		String[] palavras = classifica.split(" ");
		
		if(infinitivoOuAdicional.equals("infinitivo") && palavras[0].equals("Nome"))
			classifica = palavras[0];
		else if(infinitivoOuAdicional.equals("infinitivo"))
			classifica = tempoVerbal(classifica);
		else if(classifica.length() < 25 && infinitivoOuAdicional.equals("adicional"))
			classifica = null;
		
		return classifica;
	}
	private String tempoVerbal(String classifica) {
		if(classifica.length() > 29){
			String[] palavras = classifica.split(" ");
			classifica = palavras[3];
			return classifica;
		}
		return classifica;
	}
        
        private boolean classificacoesGerais(String classificacao){
            switch (classificacao) {
                case "artigo definido":
                    return true;
                case "artigo indefinido":
                    return true;
                case "preposição":
                    return true;
                case "substantivo masculino":
                    return true;
                case "substantivo feminino":
                    return true;
                case "numeral":
                    return true;
                case "pronome pessoal":
                    return true;
                case "pronome indefinido":
                    return true;
                case "locução adverbial":
                    return true;
                case "locução conjuntiva":
                    return true;
                case "advérbio":
                    return true;
                case "adjetivo":
                    return true;
                case "expressão":
                    return true;
                default:
                    break;
            }
                
                return false;
        }
}
