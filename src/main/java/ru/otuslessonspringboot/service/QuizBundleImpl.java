package ru.otuslessonspringboot.service;

import org.springframework.stereotype.Service;
import ru.otuslessonspringboot.config.YamlProps;

import java.util.Scanner;

@Service("Quiz bundle service")
public class QuizBundleImpl implements Quiz {
    private AnswerCounter counter;
    private CsvQuestionReaderDao questionReader;
    private Greeting greeting;
    private LocalMessage localMessage;
    private YamlProps props;
    private boolean isLogedIn = false;
    private String status = "notend";

    private Scanner scanner;

    public QuizBundleImpl(AnswerCounter counter, CsvQuestionReaderDao questionReader, Greeting greeting, LocalMessage localMessage, YamlProps props){
        this.counter = counter;
        this.questionReader = questionReader;
        this.greeting = greeting;
        this.localMessage = localMessage;
        this.props = props;
    }

    public void startQuiz(){
        questionReader.readFile(props.getQuizDatafileName());
        counter.resetCount();
        for(int i = 0; i < questionReader.questionValidation(i); i++) {
            this.getQuestion(i);
        }
        this.status = "ended";
    }

    public String getQuestion(int questionNumber) {
        if(questionReader.questionValidation(questionNumber) == -1) {
            return localMessage.getMessage("quiz.noquestion");
        }
        System.out.print("\n" + questionReader.getQuestion(questionNumber) + "\n" + localMessage.getMessage("quiz.answer"));
        scanner = new Scanner(System.in);
        String answer;
        answer = scanner.nextLine().toLowerCase();
        if (answer.compareTo(questionReader.getAnswer(questionNumber)) != 0){
            counter.setWrong();
            return localMessage.getMessage("quiz.wrong");
        } else {
            counter.setRight();
            return localMessage.getMessage("quiz.right");
        }
    }

    public String login(){
        this.isLogedIn = true;
        return greeting.getGreeting();
    }

    public String printResult(){
        this.isLogedIn = false;
        this.status = "notend";
        return counter.getResult();
    }

    public boolean isLogedIn(){
        return this.isLogedIn;
    }

    public String getStatus(){
        return this.status;
    }
}
