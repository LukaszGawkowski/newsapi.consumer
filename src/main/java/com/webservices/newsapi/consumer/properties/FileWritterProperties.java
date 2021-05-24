package com.webservices.newsapi.consumer.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "writter")
@Data
public class FileWritterProperties {

    String fileBaseName;
    String fileSavePath;
    String header;
}
