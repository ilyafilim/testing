package ru.ilyafilim.service;

import ru.ilyafilim.constants.Statics;
import ru.ilyafilim.dao.QuestionDao;
import ru.ilyafilim.domain.Question;

public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao dao;
    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public Question getNextQuestion() {
        return dao.readRow(Statics.getQuestion());
    }
}
