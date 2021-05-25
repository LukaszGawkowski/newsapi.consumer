package com.webservices.newsapi.consumer.service;

import com.webservices.newsapi.consumer.model.Article;

import java.io.IOException;

public interface ClientService {

    Article[] getArticles(String queriedPhrase, String lang);

    void createFile(Article[] articles) throws IOException;

}
