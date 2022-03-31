import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTrack = new StepTracker(); //создали объект класса СтепТрэкер

        stepTrack.NowDayMonth(scanner); //запрашиваем 1 раз у пользователя сегодняшнюю дату и месяц. для исключения повторных запросов одной и той же информации
        while(true){
            printMenu(); //печатаем меню выбора
            int userInput = scanner.nextInt(); //записываем выбор пользователя в переменную UI

            if(userInput ==1){ // если 1, то вводим кол-во шагов за определенный день
                stepTrack.stepPerDay(scanner);
                System.out.println("Значение сохранено");
            } else if (userInput ==2) { // если 2, то печатаем статистику за определенный месяц
                stepTrack.statisticsForTheMonth(scanner);
            } else if (userInput ==3) { //если 3, то изменяем цель по кол-ву шагов в день
                stepTrack.exGoalStep(scanner); //метод изменения целевого значения из объекта стептрек
            } else if (userInput ==0) {
                System.out.println("Программа завершена");
                break;
            }else {   //некорректная команда
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

