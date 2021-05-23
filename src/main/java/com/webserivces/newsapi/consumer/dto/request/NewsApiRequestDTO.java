package com.webserivces.newsapi.consumer.dto.request;

import lombok.Data;

//TODO Figure out if i want to use it

@Data
public class NewsApiRequestDTO {

    private String quriedPhrase;
    private String language;
    private int pageNumber;
    private int pageSize;
}
