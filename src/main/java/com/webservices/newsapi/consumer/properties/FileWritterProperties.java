package com.webservices.newsapi.consumer.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Configuration
@ConfigurationProperties(prefix = "writter")
@Data
@Validated
public class FileWritterProperties {


    @NotEmpty(message = "Base file name not specified. Check application.properties file and fill it up!")
    private String fileBaseName;

    @NotEmpty(message = "File path destination not specified. Check application.properties file and fill it up!")
    private String fileSavePath;

    private String header;
}
