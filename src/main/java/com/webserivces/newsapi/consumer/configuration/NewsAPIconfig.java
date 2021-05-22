package com.webserivces.newsapi.consumer.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "api.url")
@Data
@Validated
public class NewsAPIconfig {

    //TODO check how to handle validation exeptions. They appear to not work correctly

    @NotEmpty(message = "Host name is empty. Check application.properties file and fill it up!")
    private String host;

    @NotEmpty(message = "Version of NewsAPI not specified. Check application.properties file and fill it up!")
    private String version;

    @NotEmpty(message = "ApiKey for NewsAPI not given. Check application.properties file and fill it up!")
    private String apiKey;

    @NotEmpty(message = "Endpoint of NewsAPI not specified. Check application.properties file and fill it up!")
    private String endpoint;

//    @NotEmpty(message = "No request parameters provided. Check application.properties file and fill it up!")
    private Map<String,String> parameters;

}


