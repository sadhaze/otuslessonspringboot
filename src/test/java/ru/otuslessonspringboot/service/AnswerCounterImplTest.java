package ru.otuslessonspringboot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@ComponentScan
@DisplayName("Тест счетчика ответов")
class AnswerCounterImplTest {
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("messages/messages");
        ms.setDefaultEncoding("Windows-1251");
        return ms;
    }

    private MessageSource messageSource = messageSource();

    private AnswerCounter answerCounterServiceEn = new AnswerCounterBundleImpl(new Locale("en", "EN"), messageSource);

    @Test
    @DisplayName("Тест счетчика ответов english")
    void AuthSuccessTest_En() {
        answerCounterServiceEn.setRight();
        answerCounterServiceEn.setWrong();
        answerCounterServiceEn.setRight();
        answerCounterServiceEn.setWrong();
        answerCounterServiceEn.setRight();

        Assertions.assertEquals("Your score: 3 right and 2 wrong answers. Congratulations!", answerCounterServiceEn.getResult());
    }

    private AnswerCounter answerCounterServiceRu = new AnswerCounterBundleImpl(new Locale("ru", "RU"), messageSource);

    @Test
    @DisplayName("Тест счетчика ответов русский")
    void AuthSuccessTest_Rn() {
        answerCounterServiceRu.setRight();
        answerCounterServiceRu.setWrong();
        answerCounterServiceRu.setRight();
        answerCounterServiceRu.setWrong();
        answerCounterServiceRu.setRight();

        Assertions.assertEquals("пїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ: 3 пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅ пїЅ 2 пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ. пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ!", answerCounterServiceRu.getResult());
    }
}
