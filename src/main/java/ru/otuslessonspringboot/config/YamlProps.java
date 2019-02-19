package ru.otuslessonspringboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class YamlProps {
    private String country;
    private String language;
    private String messageSourceBasename;
    private String messageSourceEncoding;

    public String getCountry(){
        return this.country;
    }

    public String getLanguage(){
        return this.language;
    }

    public String getMessageSourceBasename(){
        return this.messageSourceBasename;
    }

    public String getMessageSourceEncoding(){
        return this.messageSourceEncoding;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public void setMessageSourceBasename(String messageSourceBasename){
        this.messageSourceBasename = messageSourceBasename;
    }

    public void setMessageSourceEncoding(String messageSourceEncoding){
        this.messageSourceEncoding = messageSourceEncoding;
    }


}