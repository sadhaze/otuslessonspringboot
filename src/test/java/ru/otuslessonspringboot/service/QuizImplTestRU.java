package ru.otuslessonspringboot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.io.ByteArrayInputStream;
import java.util.Locale;

@RunWith(MockitoJUnitRunner.class)
@DisplayName("Тест викторины русский")
class QuizImplTestRU {
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("messages/messages");
        ms.setDefaultEncoding("Windows-1251");
        return ms;
    }

    private MessageSource messageSource = messageSource();

    @Mock
    private AnswerCounterBundleImpl counter;

    private CsvQuestionReaderDaoImpl fileReader = new CsvQuestionReaderDaoImpl();

    @Mock
    private GreetingBundleImpl greetingImpl;

    private Quiz quizServiceRU;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        quizServiceRU = new QuizBundleImpl(counter, fileReader, greetingImpl, messageSource, new Locale("ru", "RU"));
    }

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
