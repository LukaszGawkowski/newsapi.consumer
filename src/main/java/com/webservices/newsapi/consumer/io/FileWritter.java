package com.webservices.newsapi.consumer.io;

import com.webservices.newsapi.consumer.model.Article;
import com.webservices.newsapi.consumer.properties.FileWritterProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class FileWritter {

    private static final Logger log = LoggerFactory.getLogger(FileWritter.class);

    @Autowired
    FileWritterProperties fileWritterProperties;

    public void writeFile(Article[] array) throws IOException {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH:mm:ss_");
        LocalDateTime todaysDate = LocalDateTime.now();
        dateTimeFormatter.format(todaysDate);

        final String DESTINATION = fileWritterProperties.getFileSavePath();
        final String FILE_NAME = dateTimeFormatter.format(todaysDate) + fileWritterProperties.getFileBaseName();
        final String HEADER = fileWritterProperties.getHeader();

        BufferedWriter writer = new BufferedWriter(new FileWriter(DESTINATION +FILE_NAME));
        writer.write(HEADER);

        for (Article element : array) {
            writer.newLine();
            writer.append(element.toString());
        }
        writer.close();

        log.info("Text file created successfully. Number of uploaded articles = " + array.length);
        log.info("File name: " + FILE_NAME);
        log.info("Check output Folder!");
    }
}
