package projectcompiladores;

import java.util.LinkedList;

public class Sintatico {
    
        int i = 0;
        LinkedList<ClassificaPalavra> palavras = new LinkedList<ClassificaPalavra>();
	public Sintatico(LinkedList<ClassificaPalavra> palavras ){
            this.palavras = palavras;
	}
        
        public boolean sentenca(LinkedList<ClassificaPalavra> palavras){
            if(isSintagmaNominal(palavras.get(i).getClassificacao())){
                System.out.println("É SINTAGMA NOMINAL");
                return true;
            }
            return false;
        }
        
        public boolean isSintagmaNominal(String palavra){
            if(palavras.get(i).getClassificacao().equals("artigo definido")){
                i++;
                if(palavras.get(i).getClassificacao().equals("substantivo masculino"))
                    return true;
                else if(palavras.get(i).getClassificacao().equals("substantivo feminino"))
                    return true;
            }
            else if(palavras.get(i).getClassificacao().equals("artigo indefinido")){
                i++;
                if(palavras.get(i).getClassificacao().equals("substantivo masculino"))
                    return true;
                else if(palavras.get(i).getClassificacao().equals("substantivo feminino"))
                    return true;
            }
            else if(palavras.get(i).getClassificacao().equals("numeral")){
                i++;
                i += 1;
                if(palavras.get(i).getClassificacao().equals("substantivo masculino"))
                    return true;
                else if(palavras.get(i).getClassificacao().equals("substantivo feminino"))
                    return true;
            }
      
            return false;
        }
}
