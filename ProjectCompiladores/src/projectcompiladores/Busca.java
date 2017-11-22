package com.mkyong;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Busca {
    
    public Busca(String frase){
        try{
        Document doc = Jsoup.connect("https://www.google.com/search?q=" + frase + "&num=20").get();
        
        Elements links = doc.select("a[href]");
        for(Element link: links){
            System.out.println("\nlink : " + link.attr("href"));
            System.out.println("text : " + link.text());
        }
        
        } catch(IOException e){
            e.printStackTrace();
        }
    }
  

}
