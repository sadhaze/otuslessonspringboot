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
@DisplayName("Тест викторины english")
class QuizImplTestEN {
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

    private Quiz quizServiceEN;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        quizServiceEN = new QuizBundleImpl(counter, fileReader, greetingImpl, messageSource, new Locale("en", "EN"));
    }

    @Test
    @DisplayName("Тест когда номер вопроса меньше меньше или равен нулю")
    void AuthNoQuestionTest_1_EN() {
        fileReader.readFile("quizDatafile_en_EN.csv");
        Assertions.assertEquals("This questions doest exist!", quizServiceEN.getQuestion(-1));
    }

    @Test
    @DisplayName("Тест когда номер вопроса меньше больше пяти")
    void AuthNoQuestionTest_2_EN() {
        fileReader.readFile("quizDatafile_en_EN.csv");
        Assertions.assertEquals("This questions doest exist!", quizServiceEN.getQuestion(5));
    }

    @Test
    @DisplayName("Тест на некорректный ответ")
    void AuthFailedTest_1_EN() {
        fileReader.readFile("quizDatafile_en_EN.csv");
        System.setIn(new ByteArrayInputStream("Five\n".getBytes()));
        Assertions.assertEquals("Wrong answer! Get lucky in next time!", quizServiceEN.getQuestion(0));
    }

    @Test
    @DisplayName("Тест на некорректный ответ")
    void AuthSuccessTest_1_EN() {
        fileReader.readFile("quizDatafile_en_EN.csv");
        System.setIn(new ByteArrayInputStream("Five\n".getBytes()));
        Assertions.assertEquals("Bingo!", quizServiceEN.getQuestion(4));
    }
}
