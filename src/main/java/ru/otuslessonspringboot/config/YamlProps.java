package ru.otuslessonspringboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@ConfigurationProperties
public class YamlProps {
    private String country;
    private String language;
    private Locale locale;
    private String messageSourceBasename;
    private String messageSourceEncoding;
    private String quizDatafileName;

    public String getCountry(){
        return this.country;
    }

    public String getLanguage(){
        return this.language;
    }

    public Locale getLocale(){
        return this.locale;
    }

    public String getMessageSourceBasename(){
        return this.messageSourceBasename;
    }

    public String getMessageSourceEncoding(){
        return this.messageSourceEncoding;
    }

    public String getQuizDatafileName(){
        return this.quizDatafileName;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public void setLocale(){
        this.locale = new Locale(this.language, this.country);
    }

    public void setLocale(Locale locale){
        this.locale = locale;
    }

    public void setMessageSourceBasename(String messageSourceBasename){
        this.messageSourceBasename = messageSourceBasename;
    }

    public void setMessageSourceEncoding(String messageSourceEncoding){
        this.messageSourceEncoding = messageSourceEncoding;
    }

    public void setQuizDatafileName(String quizDatafileName){
        this.quizDatafileName = quizDatafileName;
    }


}