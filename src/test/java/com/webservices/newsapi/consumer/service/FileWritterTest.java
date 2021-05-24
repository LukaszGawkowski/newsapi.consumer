package com.webservices.newsapi.consumer.service;

import com.webservices.newsapi.consumer.dto.response.ArticlesDTO;
import com.webservices.newsapi.consumer.properties.TestSpecificProperties;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.mockito.Mockito.*;


public class FileWritterTest {

    @Mock
    private FileWritter fileWritter;

    @Autowired
    TestSpecificProperties testSpecificProperties;

    @Test
    public void testProvideArticlesDTOArray_returnsNewFile() throws IOException {

        //TODO -> using @Data annotation on ArticlesDTO may be not good idea since it provides no allargsconstructor neccesery for the test

//        ArticlesDTO[] array = new ArticlesDTO[3];
//        array[0] = new ArticlesDTO("author0", "description0", "title0");
//        array[1] = new ArticlesDTO("author1", "description1", "title1");
//        array[2] = new ArticlesDTO("author2", "description2", "title2");
//
//        fileWritter.writeFile(array);

    }



}
