package com.webservices.newsapi.consumer.service;

import com.webservices.newsapi.consumer.enumTypes.FileType;
import com.webservices.newsapi.consumer.io.FileWritter;
import com.webservices.newsapi.consumer.model.Article;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FileWritterServiceImpl implements FileWritterService {

    private FileWritter fileWritter;

    public FileWritterServiceImpl(FileWritter fileWritter){
        this.fileWritter = fileWritter;
    }

    @Override
    public void writeFile(Article[] articles, FileType fileType) throws IOException {
        switch (fileType){
            case JSON -> fileWritter.writeAsJSON(articles);
            case TXT -> fileWritter.writeFileAsText(articles);
            case CSV -> fileWritter.writeAsCSV(articles);
        }
    }
}
