package ru.otuslessonspringboot.service;

import org.springframework.stereotype.Service;
import ru.otuslessonspringboot.config.YamlProps;

import java.util.Locale;
import java.util.Scanner;

@Service("Quiz bundle service")
public class QuizBundleImpl implements Quiz {
    private AnswerCounter counter;
    private CsvQuestionReaderDao questionReader;
    private Greeting greeting;
    private LocalMessage localMessage;
    private YamlProps props;

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

        System.out.println(props.getLocale());
        props.setLocale(new Locale("en", "EN"));
        System.out.println(props.getLocale());


        System.out.println("\n" + greeting.getGreeting());

        counter.resetCount();
        for(int i = 0; i < questionReader.questionValidation(i); i++) {
            this.getQuestion(i);
        }

        System.out.print("\n" + counter.getResult() + "\n");
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
}
