package ru.otuslessonspringboot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import ru.otuslessonspringboot.config.YamlProps;

import java.util.Locale;

@SpringBootTest
@DisplayName("Тест счетчика ответов")
class AnswerCounterImplTest {
    @SpyBean
    private YamlProps props;

    @Autowired
    private AnswerCounter answerCounterService;

    @Test
    @DisplayName("Тест счетчика ответов english")
    void AuthSuccessTest_En() {
        props.setLocale(new Locale("en", "EN"));
        answerCounterService.resetCount();
        answerCounterService.setRight();
        answerCounterService.setWrong();
        answerCounterService.setRight();
        answerCounterService.setWrong();
        answerCounterService.setRight();

        Assertions.assertEquals("Your score: 3 right and 2 wrong answers. Congratulations!", answerCounterService.getResult());
    }

    @Test
    @DisplayName("Тест счетчика ответов русский")
    void AuthSuccessTest_Rn() {
        props.setLocale(new Locale("ru", "RU"));
        answerCounterService.resetCount();
        answerCounterService.setRight();
        answerCounterService.setWrong();
        answerCounterService.setRight();
        answerCounterService.setWrong();
        answerCounterService.setRight();

        Assertions.assertEquals("пїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ: 3 пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅ 2 пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ. пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ!", answerCounterService.getResult());
    }
}
