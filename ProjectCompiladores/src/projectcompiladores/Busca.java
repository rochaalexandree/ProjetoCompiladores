package com.mkyong;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Busca {
    
    public Busca(String frase){
        try{
        Document doc = Jsoup.connect("http://www.google.com.br/search?q=" + "\"" + frase + "\"").get();
        
        Elements links = doc.select("a[href]");
        for(Element link: links){
            System.out.println("\nlink : " + link.attr("href"));
            System.out.println("text : " + link.text());
        }
        Elements div = doc.select("div[id=resultStats]");

        System.out.println(div.text());
        
        } catch(IOException e){
            e.printStackTrace();
        }
    }
  

}
