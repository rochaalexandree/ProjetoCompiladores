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
								
				if(palavras.get(i).getPalavra().equals(".")){
					System.out.println("Rodou");
				}else{
					System.out.println("Falta ponto final");
				}
				
			}
		}
	
		public boolean sentenca(){
            if(SintagmaNominal() ){
            	i++;
            	if(SintagmaVerbal()){
            		return true;
            	}
            	
            }else if(SintagmaVerbal()){
            	i++;
            	if(SintagmaNominal()){
            		return true;
            	}
            	
            }if(SintagmaAdver()){
            	i++;
            	sentenca();
            }
            
            
            return false;
        }
        
        public boolean SintagmaNominal(){
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
 
        public boolean SintagmaVerbal(){
        	
        	if(palavras.get(i).getClassificacao().equals("verbo")){
        		return true;
        	}else if(palavras.get(i).getClassificacao().equals("verbo") && SintagmaPrep()){
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
        	
        	if(palavras.get(i).getClassificacao().equals("advérbio")){
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
        	
        	if(palavras.get(i).getClassificacao().equals("pronome")){
        		i++;
        		substantivo2();
        		return true;
        	}else if(palavras.get(i).getClassificacao().equals("substantivo")){
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
}
