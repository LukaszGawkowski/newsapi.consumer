package com.webservices.newsapi.consumer.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
@ConfigurationProperties(prefix = "test")
@Data
public class TestSpecificProperties {

    String fileBaseName;
    String fileSavePath;
    String header;

}
