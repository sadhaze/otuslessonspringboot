package ru.otuslessonspringboot.service;

public interface Quiz {
    void startQuiz();
    String getQuestion(int questionNumber);
}
