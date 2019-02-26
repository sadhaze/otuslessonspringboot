package ru.otuslessonspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service("Greeting bundle service")
public class GreetingBundleImpl implements Greeting {
    private LocalMessage localMessage;

    @Autowired
    public GreetingBundleImpl(LocalMessage localMessage){
        this.localMessage = localMessage;
    }

    public String getGreeting(){
        Scanner in = new Scanner(System.in);
        System.out.println(localMessage.getMessage("greeting.fname"));
        String fname = in.nextLine();
        System.out.println(localMessage.getMessage("greeting.lname"));
        String lname = in.nextLine();
        return localMessage.getMessage("greeting.hello", new String[]{lname, fname});
    }
}
