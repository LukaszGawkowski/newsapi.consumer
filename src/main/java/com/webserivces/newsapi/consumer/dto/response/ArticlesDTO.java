package com.webserivces.newsapi.consumer.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticlesDTO {

    private String title;
    private String description;
    private String author;


    //TODO -> Remove this when CSV writing will be complete

    @Override
    public String toString() {
        return author + ":" + description + ":" + title;
    }
}
