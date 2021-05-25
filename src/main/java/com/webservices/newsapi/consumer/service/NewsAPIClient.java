package com.webservices.newsapi.consumer.service;

import com.webservices.newsapi.consumer.dto.response.ArticlesDTO;
import com.webservices.newsapi.consumer.io.FileWritter;
import com.webservices.newsapi.consumer.io.HTTPConnectionHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class NewsAPIClient {

    private final HTTPConnectionHandler connectionHandler;
    private final FileWritter fileWritter;

   public NewsAPIClient(HTTPConnectionHandler connectionHandler, FileWritter fileWritter){
       this.connectionHandler = connectionHandler;
       this.fileWritter = fileWritter;
   }

    public ArticlesDTO[] getArticles(String q, String lang){
       return connectionHandler.getArticlesPage(q,lang);
    }

    public void createFile(ArticlesDTO[] array) throws IOException {
       fileWritter.writeFile(array);
    }

}
