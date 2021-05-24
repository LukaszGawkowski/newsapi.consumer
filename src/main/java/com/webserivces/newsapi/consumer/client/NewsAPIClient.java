package com.webserivces.newsapi.consumer.client;

import com.webserivces.newsapi.consumer.dto.response.ArticlesDTO;
import com.webserivces.newsapi.consumer.service.FileWritter;
import com.webserivces.newsapi.consumer.service.HTTPConnectionHandler;
import org.springframework.stereotype.Controller;


@Controller
public class NewsAPIClient {

    private final HTTPConnectionHandler connectionHandler;
    private final FileWritter fileWritter;

   public NewsAPIClient(HTTPConnectionHandler connectionHandler, FileWritter fileWritter){
       this.connectionHandler = connectionHandler;
       this.fileWritter = fileWritter;
   }

    public ArticlesDTO[] getArticles(String q, String lang){
       return connectionHandler.getEverythingArticlesOnePage(q,lang);
    }

    public void createFile(ArticlesDTO[] array, String destination){
       fileWritter.writeFile(array, destination);
    }

}
