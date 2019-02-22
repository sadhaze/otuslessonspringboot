package ru.otuslessonspringboot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.MessageSource;
import ru.otuslessonspringboot.config.YamlProps;

import java.io.ByteArrayInputStream;
import java.util.Locale;

@SpringBootTest
@DisplayName("Тест викторины русский")
class QuizImplTestRU {
    @Autowired
    private MessageSource messageSource;

    @MockBean
    private AnswerCounterBundleImpl counter;

    @SpyBean
    private YamlProps props;

    @Autowired
    private CsvQuestionReaderDaoImpl fileReader;

    @Autowired
    private GreetingBundleImpl greetingImpl;

    @Autowired
    private Quiz quizServiceRU;

    @Test
    @DisplayName("Тест когда номер вопроса меньше меньше или равен нулю")
    void AuthNoQuestionTest_1_RU() {
        fileReader.readFile("quizDatafile_ru_RU.csv");
        Assertions.assertEquals("пїЅпїЅпїЅпїЅпїЅпїЅ пїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ!", quizServiceRU.getQuestion(-1));
    }

    @Test
    @DisplayName("Тест когда номер вопроса меньше больше пяти")
    void AuthNoQuestionTest_2_RU() {
        fileReader.readFile("quizDatafile_ru_RU.csv");
        Assertions.assertEquals("пїЅпїЅпїЅпїЅпїЅпїЅ пїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ!", quizServiceRU.getQuestion(5));
    }

    @Test
    @DisplayName("Тест на некорректный ответ")
    void AuthFailedTest_1_RU() {
        fileReader.readFile("quizDatafile_ru_RU.csv");
        System.setIn(new ByteArrayInputStream("ПЯТЬ\n".getBytes()));
        Assertions.assertEquals("пїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅ! пїЅ пїЅпїЅпїЅпїЅпїЅпїЅ пїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅ!", quizServiceRU.getQuestion(0));
    }

    @Test
    @DisplayName("Тест на некорректный ответ")
    void AuthSuccessTest_1_RU() {
        fileReader.readFile("quizDatafile_ru_RU.csv");
        System.setIn(new ByteArrayInputStream("ПЯТЬ\n".getBytes()));
        Assertions.assertEquals("пїЅпїЅпїЅпїЅпїЅ!", quizServiceRU.getQuestion(4));
    }
}
