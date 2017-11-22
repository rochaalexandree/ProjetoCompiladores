package projectcompiladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Sintatico {
        int i = 0;
        ArrayList<ClassificaPalavra> palavras = new ArrayList<ClassificaPalavra>();
        String novaFrase = "";
		
        public Sintatico(ArrayList<ClassificaPalavra> palavras ){
	        this.palavras = palavras;
	}
	        
	public void texto(){
		if(sentenca()){
			System.out.println("Frase correta");
		} else {
                    System.out.println("Frase Errada");
                }
                
                encontraSinonimo();
                new Busca(novaFrase);
                
                
                
                
	}
	/** Metodo que chama os demais
        * @return s*/
	public boolean sentenca(){
                if(sintagmaNominal()){
                    sintagmaVerbal();
                    return i == palavras.size();
                } else if(sintagmaVerbal()){
                    sintagmaNominal();
                    return i == palavras.size();
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
            if((encontraClassifi("artigo definido") || encontraClassifi("artigo indefinido")) && i < palavras.size()){
                i++;
                return nome();
                
            } 
            if((encontraClassifi("pronome") || encontraClassifi("pronome demonstrativo")) && i < palavras.size()){
                i++;
                return nome();
            } 
            if(encontraClassifi("numeral") && i < palavras.size()){
                i++;
                return nome();
                
            } 
            if(nome()){
                return true;
            } 
            if(encontraClassifi("pronome demonstrativo") && i < palavras.size()){
                i++;
                sintagmaNominal();
            }
            
            return false;
        }
        
        public boolean nome(){
            if((encontraClassifi("pronome") || encontraClassifi("pronome demonstrativo") || encontraClassifi("pronome pessoal")) && i < palavras.size()){
                i++;
                return nome2();
            }
            if((encontraClassifi("substantivo masculino") || encontraClassifi("substantivo feminino") || encontraClassifi("substantivo deverbal")) && i < palavras.size()){
                i++;
                return nome2();
            } else if(encontraClassifi("Nome") && i < palavras.size()){
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
                nome2();
            } else if(sintagmaPreposicional()){
                nome2();
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
            
            if(encontraClassifi("adjetivo") && i < palavras.size()){
                i++;
                if(adjetivo2()){
                    return adjetivo3();
                }
                return true;
            } else if(sintagmaAdverbial()){
                if(adjetivo()){
                    return adjetivo2();
                }
                return true;
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
        
        private boolean adjetivo3(){
            if(sintagmaAdverbial()){
                if(adjetivo2()){
                    adjetivo3();
                }
                return false;
            }
            return true;
        }
        
        private boolean sintagmaPreposicional() {
            
            if(encontraClassifi("preposição") && i < palavras.size()){
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
            
            if(encontraClassifi("verbo") && i < palavras.size()){
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
            return false;
        }
        
        private boolean sintagmaAdverbial2(){
            if(adverbio()){
                sintagmaAdverbial2();
            }
            return true;
        }
        
        private boolean adverbio() {
            
            if(encontraClassifi("advérbio") && i < palavras.size()){
                i++;
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
                System.out.print(nome + " | ");
        	if(i < palavras.size())
                    for(int j = 0; j < palavras.get(i).getClassificacao().size(); j++)
                    {
                        if(palavras.get(i).getClassificacao().get(j).equals(nome)){
                            //if(nome.equals("adjetivo"))
                                System.out.println("entrou");

                            return true;
                        }
                    }
                 System.out.println("entrou2");
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
        
        public void encontraSinonimo(){
                
                Dicionario dicionario = new Dicionario();
                
                for(int j = 0; j < palavras.size(); j++){
                    for(int k = 0; k < palavras.get(j).getClassificacao().size(); k++){
                        if(palavras.get(j).getClassificacao().get(k).equals("verbo") || palavras.get(j).getClassificacao().get(k).equals("adjetivo")){
                            palavras.get(j).setInformacoesAdicioanis(dicionario.buscaSinonimos(palavras.get(j).getPalavra()));
                        } 
                    }
                    if(palavras.get(j).getInformacoesAdicionais() != null){
                        Collections.shuffle(palavras.get(j).getInformacoesAdicionais());
                        novaFrase = novaFrase.concat(palavras.get(j).getInformacoesAdicionais().get(0));
                    }else{
                        novaFrase = novaFrase.concat(palavras.get(j).getPalavra());
                    }
                    novaFrase = novaFrase.concat(" ");
                }
                
                System.out.println(novaFrase);
        }
  
}