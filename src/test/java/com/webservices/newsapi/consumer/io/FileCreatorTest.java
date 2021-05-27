package com.webservices.newsapi.consumer.io;

import com.webservices.newsapi.consumer.properties.TestSpecificProperties;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


public class FileCreatorTest {

    @Mock
    private FileCreator fileCreator;

    @Autowired
    TestSpecificProperties testSpecificProperties;

    @Test
    public void testProvideArticlesDTOArray_returnsNewFile() throws IOException {

//        ArticlesDTO[] array = new ArticlesDTO[3];
//        array[0] = new ArticlesDTO("author0", "description0", "title0");
//        array[1] = new ArticlesDTO("author1", "description1", "title1");
//        array[2] = new ArticlesDTO("author2", "description2", "title2");
//
//        fileWritter.writeFile(array);

    }



}
