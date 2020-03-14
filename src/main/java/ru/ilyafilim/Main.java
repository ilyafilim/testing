package ru.ilyafilim;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.ilyafilim.constants.Statics;
import ru.ilyafilim.domain.Question;
import ru.ilyafilim.service.QuestionService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService questionService = context.getBean(QuestionService.class);

        Scanner in = new Scanner(System.in);
        System.out.print("Добро пожаловать, пожалуйста введите своё Имя: ");
        String name = in.nextLine();
        System.out.print("\nСпасибо, " + name + ". Теперь необходимо ввести Фамилию: ");
        String surname = in.nextLine();
        System.out.println("Отлично, начинаем тест, первый вопрос:");
        Question question; int c = 0;

        for (int a = 0; a != Statics.MAX_QUESTION; a++) {
            question = questionService.getNextQuestion();
            System.out.print("\n" + (a + 1) + ". " + question.getDefinition() + "\nВаш ответ: ");
            String ans = in.nextLine();
            if (ans.equalsIgnoreCase(question.getTerm())) {
                c++;
                System.out.println("Верно! Дан правильный ответ, Вы заработали одно очко. " + (Statics.MAX_QUESTION - a == 1 ? "Финальный вопрос:" : "Следующий вопрос:"));
            } else {
                System.out.println("К сожалению, это неверный ответ, правильный – " + question.getTerm() + ". И так, " + (Statics.MAX_QUESTION - a == 1 ? "Финальный вопрос:" : "Следующий вопрос:"));
            }
        }

        System.out.println();
        System.out.println("Тест окончен. Спасибо за прохождение, " + name + " " + surname + ". Вы набрали " + c + " " + (c > 4 ? "баллов" : c > 1 ? "балла" : c == 1 ? "балл" : "баллов") + ".");
        context.close();
    }
}
