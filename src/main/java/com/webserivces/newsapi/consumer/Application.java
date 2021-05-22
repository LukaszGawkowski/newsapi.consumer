package com.webserivces.newsapi.consumer;

import com.webserivces.newsapi.consumer.configuration.NewsAPIconfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletOutputStream;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Autowired
	NewsAPIconfig apIconfig;

	// will need to use Thread.sleep() if there will be api call limit
	// api client with getEverything method
	// will return one page
	// for loop -> number of results / page size and, number of result < pagesize -> last page

	@Bean
	ApplicationRunner applicationRunner(RestTemplate restTemplate){
		return args -> {


			ResponseEntity<String> response = restTemplate.getForEntity(
					"https://newsapi.org/v2/everything?q=Apple&from=2021-05-21&sortBy=popularity&apiKey=7daf714e1e234518a60167fe11956364",
					String.class);


			System.out.println(apIconfig.toString());

			log.info(response.toString());

		};
	}
}
