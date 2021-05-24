package com.webserivces.newsapi.consumer.client;

import com.webserivces.newsapi.consumer.dto.response.ArticlesDTO;
import com.webserivces.newsapi.consumer.service.HTTPConnectionHandler;
import org.springframework.stereotype.Controller;


@Controller
public class NewsAPIClient {

    private final HTTPConnectionHandler connectionHandler;

   public NewsAPIClient(HTTPConnectionHandler connectionHandler){
       this.connectionHandler = connectionHandler;
   }

    public ArticlesDTO[] getArticles(String q, String lang){
       return connectionHandler.getEverythingArticlesOnePage(q,lang);
    }

}
