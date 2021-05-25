package com.webservices.newsapi.consumer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticlesDTO {

    private String title;
    private String description;
    private String author;

}
