package projectcompiladores;

import java.util.ArrayList;

public class Sintatico {
    
        int i = 0;
        ArrayList<ClassificaPalavra> palavras = new ArrayList<ClassificaPalavra>();
	public Sintatico(ArrayList<ClassificaPalavra> palavras ){
            this.palavras = palavras;
	}
        
        public boolean sentenca(ArrayList<ClassificaPalavra> palavras){
            if(isSintagmaNominal()){
                System.out.println("É SINTAGMA NOMINAL");
                return true;
            }
            return false;
        }
        
        public boolean isSintagmaNominal(){
            for(int j = 0; j < palavras.get(i).getClassificacao().size(); j++){
                if(palavras.get(i).getClassificacao().get(j).equals("artigo definido")){
                    i++;
                    if(palavras.get(i).getClassificacao().get(j).equals("substantivo masculino"))
                        return true;
                    else if(palavras.get(i).getClassificacao().get(j).equals("substantivo feminino"))
                        return true;
                }
                else if(palavras.get(i).getClassificacao().get(j).equals("artigo indefinido")){
                    i++;
                    if(palavras.get(i).getClassificacao().get(j).equals("substantivo masculino"))
                        return true;
                    else if(palavras.get(i).getClassificacao().get(j).equals("substantivo feminino"))
                        return true;
                }
                else if(palavras.get(i).getClassificacao().get(j).equals("numeral")){
                    i++;
                    i += 1;
                    if(palavras.get(i).getClassificacao().get(j).equals("substantivo masculino"))
                        return true;
                    else if(palavras.get(i).getClassificacao().get(j).equals("substantivo feminino"))
                        return true;
                }
            }
      
            return false;
        }
}
