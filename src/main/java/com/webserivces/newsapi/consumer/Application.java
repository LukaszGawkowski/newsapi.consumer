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

	@Bean
	ApplicationRunner applicationRunner(){
		return args -> {

			NewsAPIClient newsAPIClient = new NewsAPIClient();

		newsAPIClient.getEverythingArticlesOnePage("business", "pl",1,100);
//		newsAPIClient.getEverythingAllArticles("business","pl");
		};
	}

	//TODO Move api-key, version, endpoint, base url to be injected from properties file
	//TODO Try to move builder to service class
	//TODO Try to move csv Creator to the service class
	//TODO Try to move paging to external service class
	//TODO Maybe figure out how to move query parameters so they wont look so ugly in urlbuilder
	//TODO Since this request will be based on collecting multiple resposnes (pagination) -> for avoiding request rate limit use Thread.sleep()
}
