package ru.ilyafilim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class DialogServiceImpl implements DialogService {

    private final MessageSource messagesSource;

    public DialogServiceImpl(MessageSource messagesSource) {
        this.messagesSource = messagesSource;
    }

    @Override
    public String printHello() {
        return messagesSource.getMessage("hello.user", null, Locale.ENGLISH);
    }

    @Override
    public String enterSurname(String name) {
        return messagesSource.getMessage("enter.surname", new String[]{name}, Locale.ENGLISH);
    }

    @Override
    public String letsTest() {
        return messagesSource.getMessage("lets.test", null, Locale.ENGLISH);
    }

    @Override
    public String getQuestion() {
        return messagesSource.getMessage("get.question", null, Locale.ENGLISH);
    }

    @Override
    public String getRight() {
        return messagesSource.getMessage("get.right", null, Locale.ENGLISH);
    }

    @Override
    public String getWrong(String rightAnswer) {
        return messagesSource.getMessage("get.wrong", new String[]{rightAnswer}, Locale.ENGLISH);
    }

    @Override
    public String nextQuestion() {
        return messagesSource.getMessage("next.question", null, Locale.ENGLISH);
    }

    @Override
    public String finalQuestion() {
        return messagesSource.getMessage("final.question", null, Locale.ENGLISH);
    }
}
