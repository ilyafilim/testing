package ru.ilyafilim;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.ilyafilim.service.DialogService;
import ru.ilyafilim.service.GameService;
import ru.ilyafilim.service.QuestionService;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        GameService gameService = context.getBean(GameService.class);
        gameService.game();
        context.close();
    }
}
