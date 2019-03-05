package ru.otuslessonspringboot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import ru.otuslessonspringboot.config.YamlProps;

import java.io.ByteArrayInputStream;
import java.util.Locale;

@SpringBootTest(properties = {
        InteractiveShellApplicationRunner.SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner.SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
@DisplayName("Тест викторины")
class QuizTest {
    @SpyBean
    private YamlProps props;

    @Autowired
    private CsvQuestionReaderDao fileReader;

    @Autowired
    private Quiz quizService;

    @BeforeEach
    void set(){
        props.setLocale(new Locale("en", "EN"));
        fileReader.readFile("quizDatafile_en_EN.csv");
    }

    @Test
    @DisplayName("Тест когда номер вопроса меньше меньше или равен нулю")
    void AuthNoQuestionunderFlowTest() {
        Assertions.assertEquals("This questions doest exist!", quizService.getQuestion(-1));
    }

    @Test
    @DisplayName("Тест когда номер вопроса меньше больше пяти")
    void AuthNoQuestionOverFlowTest() {
        Assertions.assertEquals("This questions doest exist!", quizService.getQuestion(5));
    }

    @Test
    @DisplayName("Тест на некорректный ответ")
    void AuthFailedTest() {
        System.setIn(new ByteArrayInputStream("Five\n".getBytes()));
        Assertions.assertEquals("Wrong answer! Get lucky in next time!", quizService.getQuestion(0));
    }

    @Test
    @DisplayName("Тест на некорректный ответ")
    void AuthSuccessTest() {
        System.setIn(new ByteArrayInputStream("Five\n".getBytes()));
        Assertions.assertEquals("Bingo!", quizService.getQuestion(4));
    }
}
