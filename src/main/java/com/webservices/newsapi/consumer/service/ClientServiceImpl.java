package com.webservices.newsapi.consumer.service;

import com.webservices.newsapi.consumer.io.FileWritter;
import com.webservices.newsapi.consumer.io.HTTPConnectionHandler;
import com.webservices.newsapi.consumer.model.Article;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class ClientServiceImpl  implements ClientService{

    private final HTTPConnectionHandler connectionHandler;
    private final FileWritter fileWritter;

   public ClientServiceImpl(HTTPConnectionHandler connectionHandler, FileWritter fileWritter){
       this.connectionHandler = connectionHandler;
       this.fileWritter = fileWritter;
   }

    @Override
    public Article[] getArticles(String q, String lang){
       return connectionHandler.getArticlesPage(q,lang);
    }

    @Override
    public void createFile(Article[] array) throws IOException {
       fileWritter.writeFile(array);
    }

}
