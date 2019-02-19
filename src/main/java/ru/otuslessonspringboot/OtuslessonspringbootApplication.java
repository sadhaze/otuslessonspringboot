package ru.otuslessonspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import ru.otuslessonspringboot.config.YamlProps;
import ru.otuslessonspringboot.service.Quiz;

@SpringBootApplication
@EnableConfigurationProperties(YamlProps.class)
public class OtuslessonspringbootApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OtuslessonspringbootApplication.class, args);
        context.getBean(Quiz.class).startQuiz();
    }
}
