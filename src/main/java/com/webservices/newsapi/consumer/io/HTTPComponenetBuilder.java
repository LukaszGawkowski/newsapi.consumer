package com.webservices.newsapi.consumer.io;


import com.webservices.newsapi.consumer.properties.NewsAPIproperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@Component
public class HTTPComponenetBuilder {

    private static final Logger log = LoggerFactory.getLogger(HTTPConnectionHandler.class);

    @Autowired
    NewsAPIproperties newsAPIproperties;


    public HttpEntity getHttpEntity(){

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-api-key", newsAPIproperties.getApiKey());
        httpHeaders.setAccept((Arrays.asList(MediaType.APPLICATION_JSON)));

        log.info("HttpEntity with provided api-key in Header created!");

        return new HttpEntity<>(httpHeaders);
    }

    public String buildURL(String queriedPhrase, String language){
        String url = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(newsAPIproperties.getHost())
                .pathSegment(newsAPIproperties.getVersion(), newsAPIproperties.getEndpoint())
                .queryParam("page", 1)
                .queryParam("pageSize", 100)
                .queryParam("q", queriedPhrase)
                .queryParam("language", language)
                .build()
                .encode()
                .toUriString();

        log.info("URL with provided params created!");

        return url;
    }


}
