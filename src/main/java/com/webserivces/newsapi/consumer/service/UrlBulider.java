package com.webserivces.newsapi.consumer.service;

import com.webserivces.newsapi.consumer.configuration.NewsAPIconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

public class UrlBulider {


//    public UrlBulider getUrl(NewsAPIconfig apiConfig) {
//        return UriComponentsBuilder.newInstance()
//                .scheme("http")
//                .host(apiConfig.getHost())
//                .pathSegment(apiConfig.getVersion(),apiConfig.getEndpoint())
//                .queryParamIfPresent("", apiConfig.getParameters().getQueriedPhrase())
//                .queryParamIfPresent("", apiConfig.getParameters().getQInTitle())
//                .queryParamIfPresent("", apiConfig.getParameters().getSources())
//                .queryParamIfPresent("", apiConfig.getParameters().getDomains())
//                .queryParamIfPresent("", apiConfig.getParameters().getExcludeDomains())
//                .queryParamIfPresent("", apiConfig.getParameters().getFrom())
//                .queryParamIfPresent("", apiConfig.getParameters().getTo())
//                .queryParamIfPresent("", apiConfig.getParameters().getLanguage())
//                .queryParamIfPresent("", apiConfig.getParameters().getSortBy())
//                .queryParamIfPresent("", apiConfig.getParameters().getPageSize())
//                .queryParamIfPresent("", apiConfig.getParameters().getPage())
//                .quer
//
////        UriComponents uriComponents = UriComponentsBuilder.newInstance()
////                .scheme("http")
////                .host(apiConfig)
////                .path("").build().encode()
//    }
}
