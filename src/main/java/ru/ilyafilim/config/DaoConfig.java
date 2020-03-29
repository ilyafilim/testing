package ru.ilyafilim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.ilyafilim.dao.QuestionDao;
import ru.ilyafilim.dao.QuestionDaoCSV;

@Configuration
public class DaoConfig {

    @Bean
    public QuestionDao questionDao() {
        return new QuestionDaoCSV();
    }
}
