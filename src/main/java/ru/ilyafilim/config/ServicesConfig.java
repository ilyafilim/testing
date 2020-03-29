package ru.ilyafilim.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.ilyafilim.dao.QuestionDao;
import ru.ilyafilim.service.QuestionService;
import ru.ilyafilim.service.QuestionServiceImpl;

@Configuration
public class ServicesConfig {

    @Bean
    public MessageSource messagesSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("UTF_8");
        return ms;
    }

    @Bean
    public QuestionService questionService(QuestionDao dao) {
        return new QuestionServiceImpl(dao);
    }
}
