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
    public Availability turnonLoginAvailability() {
        return Availability.available();
    }

/*    @ShellMethodAvailability(LOGIN)
    public Availability turnoffLoginAvailability() {
        return Availability.unavailable("You are already logged in. End quiz before logged in again.");
    }*/

    @ShellMethodAvailability(QUIZ)
    public Availability turnonQuizAvailability() {
        return Availability.available();
    }

    @ShellMethodAvailability(QUIZ)
    public Availability turnoffQuizAvailability() {
        return Availability.unavailable("You are not logged in.");
    }

/*    @ShellMethodAvailability(PRINTRESULT)
    public Availability turnonPrintResultAvailability() {
        return Availability.available();
    }*/

    @ShellMethodAvailability(PRINTRESULT)
    public Availability turnoffPrintResultAvailability() {
        return Availability.unavailable("You are not end the quiz.");
    }

    @ShellMethod(key=QUIZ, value = "Start the Quiz!")
    public String quiz(){
        quiz.startQuiz();
        turnoffQuizAvailability();
        //turnonPrintResultAvailability();
        return "Quiz is over";
    }

    @ShellMethod(key=LOGIN, value = "Sigh in quiz")
    public String login(){
        System.out.println();
        String result = quiz.login();
        //turnoffLoginAvailability();
        turnonQuizAvailability();
        return result;
    }

    @ShellMethod(key=PRINTRESULT, value = "Show quiz result")
    public String printresult(){
        System.out.println();
        String result = quiz.printResult();
        turnoffPrintResultAvailability();
        turnonLoginAvailability();
        return result;
    }
}
