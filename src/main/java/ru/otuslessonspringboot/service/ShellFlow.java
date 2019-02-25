package ru.otuslessonspringboot.service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ShellFlow {
    Quiz quiz;

    public ShellFlow(Quiz quiz){
        this.quiz = quiz;
    }

    @ShellMethod("Start the Quiz!")
    public String quiz(){
        quiz.startQuiz();
        return "Quiz over";
    }
}
