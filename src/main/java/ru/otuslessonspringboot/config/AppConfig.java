package ru.otuslessonspringboot.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class AppConfig {
    private Locale locale;

    @Bean
    public MessageSource messageSource(YamlProps props){
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename(props.getMessageSourceBasename());
        ms.setDefaultEncoding(props.getMessageSourceEncoding());
        return ms;
    }

    @Bean
    public Locale getLocale(YamlProps props){
        if(locale == null) locale = new Locale(props.getLanguage(), props.getCountry());
        return locale;
    }
}
