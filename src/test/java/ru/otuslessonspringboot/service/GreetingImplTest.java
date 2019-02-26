package ru.otuslessonspringboot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import ru.otuslessonspringboot.config.YamlProps;

import java.io.ByteArrayInputStream;
import java.util.Locale;

@SpringBootTest
@DisplayName("Тест приветствия")
class GreetingImplTest {
    @SpyBean
    private YamlProps props;

    @Autowired
    private Greeting greetingService;

    @Test
    @DisplayName("Тест приветствия english")
    void greetingTest_En(){
        props.setLocale(new Locale("en", "EN"));
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("Hello, Яфамилия Яимя!", greetingService.getGreeting());
    }

    @Test
    @DisplayName("Тест приветствия русский")
    void greetingTest_Ru(){
        props.setLocale(new Locale("ru", "RU"));
        System.setIn(new ByteArrayInputStream("Яимя\nЯфамилия\n".getBytes()));
        Assertions.assertEquals("пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ, Яфамилия Яимя!", greetingService.getGreeting());
    }
}
