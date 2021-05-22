package com.webserivces.newsapi.consumer.configuration;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.util.Optionals;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Data
//@Validated
public class NewsApiRequestParameters {

    @NonNull
    private String queriedPhrase;
    private String qInTitle;
    private String sources;
    private String domains;
    private String excludeDomains;
    private String from;
    private String to;
    private String language;
    private String sortBy;
    private String pageSize;
    private String page;
}
