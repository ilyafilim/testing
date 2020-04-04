package ru.ilyafilim.service;

import ru.ilyafilim.domain.Question;

import java.util.Scanner;

public class GameServiceImp implements GameService {

    final int MAX_QUESTION = 4;

    private final DialogService dialogService;
    private final QuestionService questionService;

    public GameServiceImp(DialogService dialogService, QuestionService questionService) {
        this.dialogService = dialogService;
        this.questionService = questionService;
    }

    @Override
    public void game() {
        Scanner in = new Scanner(System.in);
        System.out.print(dialogService.printHello());
        String name = in.nextLine();
        System.out.print(dialogService.enterSurname(name));
        String surname = in.nextLine();
        System.out.println(dialogService.letsTest());
        Question question; int c = 0;
        for (int a = 0; a != MAX_QUESTION; a++) {
            question = questionService.getNextQuestion();
            System.out.print("\n" + (a + 1) + ". " + question.getDefinition() + "\nВаш ответ: ");
            String ans = in.nextLine();
            if (ans.equalsIgnoreCase(question.getTerm())) {
                c++;
                System.out.println("Верно! Дан правильный ответ, Вы заработали одно очко. " + (MAX_QUESTION - a == 1 ? "Финальный вопрос:" : "Следующий вопрос:"));
            } else {
                System.out.println("К сожалению, это неверный ответ, правильный – " + question.getTerm() + ". И так, " + (MAX_QUESTION - a == 1 ? "Финальный вопрос:" : "Следующий вопрос:"));
            }
        }

        System.out.println();
        System.out.println("Тест окончен. Спасибо за прохождение, " + name + " " + surname + ". Вы набрали " + c + " " + (c > 4 ? "баллов" : c > 1 ? "балла" : c == 1 ? "балл" : "баллов") + ".");
    }
}
