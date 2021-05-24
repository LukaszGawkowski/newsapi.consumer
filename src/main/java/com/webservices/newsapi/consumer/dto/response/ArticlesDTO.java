package com.webservices.newsapi.consumer.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticlesDTO {

    private String title;
    private String description;
    private String author;

    @Override
    public String toString() {
        return author + ":" + description + ":"  + title;
    }
}
