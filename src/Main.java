import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTrack = new StepTracker();

        System.out.println("Какой сейчас месяц?");
        int monthNow = monthInput(scanner);
        System.out.println("Какое сегодня число?");
        int dayNow = dayInput(scanner);
        int month;
        int day;

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput ==0) {
                break ;
            }
            switch (userInput) {
                case 1:
                    month = monthInput(scanner);
                    day = dayInput(scanner);
                    System.out.println("Введите количество шагов за этот день");
                    int stepDay = scanner.nextInt();
                    while (stepDay < 0) {
                        System.out.println("Число должно быть больше 0. Давайте попробуем еще раз!");
                        stepDay = scanner.nextInt();
                    }
                    stepTrack.stepPerDay(month, day, stepDay);
                    System.out.println("Значение сохранено");
                    break;
                case 2:
                    System.out.print("За какой месяц показать статистику?");
                    month = monthInput(scanner);
                    stepTrack.statisticsForTheMonth(monthNow, dayNow, month);
                    break;
                case 3:
                    System.out.println("Задайте новое целевое количество шагов.");
                    int newGoalStep = scanner.nextInt();
                    if (newGoalStep < 0) {
                        System.out.println("Число должно быть больше 0. Давайте попробуем еще раз!");
                        continue;
                    }
                    stepTrack.exGoalStep(newGoalStep);
                    break;
                default:
                    System.out.println("Извините, такой команды пока нет");

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

    private static int dayInput(Scanner scanner) {
        System.out.println("Введите номер дня от 1 до 30");
        int day = scanner.nextInt();
        while (day < 1 || day > 30) {
            System.out.println("Извините, такого дня нет. Введите число от 1 до 30");
            day = scanner.nextInt();
        }
        return day;
    }

    private static int monthInput(Scanner scanner) {
        System.out.println("Введите номер месяца от 0 до 11 (0-январь, 1-февраль, 2-март, 3-апрель, 4-май, 5-июнь, 6-июль, 7-август, 8-сентябрь, 9-октябрь, 10- ноябрь, 11-декабрь)");
        int month = scanner.nextInt();
        while (month < 0 || month > 11) {
            System.out.println("Извините, такого месяца нет. Введите число от 0 до 11");
            month = scanner.nextInt();
        }
        return month;
    }
}
