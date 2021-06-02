package com.webservices.newsapi.consumer.io;

import com.webservices.newsapi.consumer.dto.NewsApiResponseDTO;
import com.webservices.newsapi.consumer.model.Article;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class HTTPConnectionHandler {

    private static final Logger log = LoggerFactory.getLogger(HTTPConnectionHandler.class);

    static RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    HTTPComponenetBuilder httpComponenetBuilder;

    public Article[] getArticlesPage(String queriedPhrase, String language) {

        final String url = httpComponenetBuilder.buildURL(queriedPhrase, language);

        ResponseEntity<NewsApiResponseDTO> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                httpComponenetBuilder.getHttpEntity(),
                NewsApiResponseDTO.class);

        Article[] articles = modelMapper.map(response.getBody().getArticles(), Article[].class);

        if (response.getStatusCode().equals(HttpStatus.OK)){
            log.info("Retrived one page article array from newsapi.org");
            log.info("URL = " + url);
        }

        return articles;

    }
}
