package com.webserivces.newsapi.consumer.client;

import com.webserivces.newsapi.consumer.Application;
import com.webserivces.newsapi.consumer.dto.response.ArticlesDTO;
import com.webserivces.newsapi.consumer.dto.response.NewsApiResponseDTO;
import com.webserivces.newsapi.consumer.properties.NewsAPIproperties;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor
public class NewsAPIClient {

//    @Autowired
//    NewsAPIproperties properties;

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    // for loop -> number of results / page size and, number of result < pagesize -> last page

    //TODO MOVE whole http conectivity staff and URL builder to HttpConnectionHandle Class so it will be cleaner here
    //TODO Add private static to all methods -> I must read more about bean creation,

    static RestTemplate restTemplate = new RestTemplate();

    public ArticlesDTO[] getEverythingArticlesOnePage(String queriedPhrase, String language, int pageNumber, int pageSize) throws IOException {

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

    //TODO File Writer Method

//    public void writeFile(ArticlesDTO[] articles) throws IOException {
//        File outPutFile = new File("/TurboFile");
//        try (PrintWriter pw = new PrintWriter(outPutFile)) {
//            Arrays.stream(articles)
//                    .forEach(pw::println);
//        }
//
//    }





    public void getEverythingAllArticles(String queriedPhrase, String language) throws Exception{

        //Just relised that dev account on APINews wont allow pagination cuz i am limited to get only 1st page of the response

//        long numberOfPages;
//        int pageSize = 100;
//        int startPage = 1;
//
//
//        do {
//
//                ResponseEntity<NewsApiResponseDTO> onePageResponse = getEverythingArticlesOnePage(queriedPhrase, language, startPage, pageSize);
//
//                long numberOfResults = onePageResponse.getBody().getTotalResults();
//
//                log.info("Number of results " + numberOfResults);
//
//                numberOfPages = numberOfResults / pageSize;
//
//                log.info("calculated number of pages " + numberOfPages);
//
//                startPage++;
//
//                log.info("Number of page " + startPage);
//
//                Thread.sleep(10000); // -> Check if by any miricle i can work around request rate limit
//
//
//        }
//        while (startPage <= numberOfPages + 1);
//
//
    }

//    public ArticlesDTO[] collectAllIntoOneArray(){
//        ArticlesDTO[] x;
//
//        return x;
//    }

}
