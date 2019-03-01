package ru.otuslessonspringboot.service;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
public class ShellFlow {
    private final static String LOGIN = "login";
    private final static String QUIZ = "quiz";
    private final static String PRINTRESULT = "printresult";
    Quiz quiz;

    public ShellFlow(Quiz quiz){
        this.quiz = quiz;
    }

    @ShellMethodAvailability(LOGIN)
    public Availability isLoginAvailability() {
        if(!quiz.isLogedIn()){
            return Availability.available();
        } else {
            return Availability.unavailable("You are alrady loged in.");
        }
    }

    @ShellMethodAvailability(QUIZ)
    public Availability isQuizAvailability() {
        if(quiz.isLogedIn()){
            return Availability.available();
        } else {
            return Availability.unavailable("You are not loged in.");
        }
    }

    @ShellMethodAvailability(PRINTRESULT)
    public Availability isPrintResultAvailability() {
        if(quiz.getStatus() == "ended"){
            return Availability.available();
        } else {
            return Availability.unavailable("Quiz is not ended.");
        }
    }

    @ShellMethod(key=QUIZ, value = "Start the Quiz!")
    public String quiz(){
        quiz.startQuiz();
        return "Quiz is over";
    }

    @ShellMethod(key=LOGIN, value = "Sigh in quiz")
    public String login(){
        System.out.println();
        String result = quiz.login();
        return result;
    }

    @ShellMethod(key=PRINTRESULT, value = "Show quiz result")
    public String printresult(){
        System.out.println();
        String result = quiz.printResult();
        return result;
    }
}
