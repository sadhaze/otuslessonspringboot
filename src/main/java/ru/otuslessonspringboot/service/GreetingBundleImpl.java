package ru.otuslessonspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

@Service("Greeting bundle service")
public class GreetingBundleImpl implements Greeting {
    private Locale locale;
    private MessageSource messageSource;

    @Autowired
    public GreetingBundleImpl(Locale locale, MessageSource messageSource){
        this.locale = locale;
        this.messageSource = messageSource;
    }

    public String getGreeting(){
        Scanner in = new Scanner(System.in);

        System.out.println(
                messageSource.getMessage(
                        "greeting.fname",
                        new String[] {""},
                        locale)
        );

        String fname = in.nextLine();

        System.out.println(
                messageSource.getMessage(
                        "greeting.lname",
                        new String[] {""},
                        locale)
        );

        String lname = in.nextLine();

        return messageSource.getMessage(
                "greeting.hello",
                new String[] {lname, fname},
                locale);
    }
}
