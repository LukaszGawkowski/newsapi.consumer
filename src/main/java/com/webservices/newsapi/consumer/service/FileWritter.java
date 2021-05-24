package com.webservices.newsapi.consumer.service;

import com.webservices.newsapi.consumer.Application;
import com.webservices.newsapi.consumer.dto.response.ArticlesDTO;
import com.webservices.newsapi.consumer.properties.NewsAPIproperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FileWritter {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public void writeFile(ArticlesDTO[] array) throws IOException {

        final String DESTINATION = "src/main/java/com/webservices/newsapi/consumer/output/";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH:mm:ss_");
        LocalDateTime todaysDate = LocalDateTime.now();
        dateTimeFormatter.format(todaysDate);

        final String FILE_NAME = dateTimeFormatter.format(todaysDate) +"apinews_everything_result.txt";
        final String HEADER = "AUTHOR:DESCRIPTION:TITLE";

        BufferedWriter writer = new BufferedWriter(new FileWriter(DESTINATION +FILE_NAME));
        writer.write(HEADER);

        for (ArticlesDTO element : array) {
            writer.newLine();
            writer.append(element.toString());
        }
        writer.close();

        log.info("Text file created successfully. Number of uploaded articles = " + array.length);
        log.info("File name: " + FILE_NAME);
        log.info("Check output Folder!");
    }
}
