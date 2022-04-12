import java.util.Scanner;

public class StepTracker {
    int[][] dataStep = new int[12][30];
    int goalStep = 10000;
    int m;
    int d;
    int dayNow;
    int monthNow;
    int summStep=0;

    private Converter converter = new Converter();

    void enterMonth(Scanner scanner) {
        System.out.println("Введите номер месяца от 0 до 11 (0-январь, 1-февраль, 2-март, 3-апрель, 4-май, 5-июнь, 6-июль, 7-август, 8-сентябрь, 9-октябрь, 10- ноябрь, 11-декабрь)");
        while (true) {
            int month = scanner.nextInt();
            if (month >= 0 && month <= 11) {
                m = month;
                break;
            } else {
                System.out.println("Извините, такого месяца нет. Введите число от 0 до 11");
            }
        }
    }

    void exGoalStep(Scanner scanner) {
        System.out.println("Задайте новое целевое количество шагов.");
        while (true) {
            int newGoalStep = scanner.nextInt();
            if (newGoalStep >= 0) {
                goalStep = newGoalStep;
                break;
            } else {
                System.out.println("Число должно быть больше 0. Давайте попробуем еще раз!");
            }
        }
    }

    void stepPerDay(Scanner scanner) {
        enterMonth(scanner);
        System.out.println("Введите номер дня от 1 до 30");
        while (true) {
            int day = scanner.nextInt();
            if (day > 0 && day <= 30) {
                d = day;
                break;
            } else {
                System.out.println("Извините, такого дня нет. Введите число от 1 до 30");
            }
        }
        System.out.println("Введите количество шагов за этот день");
        while (true) {
            int stepDay = scanner.nextInt();
            if (stepDay >= 0) {
                dataStep[m][d-1] = stepDay;
                break;
            } else {
                System.out.println("Число должно быть больше 0. Давайте попробуем еще раз!");
            }
        }
    }

    void NowDayMonth(Scanner scanner) { //этот метод запрашивает у пользоателя Сегодняшние дату и месяц. Лучше всего запросить информацию 1 раз перед вызовом главного меню. Т.К. данные в течении дня не меняются
        System.out.println("Какой сейчас месяц? Введите номер месяца от 0 до 11 (0-январь, 1-февраль, 2-март, 3-апрель, 4-май, 5-июнь, 6-июль, 7-август, 8-сентябрь, 9-октябрь, 10- ноябрь, 11-декабрь)");
        while (true) {
            monthNow = scanner.nextInt();
            if (monthNow >= 0 && monthNow <= 11) {
                break;
            } else {
                System.out.println("Извините, такого месяца нет. Введите число от 0 до 11");
            }
        }
        System.out.println("Какое сегодня число? (от 1 до 30)");
        while (true) {
            dayNow = scanner.nextInt();
            if (dayNow > 0 && dayNow <= 30) {
                break;
            } else {
                System.out.println("Извините, такого дня нет. Введите число от 1 до 30");
            }
        }
    }

    void statisticsForTheMonth(Scanner scanner) {//Статистика
        System.out.print("За какой месяц показать статистику?");
        enterMonth(scanner);

        if (m==monthNow && dayNow==1 ) { //нужна проверка на день и месяц. Если текущий месяц равен месяцу по которому запрошены данные, то все данные должны быть 0
            System.out.println("Месяц только начался! Данные не накоплены!\nКоличество пройденных шагов по дням: 0\nОбщее количество шагов за месяц: 0\nМаксимальное пройденное количество шагов в этом месяце: 0\nСреднее количество шагов за день: 0\nПройденная дистанция в километрах: 0\nКоличество сожжённых килокалорий: 0\nВыполнили дневную цель по шагам подряд: 0 раз");
        }else {
            System.out.println("Количество пройденных шагов по дням:");
            for (int i=0; i<dataStep[0].length; i++){
                System.out.print((i+1)+" день: "+dataStep[m][i]+",");
                }

                 //общее кол-во шагов за месяц
                summStep = 0; //обнуляем число для исключения накопления значения при повторной рабоет цикла
                for (int i=0; i<dataStep[0].length; i++){
                summStep = summStep+dataStep[m][i];
                 }
                 System.out.println("\nОбщее количество шагов за месяц: " + summStep);
                 int maxStep=0;
                 for (int i=0; i<dataStep[0].length; i++){
                    if (dataStep[m][i]>maxStep){
                    maxStep=dataStep[m][i];
                    }
                 }
                 System.out.println("Максимальное пройденное количество шагов в этом месяце: "+maxStep);

                double averagePerDay = 0;
                int s=0;
                 if (m==monthNow){//среднее кол-во шагов. Если запрошенный месяц совпадает с текущим месяцем, то среднее кол-во считаем по дням с 1 по текущий день. Если месяц другой, то за 30 дней
                    for (int i=0; i<(d-1); i++){
                        if (dataStep[m][i]>summStep){
                         s = s + dataStep[m][i];
                         }
                    averagePerDay=summStep/d; // среднее за неполный месяц
                     }
                 }else {
                  averagePerDay=summStep/dataStep[0].length; //среднее за полный месяц
                 }
                 System.out.printf("Среднее количество шагов за день: %.0f",averagePerDay);
                 System.out.printf("\nЗа месяц вы прошли: %.2f километров",converter.stepToKm(summStep));
                 System.out.printf("\nЗа месяц вы сожгли: %.0f Ккал ",converter.stepToKcalories(summStep));

            int maxSeries=0; //серия
            int a=0;
            for (int i=0; i<dataStep[0].length; i++){
                if (dataStep[m][i]>=goalStep){
                    a=a+1;
                } else if (a>maxSeries){
                    maxSeries=a;
                    a=0;
                } else {
                    a=0;
                }
            }
            System.out.println("\nЛучшая серия: " +maxSeries +" дн");
                }

    }
    }
