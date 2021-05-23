package com.webserivces.newsapi.consumer.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleSourceDTO {

    //    These are not neccesery right now -> may find use for them later

//    private String id;
//    private String name;
}
