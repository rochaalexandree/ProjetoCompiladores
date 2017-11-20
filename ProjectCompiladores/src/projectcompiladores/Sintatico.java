package projectcompiladores;

import java.util.ArrayList;

public class Sintatico {
        int i = 0;
        ArrayList<ClassificaPalavra> palavras = new ArrayList<ClassificaPalavra>();
		
        public Sintatico(ArrayList<ClassificaPalavra> palavras ){
	        this.palavras = palavras;
	}
	        
	public void texto(){
		if(sentenca()){
			if(pontoFinal()){
				System.out.println("Rodou");
			}else{
				System.out.println("Falta ponto final");
			}	
		}
	}
	
	public boolean sentenca(){
                if(sintagmaNominal())
                    return true;
                i = 0;
                if(proAdj())
                    return true;
                return false;
        }
        public boolean sintagmaNominal(){
            if(encontraClassifi("artigo definido")){
                i++;
                if(encontraClassifi("substantivo masculino")){
                    incrementofinal();
                    return true;
                }
                else if(encontraClassifi("substantivo feminino")){
                    incrementofinal();
                    return true;
                }
            }
            else if(encontraClassifi("artigo indefinido")){
                i++;
                if(encontraClassifi("substantivo masculino")){
                    incrementofinal();
                    return true;
                }
                else if(encontraClassifi("substantivo feminino")){
                    incrementofinal();
                    return true;
                }
            }
            else if(encontraClassifi("numeral")){
                i++;
                if(encontraClassifi("substantivo masculino")){
                    incrementofinal();
                    return true;
                }
                else if(encontraClassifi("substantivo feminino")){
                    incrementofinal();
                    return true;
                }
            }
            return false;
        }
        
        /** Verifica se a palavra atual tem a classificacao passada como parametro*/
        public boolean encontraClassifi(String nome){
        	for(int j = 0; j < palavras.get(i).getClassificacao().size(); j++)
        	{
        	    if(palavras.get(i).getClassificacao().get(j).equals(nome)){
        	    	return true;
        	    }
        	}
        	return false;
        }
        
        public void incrementofinal(){
                if(i < palavras.size() - 1)
                    i++;              
        }
        
        public boolean proAdj(){
        	if(encontraClassifi("pronome") || encontraClassifi("pronome demonstrativo")){
        		i++;
        		if(encontraClassifi("substantivo masculino")){
                                incrementofinal();
        			return true;
        		}else if(encontraClassifi("substantivo feminino")){
                                incrementofinal();
        			return true;
        		}
        		return false;
        	}
        	return false;
        }
        
        public boolean pontoFinal(){
            return palavras.get(i).getPalavra().equals(".") || palavras.get(i).getPalavra().equals("!") || palavras.get(i).getPalavra().equals("?");
        }
}
