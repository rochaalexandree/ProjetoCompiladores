package projectcompiladores;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Dicionario {
	
	private Document document;
	
	public Dicionario(){}
	/** M�todo que retorna a classifica��o de cada palavra atrav�s do site www.dicio.com.br*/
	public String classificaPalavra(String elemento, String infinitivoOuAdicional){
		String classifica = null;
		
		try{
			Document document = Jsoup.connect("https://www.dicio.com.br/" + elemento + "/").get();
			this.document = document;
			classifica = getClassificacao(infinitivoOuAdicional);
			
		} catch (IOException e){
			e.printStackTrace();
		}
		return classifica;
	}
	
	private String getClassificacao(String infinitivoOuAdicional) {
		String classifica = null;
		Elements elements = document.getElementsByTag("span");
		classifica = getSpanPaginas(elements.eq(7), infinitivoOuAdicional);
		
		return classifica;
	}

	private String getSpanPaginas(Elements elements, String infinitivoOuAdicional) {
		String classifica = null;
		
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
		if(classifica.length() > 25){
			String[] palavras = classifica.split(" ");
			classifica = palavras[3];
			return classifica;
		}
		return classifica;
	}
}
