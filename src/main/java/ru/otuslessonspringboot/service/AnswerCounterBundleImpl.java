package ru.otuslessonspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service("Answer counter bundle service")
public class AnswerCounterBundleImpl implements AnswerCounter {
    private Locale locale;
    private MessageSource messageSource;

    private Integer right = 0;
    private Integer wrong = 0;

    @Autowired
    public AnswerCounterBundleImpl(Locale locale, MessageSource messageSource){
        this.locale = locale;
        this.messageSource = messageSource;
    }

    public void setRight(){
        right++;
    }

    public void setWrong(){
        wrong++;
    }

    public String getResult(){

        return messageSource.getMessage(
                "counter.result",
                new String[] {right.toString(), wrong.toString()},
                locale);
    }

    public void resetCount(){
        this.right = 0;
        this.wrong = 0;
    }
}
