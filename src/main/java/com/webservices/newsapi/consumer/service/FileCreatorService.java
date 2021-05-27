package com.webservices.newsapi.consumer.service;

import com.webservices.newsapi.consumer.enumTypes.FileType;
import com.webservices.newsapi.consumer.model.Article;

import java.io.IOException;

public interface FileCreatorService {

   void writeFile(Article[] articles, FileType fileType) throws IOException;

}
