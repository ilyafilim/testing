package ru.ilyafilim.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.ilyafilim.dao.QuestionDao;
import ru.ilyafilim.dao.QuestionDaoCSV;

@PropertySource("classpath:app.properties")
@Configuration
public class DaoConfig {

    @Value("${csv.ru.testing.file}")
    private String csvFile;
    @Bean
    public QuestionDao questionDao() {
        return new QuestionDaoCSV(csvFile);
    }
}
