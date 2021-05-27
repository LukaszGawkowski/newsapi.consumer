package com.webservices.newsapi.consumer.service;

import com.webservices.newsapi.consumer.enumTypes.FileType;
import com.webservices.newsapi.consumer.io.FileCreator;
import com.webservices.newsapi.consumer.model.Article;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FileCreatorServiceImpl implements FileCreatorService {

    private FileCreator fileCreator;

    public FileCreatorServiceImpl(FileCreator fileCreator){
        this.fileCreator = fileCreator;
    }

    @Override
    public void writeFile(Article[] articles, FileType fileType) throws IOException {
        switch (fileType){
            case JSON -> fileCreator.writeAsJSON(articles);
            case TXT -> fileCreator.writeFileAsText(articles);
            case CSV -> fileCreator.writeAsCSV(articles);
        }
    }
}
