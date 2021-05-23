package com.webserivces.newsapi.consumer.client;

import com.webserivces.newsapi.consumer.Application;
import com.webserivces.newsapi.consumer.config.NewsAPIproperties;
import com.webserivces.newsapi.consumer.dto.response.ArticlesDTO;
import com.webserivces.newsapi.consumer.dto.response.NewsApiResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.stream.Stream;


public class NewsAPIClient {

//    @Autowired
//    NewsAPIproperties properties;
//
//    private static final Logger log = LoggerFactory.getLogger(Application.class);

    // for loop -> number of results / page size and, number of result < pagesize -> last page

    //TODO MOVE MAJOR App logic to Client!
    //TODO Add private to all methods

    static RestTemplate restTemplate = new RestTemplate();

    public static ArticlesDTO[] getEverythingOnePage(String queriedPhrase, String language, int pageNumber, int pageSize){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-api-key", "7daf714e1e234518a60167fe11956364");
        httpHeaders.setAccept((Arrays.asList(MediaType.APPLICATION_JSON)));
        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);

        String url = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("newsapi.org")
                .pathSegment("v2", "everything")
                .queryParam("q", queriedPhrase)
                .queryParam("language", language)
                .queryParam("page", pageNumber)
                .queryParam("pageSize", pageSize)
                .build()
                .encode()
                .toUriString();

        System.out.println(url);

        ResponseEntity<NewsApiResponseDTO> result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, NewsApiResponseDTO.class);

        ArticlesDTO[] check = result.getBody().getArticles();

        Stream<ArticlesDTO> stram1 = Arrays.stream(check);
        stram1.forEach(element -> System.out.println(element));

        System.out.println(check.length);


        return result.getBody().getArticles();
    }

    private static ArticlesDTO[] extractArticleFromResponse(ResponseEntity<NewsApiResponseDTO> result){
        return result.getBody().getArticles();
    }

    private static void getEverythingAllArticles(String queriedPhrase, String language, int pageSize){



    }
}
