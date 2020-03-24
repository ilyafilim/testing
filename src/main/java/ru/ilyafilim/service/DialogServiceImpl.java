package ru.ilyafilim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class DialogServiceImpl implements DialogService {

    @Autowired
    private MessageSource messagesSource;

    @Override
    public String printHello() {
        return messagesSource.getMessage("hello.user", null, Locale.ENGLISH);
    }

    @Override
    public String enterName() {
        return null;
    }

    @Override
    public String enterSurname() {
        return null;
    }

    @Override
    public String letsTest() {
        return null;
    }

    @Override
    public String getRight() {
        return null;
    }

    @Override
    public String getWrong() {
        return null;
    }

    @Override
    public String nextQuestion() {
        return null;
    }

    @Override
    public String finalQuestion() {
        return null;
    }
}
