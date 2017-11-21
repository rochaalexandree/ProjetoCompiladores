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
				System.out.println("Frase correta");
			}else{
				System.out.println("Falta ponto final");
			}	
		}
	}
	/** Metodo que chama os demais
        * @return s*/
	public boolean sentenca(){
                if(sintagmaNominal()){
                    return sintagmaVerbal();
                } else if(sintagmaVerbal()){
                    return sintagmaNominal();
                }else if(sintagmaVerbal()){
                    return true;
                } else if(sintagmaAdverbial()){
                    sentenca();
                }
                
                return false;
        }
        /**Verifica Sintagma Nonima
        * @return l*/
        public boolean sintagmaNominal(){
            if(palavras.size() < 2)
                return false;
            if(encontraClassifi("artigo definido") || encontraClassifi("artigo indefinido")){
                i++;
                return nome();
                
            } else if(encontraClassifi("pronome") || encontraClassifi("pronome demonstrativo")){
                i++;
                return nome();
            } else if(encontraClassifi("numeral")){
                i++;
                return nome();
                
            } else if(nome()){
                return true;
            } else if(encontraClassifi("pronome demonstrativo")){
                i++;
                sintagmaNominal();
            }
            
            return false;
        }
        
        public boolean nome(){
            if(encontraClassifi("pronome") || encontraClassifi("pronome demonstrativo")){
                i++;
                return nome2();
            }
            if(encontraClassifi("substantivo masculino") || encontraClassifi("substantivo feminino")){
                i++;
                return nome2();
            } else if(encontraClassifi("Nome")){
                i++;
                return nome2();
            } else if(sintagmaAdjetival()){
                if(nome()){
                    return nome2();
                }
            }
            return false;
        }
        
        private boolean nome2() {
            if(sintagmaAdjetival()){
                return nome2();
            } else if(sintagmaPreposicional()){
                return nome2();
            }
            return true;
        }
        
        private boolean sintagmaAdjetival() {
            
            if(adjetivo()){
                if(sintagmaAdverbial()){
                    return true;
                } else if(sintagmaPreposicional()){
                    return true;
                }
                return true;
            } else if(sintagmaAdverbial()){
                return adjetivo();
            }
            return false;
        }
        
        private boolean adjetivo() {
            if(encontraClassifi("adjetivo")){
                i++;
                return adjetivo2();
            } else if(sintagmaAdverbial()){
                if(adjetivo()){
                    return adjetivo2();
                }
            }
            return false;
        }
        
        private boolean adjetivo2() {
            if(sintagmaAdverbial()){
                adjetivo2();
            } else if(sintagmaPreposicional()){
                adjetivo2();
            }
            return true;
        }
        
        private boolean sintagmaPreposicional() {
            if(encontraClassifi("preposição")){
                i++;
                if(sintagmaNominal()){
                    return true;
                } else if(sintagmaAdverbial()){
                    return true;
                }
            }
            return false;
        }
        
        private boolean sintagmaVerbal() {
            if(palavras.size() < 2)
                return false;
            if(verbo()){
                if(sintagmaPreposicional()){
                    return true;
                } else if(sintagmaAdverbial()){
                    return true;
                }
            } else if(sintagmaAdverbial()){
                return verbo();
            }
            return false;
        }
        
        private boolean verbo() {
            if(sintagmaAdverbial()){
                if(verbo()){
                    return verbo2();
                }
            } else if(VB()){
                if(verbo2()){
                    return true;
                } else if( sintagmaNominal()){
                    return verbo2();
                } else if(sintagmaPreposicional()){
                    return verbo2();
                } else if(sintagmaAdjetival()){
                    return verbo2();
                } else if(sintagmaAdverbial()){
                    return verbo2();
                }
                return verbo2();
            }
            return false;
        }
        private boolean verbo2() {
            if(sintagmaNominal()){
                verbo2();
            } else if(sintagmaPreposicional()){
                verbo2();
            } else if(sintagmaAdverbial()){
                verbo2();
            }
            return true;
        }
        
        private boolean VB() {
            if(encontraClassifi("verbo")){
                i++;
                return true;
            }
            return false;
        }
        
        private boolean sintagmaAdverbial() {
            if(adverbio()){
                if(sintagmaAdverbial2()){
                    return true;
                } else if(sintagmaPreposicional()){
                    return sintagmaAdverbial2();
                }
            }
            return true;
        }
        
        private boolean sintagmaAdverbial2(){
            if(adverbio()){
                sintagmaAdverbial2();
            }
            return true;
        }
        
        private boolean adverbio() {
            if(encontraClassifi("advérbio")){
                return adverbio2();
            }
            return false;
        }
        private boolean adverbio2() {
            if(sintagmaPreposicional()){
                adverbio2();
            }
            return true;
        }
        /** Verifica se a palavra atual tem a classificacao passada como parametr
        * @param nome
        * @return o*/
        public boolean encontraClassifi(String nome){
        	for(int j = 0; j < palavras.get(i).getClassificacao().size(); j++)
        	{
        	    if(palavras.get(i).getClassificacao().get(j).equals(nome)){
        	    	return true;
        	    }
        	}
                return false;
        }
        /**Verifica se há necessidade de incrementar a posicao*/
        public void incrementofinal(){
                if(i < palavras.size() - 1)
                    i++;              
        }
        
        public boolean pontoFinal(){
            return palavras.get(i).getPalavra().equals(".") || palavras.get(i).getPalavra().equals("!") || palavras.get(i).getPalavra().equals("?");
        }

    

    
    
    

    

    

    

    

    

    

    

    

    

    
}
