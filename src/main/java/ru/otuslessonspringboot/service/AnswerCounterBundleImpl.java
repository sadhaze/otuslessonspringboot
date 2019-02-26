package ru.otuslessonspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Answer counter bundle service")
public class AnswerCounterBundleImpl implements AnswerCounter {
    private LocalMessage localMessage;

    private Integer right = 0;
    private Integer wrong = 0;

    @Autowired
    public AnswerCounterBundleImpl(LocalMessage localMessage){
        this.localMessage = localMessage;
    }

    public void setRight(){
        right++;
    }

    public void setWrong(){
        wrong++;
    }

    public String getResult(){
        return localMessage.getMessage("counter.result", new String[]{right.toString(), wrong.toString()});
    }

    public void resetCount(){
        this.wrong = 0;
        this.right = 0;
    }

    public void resetCount(){
        this.right = 0;
        this.wrong = 0;
    }
}
