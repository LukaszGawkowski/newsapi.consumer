package com.webserivces.newsapi.consumer;

import com.webserivces.newsapi.consumer.client.NewsAPIClient;
import com.webserivces.newsapi.consumer.dto.response.ArticlesDTO;
import com.webserivces.newsapi.consumer.dto.response.NewsApiResponseDTO;
import com.webserivces.newsapi.consumer.model.CSVArticleModel;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// for loop -> number of results / page size and, number of result < pagesize -> last page

	@Bean
	ApplicationRunner applicationRunner(){
		return args -> {

		getEverythingOnePage("business", "pl", 1, 100);

		};
	}

	static RestTemplate restTemplate = new RestTemplate();


	//TODO Move api-key, version, endpoint, base url to be injected from properties file
	//TODO Try to move builder to service class
	//TODO Try to move csv Creator to the service class
	//TODO Try to move paging to external service class
	//TODO Maybe figure out how to move query parameters so they wont look so ugly in urlbuilder

	private static ArticlesDTO[] getEverythingOnePage(String queriedPhrase, String language, int pageNumber, int pageSize){
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





	//TODO Since this request will be based on collecting multiple resposnes (pagination) -> for avoiding request rate limit use Thread.sleep()


	}




}
