package com.webserivces.newsapi.consumer.client;

import com.webserivces.newsapi.consumer.Application;
import com.webserivces.newsapi.consumer.dto.response.ArticlesDTO;
import com.webserivces.newsapi.consumer.dto.response.NewsApiResponseDTO;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Arrays;

@NoArgsConstructor
public class NewsAPIClient {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    // for loop -> number of results / page size and, number of result < pagesize -> last page

    //TODO MOVE whole http conectivity staff and URL builder to HttpConnectionHandle Class so it will be cleaner here
    //TODO Add private static to all methods -> I must read more about bean creation,

    static RestTemplate restTemplate = new RestTemplate();

    public ArticlesDTO[] getEverythingArticlesOnePage(String queriedPhrase, String language, int pageNumber, int pageSize) {

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

        log.info("Request URL " + url);;

        ResponseEntity<NewsApiResponseDTO> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, NewsApiResponseDTO.class);

        ArticlesDTO[] result = response.getBody().getArticles();

        for (ArticlesDTO article : result) {

            System.out.println(article.toString());

        }

        return result;

    }

}
