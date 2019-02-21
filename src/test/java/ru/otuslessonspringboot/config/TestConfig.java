package ru.otuslessonspringboot.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    AnswerCounterImplTest answerCounterImplTest(){
        return new AnswerCounterImplTest();
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
