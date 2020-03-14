package ru.ilyafilim.constants;

public class Statics {


    public final static int MAX_QUESTION = 4;
    public static int question = 0;

    public static int getQuestion() {
        question++;
        return question;
    }
}
