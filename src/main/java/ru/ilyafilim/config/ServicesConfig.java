package ru.ilyafilim.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.ilyafilim.dao.QuestionDao;
import ru.ilyafilim.service.*;

import java.nio.charset.StandardCharsets;

@PropertySource("classpath:app.properties")
@Configuration
public class ServicesConfig {

    @Bean
    public MessageSource messagesSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/messages");
        ms.setDefaultEncoding("Windows-1251");
        return ms;
    }

    @Bean
    public QuestionService questionService(QuestionDao dao) {
        return new QuestionServiceImpl(dao);
    }

    @Bean
    public GameService gameService(DialogService dialogService, QuestionService questionService, @Value("${testing.max.questions}") Integer maxQuestions) {
        return new GameServiceImp(dialogService, questionService, maxQuestions);
    }

}
