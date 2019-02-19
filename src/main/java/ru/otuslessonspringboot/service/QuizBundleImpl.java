package ru.otuslessonspringboot.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

@Service("Quiz bundle service")
public class QuizBundleImpl implements Quiz {
    private AnswerCounterBundleImpl counter;
    private CsvQuestionReaderDaoImpl questionReader;
    private GreetingBundleImpl greetingBundleImpl;
    private MessageSource messageSource;
    private Locale locale;

    private Scanner scanner;

    public QuizBundleImpl(AnswerCounterBundleImpl counter, CsvQuestionReaderDaoImpl questionReader, GreetingBundleImpl greetingBundleImpl, MessageSource messageSource, Locale locale){
        this.counter = counter;
        this.questionReader = questionReader;
        this.greetingBundleImpl = greetingBundleImpl;
        this.messageSource = messageSource;
        this.locale = locale;
    }

    public void startQuiz(){
        questionReader.readFile(
                messageSource.getMessage(
                        "quiz.datafile.name",
                        new String[] {""},
                        locale)
        );

        System.out.println("\n" + greetingBundleImpl.getGreeting());

        for(int i = 0; i < questionReader.questionValidation(i); i++) {
            this.getQuestion(i);
        }

        System.out.print("\n" + counter.getResult() + "\n");
    }

    public String getQuestion(int questionNumber) {
        if(questionReader.questionValidation(questionNumber) == -1) {
            return messageSource.getMessage(
                    "quiz.noquestion",
                    new String[] {""},
                    locale);
        }

        System.out.print("\n" + questionReader.getQuestion(questionNumber) + "\n" + messageSource.getMessage(
                "quiz.answer",
                new String[] {""},
                locale)
        );
        scanner = new Scanner(System.in);
        String answer;
        answer = scanner.nextLine().toLowerCase();
        if (answer.compareTo(questionReader.getAnswer(questionNumber)) != 0){
            counter.setWrong();
            return messageSource.getMessage(
                    "quiz.wrong",
                    new String[] {"\n"},
                    locale);
        } else {
            counter.setRight();
            return messageSource.getMessage(
                    "quiz.right",
                    new String[] {"\n"},
                    locale);
        }
    }
}
