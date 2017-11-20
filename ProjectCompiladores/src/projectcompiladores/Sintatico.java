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
			System.out.println(palavras.get(i).getPalavra());
                        
			if(palavras.get(i).getPalavra().equals(".")){
				System.out.println("Rodou");
			}else{
				System.out.println("Falta ponto final");
			}
				
		}
	}
	
	public boolean sentenca(){
                if(sintagmaNominal()){
                    return true;
                    /**if(SintagmaVerbal()){
            		return true;
                    }
            	
                }else if(SintagmaVerbal() && i < palavras.size()){
                    
                    if(SintagmaNominal() && i < palavras.size()){
            		return true;
                    }
            	
                }if(SintagmaAdver() && i < palavras.size()){
                    
                    sentenca();
                }*/
            
            
                
        }
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
        /**
        public boolean SintagmaVerbal(){
        	
        	if(encontraClassifi("verbo")){
        		return true;
        	}else if(encontraClassifi("verbo") && SintagmaPrep()){
        		return true;
        	}
        	
			return false;
        	
        }
        
        public boolean SintagmaPrep(){
        	return false;
        }
        
        public boolean SintagmaAdver(){
        	
        	if(adverbio()){
        		SintagmaAdver2();
        	}else {
                    
        	}
                return true;
        }
        
        public boolean SintagmaAdver2(){
        	return false;
        }
        
        public boolean SintagmaAdje(){
        	return false;
        }
        
        public boolean adverbio(){
        	
        	if(encontraClassifi("advérbio")){
        		i++;
        		adverbio2();
        		return true;
        	}
        	return false;
        }
        
        public boolean adverbio2(){
        	
        	if(SintagmaPrep());{
        		i++;
        		adverbio2();
        		return true;
        		
        	}
        	
        	
        }
        
        public boolean substantivo(){
        	
        	if(encontraClassifi("pronome")){
        		i++;
        		substantivo2();
        		return true;
        	}else if(encontraClassifi("substantivo")){
        		i++;
        		substantivo2();
        		return true;
        	}
        	
        	return false;
        }
        
        public boolean substantivo2(){
        	
        	if(SintagmaAdje()){
        		substantivo();
        		substantivo2();
        		return true;
        	}
        	return false;
        	
        }
        */
        /** Verifica se a palavra atual tem a classificacao passada como parametro*/
        public boolean encontraClassifi(String nome){
        	
        	for(int j = 0; j < palavras.size(); j++)
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


}
