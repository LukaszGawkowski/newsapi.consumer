package com.webserivces.newsapi.consumer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleSourceDTO {

    private String id;
    private String name;
}
