package com.webservices.newsapi.consumer.io;

import com.webservices.newsapi.consumer.dto.NewsApiResponseDTO;
import com.webservices.newsapi.consumer.model.Article;
import com.webservices.newsapi.consumer.properties.NewsAPIproperties;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@Component
public class HTTPConnectionHandler {

    private static final Logger log = LoggerFactory.getLogger(HTTPConnectionHandler.class);

    static RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    NewsAPIproperties newsAPIproperties;

    public Article[] getArticlesPage(String queriedPhrase, String language) {

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

        Article[] articles = modelMapper.map(response.getBody().getArticles(), Article[].class);

        if (response.getStatusCode().equals(HttpStatus.OK)){
            log.info("Retrived one page article array from newsapi.org");
            log.info("URL = " + url);
        }

        return articles;

    }
}
