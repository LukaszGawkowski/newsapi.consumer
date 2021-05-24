package com.webservices.newsapi.consumer.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsApiResponseDTO {

    private String status;
    private long totalResults;
    private String code;
    private String message;
    private ArticlesDTO[] articles;

}
