package ru.ilyafilim.service;

public interface DialogService {

    String printHello();
    String enterSurname(String name);
    String letsTest();
    String getQuestion();
    String getRight();
    String getWrong(String rightQuestion);
    String nextQuestion();
    String finalQuestion();

}
