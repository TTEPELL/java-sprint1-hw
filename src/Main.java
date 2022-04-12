import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTrack = new StepTracker();

        stepTrack.NowDayMonth(scanner); //запрашиваем 1 раз у пользователя сегодняшнюю дату и месяц. для исключения повторных запросов одной и той же информации
        while(true){
            printMenu();
            int userInput = scanner.nextInt();

            if(userInput ==1){
                stepTrack.stepPerDay(scanner);
                System.out.println("Значение сохранено");
            } else if (userInput ==2) {
                stepTrack.statisticsForTheMonth(scanner);
            } else if (userInput ==3) {
                stepTrack.exGoalStep(scanner);
            } else if (userInput ==0) {
                System.out.println("Программа завершена");
                break;
            }else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }

        }


    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}

