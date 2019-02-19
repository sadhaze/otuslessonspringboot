package ru.otuslessonspringboot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.io.ByteArrayInputStream;
import java.util.Locale;

@DisplayName("Тест приветствия")
class GreetingImplTest {
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("messages/messages");
        ms.setDefaultEncoding("Windows-1251");
        return ms;
    }

    private MessageSource messageSource = messageSource();

    private Greeting greetingServiceEn = new GreetingBundleImpl(new Locale("en", "EN"), messageSource);

    @Test
    @DisplayName("Тест приветствия english")
    void greetingTest_En(){
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("Hello, Яфамилия Яимя!", greetingServiceEn.getGreeting());
    }

    private Greeting greetingServiceRu = new GreetingBundleImpl(new Locale("ru", "RU"), messageSource);

    @Test
    @DisplayName("Тест приветствия русский")
    void greetingTest_Ru(){
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ, Яфамилия Яимя!", greetingServiceRu.getGreeting());
    }
}
