package com.webserivces.newsapi.consumer;

import com.webserivces.newsapi.consumer.dto.NewsApiResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String response = restTemplate.getForObject("https://newsapi.org/v2/everything?q=Apple&from=2021-05-21&sortBy=popularity&apiKey=7daf714e1e234518a60167fe11956364", String.class);

			System.out.println(response);

			log.info(response);
		};

	}
}
