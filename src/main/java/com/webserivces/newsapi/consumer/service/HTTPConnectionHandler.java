package com.webserivces.newsapi.consumer.service;

import com.webserivces.newsapi.consumer.Application;
import com.webserivces.newsapi.consumer.dto.response.ArticlesDTO;
import com.webserivces.newsapi.consumer.dto.response.NewsApiResponseDTO;
import com.webserivces.newsapi.consumer.properties.NewsAPIproperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@Service
public class HTTPConnectionHandler {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    static RestTemplate restTemplate = new RestTemplate();

    @Autowired
    NewsAPIproperties newsAPIproperties;

    public ArticlesDTO[] getEverythingArticlesOnePage(String queriedPhrase, String language) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-api-key", newsAPIproperties.getApiKey());
        httpHeaders.setAccept((Arrays.asList(MediaType.APPLICATION_JSON)));
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);

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

        ResponseEntity<NewsApiResponseDTO> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, NewsApiResponseDTO.class);

        ArticlesDTO[] result = response.getBody().getArticles();

        for (ArticlesDTO article : result) {
           log.info(article.toString());
        }

        return result;

    }
}
