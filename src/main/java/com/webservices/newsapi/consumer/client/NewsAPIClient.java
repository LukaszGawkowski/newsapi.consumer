package com.webservices.newsapi.consumer.client;

import com.webservices.newsapi.consumer.dto.response.ArticlesDTO;
import com.webservices.newsapi.consumer.service.FileWritter;
import com.webservices.newsapi.consumer.service.HTTPConnectionHandler;
import org.springframework.stereotype.Controller;

import java.io.IOException;


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

    public void createFile(ArticlesDTO[] array) throws IOException {
       fileWritter.writeFile(array);
    }

}
