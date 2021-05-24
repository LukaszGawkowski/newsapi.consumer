package com.webserivces.newsapi.consumer;

import com.webserivces.newsapi.consumer.client.NewsAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	NewsAPIClient newsAPIClient;

	@Bean
	ApplicationRunner applicationRunner(NewsAPIClient newsAPIClient){
		return args -> {

		newsAPIClient.getArticles("business", "pl");

		newsAPIClient.createFile(newsAPIClient.getArticles("business", "pl"), "path");

		};
	}
}
