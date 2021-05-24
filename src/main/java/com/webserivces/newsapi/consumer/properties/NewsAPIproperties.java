package com.webserivces.newsapi.consumer.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Configuration
@ConfigurationProperties(prefix = "api.url")
@Data
@Validated
public class NewsAPIproperties {

    //TODO check how to handle validation exeptions. They appear to not work correctly

    @NotEmpty(message = "Host name is empty. Check application.properties file and fill it up!")
    private String host;

    @NotEmpty(message = "Version of NewsAPI not specified. Check application.properties file and fill it up!")
    private String version;

    @NotEmpty(message = "ApiKey for NewsAPI not given. Check application.properties file and fill it up!")
    private String apiKey;

    @NotEmpty(message = "Endpoint of NewsAPI not specified. Check application.properties file and fill it up!")
    private String endpoint;

    @NotEmpty(message = "Page parameter of NewsAPI not specified. Check application.properties file and fill it up!")
    private String page;

    @NotEmpty(message = "PageSize parameter of NewsAPI not specified. Check application.properties file and fill it up!")
    private String pageSize;

}


