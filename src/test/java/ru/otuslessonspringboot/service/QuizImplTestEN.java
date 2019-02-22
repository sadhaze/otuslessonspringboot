package ru.otuslessonspringboot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.MessageSource;
import ru.otuslessonspringboot.config.YamlProps;

import java.io.ByteArrayInputStream;

@SpringBootTest
@DisplayName("Тест викторины english")
class QuizImplTestEN {
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
    private Quiz quizServiceEN;

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
