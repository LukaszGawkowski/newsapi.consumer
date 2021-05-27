package com.webservices.newsapi.consumer.service;

import com.webservices.newsapi.consumer.enumTypes.FileType;
import com.webservices.newsapi.consumer.io.HTTPConnectionHandler;
import com.webservices.newsapi.consumer.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class ClientServiceImpl  implements ClientService{

    private final HTTPConnectionHandler connectionHandler;

   public ClientServiceImpl(HTTPConnectionHandler connectionHandler){
       this.connectionHandler = connectionHandler;
   }

   @Autowired
   FileWritterServiceImpl fileWritterServiceImpl;

    @Override
    public Article[] getArticles(String q, String lang){
        return connectionHandler.getArticlesPage(q,lang);
    }

    @Override
    public void createFile(Article[] array, FileType fileType) throws IOException {
        fileWritterServiceImpl.writeFile(array, fileType);
    }

}
