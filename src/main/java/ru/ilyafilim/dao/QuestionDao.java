package ru.ilyafilim.dao;

import ru.ilyafilim.domain.Question;

public interface QuestionDao {

    Question readRow(int rowNumber);
}
