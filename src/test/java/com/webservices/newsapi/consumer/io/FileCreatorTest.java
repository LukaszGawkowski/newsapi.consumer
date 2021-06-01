package com.webservices.newsapi.consumer.io;

import com.webservices.newsapi.consumer.properties.TestSpecificProperties;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


public class FileCreatorTest {

//    @Mock
//    private FileCreator fileCreator;
//
//    @Autowired
//    TestSpecificProperties testSpecificProperties;

    @Test
    @DisplayName("Test: Created file exists when fileCreator.writeAs...(...) methods are invoked")
    public void should_fileCreate_when_articlesArrayGiven() throws IOException {

//        ArticlesDTO[] array = new ArticlesDTO[3];
//        array[0] = new ArticlesDTO("author0", "description0", "title0");
//        array[1] = new ArticlesDTO("author1", "description1", "title1");
//        array[2] = new ArticlesDTO("author2", "description2", "title2");
//
//        fileWritter.writeFile(array);

    }


    @Test
    @DisplayName("Test: Created file is JSON when fileCreator.writeAsJSON(...) method is invoked")
    public void should_JSONFileCreate_when_articlesArrayGiven() throws IOException {}

    @Test
    @DisplayName("Test: Created file is CSV when fileCreator.writeAsCSV(...) method is invoked")
    public void should_CSVFileCreate_when_articlesArrayGiven() throws IOException {}

    @Test
    @DisplayName("Test: Created file is TXT when fileCreator.writeAsTXT(...) method is invoked")
    public void should_TXTFileCreate_when_articlesArrayGiven() throws IOException {}

    @Test
    @DisplayName("Test: Created file contains ALL data fields from given articles array when fileCreator.writeAs...(...) methods are invoked")
    public void should_returnAllArrayDataGiven_when_articlesArrayGiven() throws IOException {}

    @Test
    @DisplayName("Test: Throw exception when EMPTY articles array given")
    public void should_throwException_whenEmptyArticlesArrayGiven() throws IOException {}

    @Test
    @DisplayName("Test: Throw exception when WRONG parameters given during fileCreator.writeAs...(...) methods invocation")
    public void should_throwException_whenWrongParametersGiven() throws IOException {}

}
