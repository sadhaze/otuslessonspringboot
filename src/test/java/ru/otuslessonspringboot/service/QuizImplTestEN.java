package ru.otuslessonspringboot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import ru.otuslessonspringboot.config.YamlProps;

import java.io.ByteArrayInputStream;
import java.util.Locale;

@SpringBootTest
@DisplayName("Тест викторины english")
class QuizImplTestEN {
    @MockBean
    private AnswerCounter counter;

    @SpyBean
    private YamlProps props;

    @Autowired
    private CsvQuestionReaderDao fileReader;

    @Autowired
    private Greeting greeting;

    @Autowired
    private Quiz quizService;

    @BeforeEach
    void setTest(){
        props.setLocale(new Locale("en", "EN"));
        fileReader.readFile("quizDatafile_en_EN.csv");
    }

    @Test
    @DisplayName("Тест когда номер вопроса меньше меньше или равен нулю")
    void AuthNoQuestionTest_1_EN() {
        Assertions.assertEquals("This questions doest exist!", quizService.getQuestion(-1));
    }

    @Test
    @DisplayName("Тест когда номер вопроса меньше больше пяти")
    void AuthNoQuestionTest_2_EN() {
        Assertions.assertEquals("This questions doest exist!", quizService.getQuestion(5));
    }

    @Test
    @DisplayName("Тест на некорректный ответ")
    void AuthFailedTest_1_EN() {
        System.setIn(new ByteArrayInputStream("Five\n".getBytes()));
        Assertions.assertEquals("Wrong answer! Get lucky in next time!", quizService.getQuestion(0));
    }

    @Test
    @DisplayName("Тест на некорректный ответ")
    void AuthSuccessTest_1_EN() {
        System.setIn(new ByteArrayInputStream("Five\n".getBytes()));
        Assertions.assertEquals("Bingo!", quizService.getQuestion(4));
    }
}
