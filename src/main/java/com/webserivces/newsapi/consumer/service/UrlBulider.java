package com.webserivces.newsapi.consumer.service;

import com.webserivces.newsapi.consumer.configuration.NewsAPIconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class UrlBulider {

    @Autowired
    NewsAPIconfig apiConfig;


//    public UrlBulider getUrl(ap){
//        UriComponents uriComponents = UriComponentsBuilder.newInstance()
//                .scheme("http")
//                .host(apIconfig.toString())
//                .path("").build().encode()
//    }
}
