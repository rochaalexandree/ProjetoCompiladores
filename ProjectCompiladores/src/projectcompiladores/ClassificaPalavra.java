package projectcompiladores;

import java.util.ArrayList;

public class ClassificaPalavra {
	
	private String palavra;
        ArrayList<String> classificacao = new ArrayList<String>();
        ArrayList<String> informacoesAdicionais = new ArrayList<String>();
	
	public ClassificaPalavra(String palavra, ArrayList<String> classificacao, ArrayList<String> informacoesAdicionais){
		this.palavra = palavra;
		this.classificacao = classificacao;
		this.informacoesAdicionais = informacoesAdicionais;
		
	}
	
	public String getPalavra(){
		return this.palavra;
	}
	
	public ArrayList<String> getClassificacao(){
		return this.classificacao;
	}
	
	public ArrayList<String> getInformacoesAdicionais(){
		return this.informacoesAdicionais;
	}

}
