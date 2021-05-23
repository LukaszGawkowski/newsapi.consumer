package com.webserivces.newsapi.consumer.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticlesDTO {

    private String title;
    private String description;
    private String author;

//    These are not neccesery right now -> may find use for them later

//    private String urlToImage;
//    private String url;
//    private Map<String, String> source;
//    private String publishedAt;
//    private String content;
}
