package com.webservices.newsapi.consumer.io;

import com.opencsv.CSVWriter;
import com.webservices.newsapi.consumer.model.Article;
import com.webservices.newsapi.consumer.properties.FileWritterProperties;
import org.json.simple.JSONObject;
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
public class FileCreator {

    private static final Logger log = LoggerFactory.getLogger(FileCreator.class);

    @Autowired
    FileWritterProperties fileWritterProperties;

    private final String DESTINATION;
    private final String BASE_NAME;
    private final String HEADER;


    public FileCreator(FileWritterProperties fileWritterProperties){
        this.DESTINATION = fileWritterProperties.getFileSavePath();
        this.BASE_NAME = fileWritterProperties.getFileBaseName();
        this.HEADER = fileWritterProperties.getHeader();
    }

    public void writeFileAsText(Article[] array) throws IOException {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH:mm:ss_");
        LocalDateTime todaysDate = LocalDateTime.now();

        final String FILE_NAME = dateTimeFormatter.format(todaysDate) + fileWritterProperties.getFileBaseName();

        BufferedWriter txtWriter = new BufferedWriter(new FileWriter(DESTINATION + FILE_NAME + ".txt"));
        txtWriter.write(HEADER);

        for (Article article : array) {
            txtWriter.newLine();
            txtWriter.append(article.toString());
        }
        txtWriter.close();

        log.info("Text file created successfully. Number of uploaded articles = " + array.length);
        log.info("File name: " + FILE_NAME);
        log.info("Check output Folder!");
    }

    public void writeAsCSV(Article[] array) throws IOException{

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH:mm:ss_");
        LocalDateTime todaysDate = LocalDateTime.now();

        final String FILE_NAME = dateTimeFormatter.format(todaysDate) + fileWritterProperties.getFileBaseName();

        CSVWriter csvWriter = new CSVWriter(new FileWriter(DESTINATION + FILE_NAME + ".csv"));

        String[] headerSplit = HEADER.split(":");
        csvWriter.writeNext(headerSplit);

        for (Article article : array) {
            String[] stringArray = {
                    article.getAuthor(),
                    article.getDescription(),
                    article.getTitle()
            };
            csvWriter.writeNext(stringArray);
        }
        log.info("CSV file created successfully. Number of uploaded articles = " + array.length);
        log.info("File name: " + FILE_NAME);
        log.info("Check output Folder!");
    }

    public void writeAsJSON(Article[] array) throws IOException{

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH:mm:ss_");
        LocalDateTime todaysDate = LocalDateTime.now();

        final String FILE_NAME = dateTimeFormatter.format(todaysDate) + fileWritterProperties.getFileBaseName();

        FileWriter jsonFile = new FileWriter(DESTINATION + FILE_NAME + ".json");

        JSONObject jsonObject = new JSONObject();

        for (Article article: array) {
            jsonObject.put("author", article.getAuthor());
            jsonObject.put("title", article.getTitle());
            jsonObject.put("description", article.getDescription());
            jsonFile.append(jsonObject.toJSONString());
            jsonFile.write(System.lineSeparator());
        }
        jsonFile.close();

        log.info("JSON file created successfully. Number of uploaded articles = " + array.length);
        log.info("File name: " + FILE_NAME);
        log.info("Check output Folder!");
     }

}
