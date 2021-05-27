package com.webservices.newsapi.consumer;

import com.webservices.newsapi.consumer.enumTypes.FileType;
import com.webservices.newsapi.consumer.model.Article;
import com.webservices.newsapi.consumer.service.ClientServiceImpl;
import org.modelmapper.ModelMapper;
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
	ClientServiceImpl clientServiceImpl;

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	ApplicationRunner applicationRunner(ClientServiceImpl clientServiceImpl){
		return args -> {

			Article[] result = clientServiceImpl.getArticles("business", "pl");
		clientServiceImpl.createFile(result, FileType.TXT);
//		clientServiceImpl.createFile(result, FileType.JSON);
		clientServiceImpl.createFile(result, FileType.CSV);

		};
	}
}
