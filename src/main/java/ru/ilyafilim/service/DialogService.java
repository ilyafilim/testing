package ru.ilyafilim.service;

public interface DialogService {

    String printHello();
    String enterSurname(String surname);
    String letsTest();
    String getQuestion();
    String getRight();
    String getWrong(String rightQuestion);
    String nextQuestion();
    String finalQuestion();

}
