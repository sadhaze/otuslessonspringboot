package ru.otuslessonspringboot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.io.ByteArrayInputStream;

@SpringBootTest
@DisplayName("Тест приветствия")
class GreetingImplTest {
    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Greeting greetingServiceEn;

    @Autowired
    private Greeting greetingServiceRu;

    @Test
    @DisplayName("Тест приветствия english")
    void greetingTest_En(){
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("Hello, Яфамилия Яимя!", greetingServiceEn.getGreeting());
    }

    @Test
    @DisplayName("Тест приветствия русский")
    void greetingTest_Ru(){
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ, Яфамилия Яимя!", greetingServiceRu.getGreeting());
    }
}
