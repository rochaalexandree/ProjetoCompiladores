package projectcompiladores;
public class ClassificaPalavra {
	
	private String palavra, classificacao, informacoesAdicionais; 
	
	public ClassificaPalavra(String palavra, String classificacao, String informacoesAdicionais){
		this.palavra = palavra;
		this.classificacao = classificacao;
		this.informacoesAdicionais = informacoesAdicionais;
		
	}
	
	public String getPalavra(){
		return this.palavra;
	}
	
	public String getClassificacao(){
		return this.classificacao;
	}
	
	public String getInformacoesAdicionais(){
		return this.informacoesAdicionais;
	}

}
