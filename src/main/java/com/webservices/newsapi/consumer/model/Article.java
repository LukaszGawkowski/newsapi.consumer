package com.webservices.newsapi.consumer.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private String title;
    private String description;
    private String author;

    @Override
    public String toString() {
        return author + ":" + description + ":"  + title;
    }

}
