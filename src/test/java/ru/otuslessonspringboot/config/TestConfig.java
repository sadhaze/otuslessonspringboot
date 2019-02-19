package ru.otuslessonspringboot.service;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class TestConfig {
    @Bean
    AnswerCounterImplTest answerCounterImplTest(){
        return new AnswerCounterImplTest();
    }

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("massages/messages");
        ms.setDefaultEncoding("Windows-1251");
        return ms;
    }

    @Bean
    GreetingImplTest greetingImplTest(){
        return new GreetingImplTest();
    }

    @Bean
    QuizImplTestRU quizImplTestRU(){
        return new QuizImplTestRU();
    }

    @Bean
    QuizImplTestEN quizImplTestEN(){
        return new QuizImplTestEN();
    }
}
