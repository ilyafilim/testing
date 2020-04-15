package ru.ilyafilim.services;

import org.springframework.stereotype.Service;
import ru.ilyafilim.dao.QuestionDao;
import ru.ilyafilim.domain.Question;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao dao;
    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public Question getNextQuestion() {
        return dao.readRow();
    }
}
