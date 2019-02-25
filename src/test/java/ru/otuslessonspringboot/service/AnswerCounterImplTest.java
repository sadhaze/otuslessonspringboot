package ru.otuslessonspringboot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

@SpringBootTest
@DisplayName("Тест счетчика ответов")
class AnswerCounterImplTest {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private AnswerCounterBundleImpl answerCounterServiceEn;

    @Autowired
    private AnswerCounterBundleImpl answerCounterServiceRu;

    @Test
    @DisplayName("Тест счетчика ответов english")
    void AuthSuccessTest_En() {
        answerCounterServiceEn.resetCount();
        answerCounterServiceEn.setRight();
        answerCounterServiceEn.setWrong();
        answerCounterServiceEn.setRight();
        answerCounterServiceEn.setWrong();
        answerCounterServiceEn.setRight();

        Assertions.assertEquals("Your score: 3 right and 2 wrong answers. Congratulations!", answerCounterServiceEn.getResult());
    }

    @Test
    @DisplayName("Тест счетчика ответов русский")
    void AuthSuccessTest_Rn() {
        answerCounterServiceRu.resetCount();
        answerCounterServiceRu.setRight();
        answerCounterServiceRu.setWrong();
        answerCounterServiceRu.setRight();
        answerCounterServiceRu.setWrong();
        answerCounterServiceRu.setRight();

        Assertions.assertEquals("пїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ: 3 пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅ 2 пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ. пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ!", answerCounterServiceRu.getResult());
    }
}
