package ru.otuslessonspringboot.service;

public interface AnswerCounter {
    void setRight();
    void setWrong();
    String getResult();
    void resetCount();
}
