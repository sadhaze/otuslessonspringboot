package ru.otuslessonspringboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otuslessonspringboot.service.LocalMessage;
import ru.otuslessonspringboot.service.LocalMessageImpl;

@Configuration
public class AppConfig {
    @Bean
    public LocalMessage localMessage(YamlProps props){
        props.setLocale();
        return new LocalMessageImpl(props);
    }
}
