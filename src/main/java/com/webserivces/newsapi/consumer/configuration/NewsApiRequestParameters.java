package com.webserivces.newsapi.consumer.configuration;

import lombok.Data;

//@Data
public class NewsApiRequestParameters {

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
