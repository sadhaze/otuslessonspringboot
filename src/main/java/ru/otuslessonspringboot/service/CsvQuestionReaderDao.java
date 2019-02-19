package ru.otuslessonspringboot.service;

public interface CsvQuestionReaderDao {
    String getAnswer(int lineNumber);
    String getQuestion(int lineNumber);
    void readFile(String fileName);
    int questionValidation(int questionNumber);
}
