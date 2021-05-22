package com.webserivces.newsapi.consumer.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "api")
public class NewsAPIconfig {

    private String baseUrl;
    private String apiKey;
    private String endpoint;
    private Map<String, String> parameters;

}


