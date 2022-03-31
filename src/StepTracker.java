import java.util.Scanner;

public class StepTracker {
    int[][] dataStep = new int[12][30];// массив 12 месяцев по 30 дней должны создаться со значениями 0
    int goalStep = 10000;
    int m; //переменные для работы с массивом
    int d;
    int dayNow; //переменные текущий день и месяц
    int monthNow;
    int summStep=0; //Переменная Сумма шагов для отправки в класс конвертации
    private Converter converter = new Converter();

    void exGoalStep(Scanner scanner) { // Изменение целевого значения количества шагов. Нужно привязываться к определенному дню? Если без привязки, то:
        System.out.println("Задайте новое целевое количество шагов.");
        while (true) {
            int newGoalStep = scanner.nextInt(); // записываем введенное пользователем значенеит в новую переменную
            if (newGoalStep >= 0) { //проверка на условие ТЗ
                goalStep = newGoalStep;
                break;
            } else {
                System.out.println("Число должно быть больше 0. Давайте попробуем еще раз!"); // выполняем цикл еще раз. До ввода пользователем положительного числа.
            }
        }
    }

    void stepPerDay(Scanner scanner) { //Ввод количества шагов за день
        System.out.println("Введите номер месяца от 0 до 11 (январь - 0, декабрь - 11) ");
        while (true) {
            int month = scanner.nextInt(); // записали
            if (month >= 0 && month <= 11) { //проверка корректности введенного числа
                m = month;
                break;
            } else {
                System.out.println("Извините, такого месяца нет. Введите число от 0 до 11"); // выполняем цикл еще раз.
            }
        }
        System.out.println("Введите номер дня от 1 до 30");
        while (true) {
            int day = scanner.nextInt(); // записали
            if (day > 0 && day <= 30) { //проверка корректности введенного числа
                d = day;
                break;
            } else {
                System.out.println("Извините, такого дня нет. Введите число от 1 до 30"); // выполняем цикл еще раз.
            }
        }
        System.out.println("Введите количество шагов за этот день");
        while (true) {
            int stepDay = scanner.nextInt(); // записываем введенное пользователем значенеит в новую переменную
            if (stepDay >= 0) { //проверка на условие ТЗ
                dataStep[m][d-1] = stepDay;
                break;
            } else {
                System.out.println("Число должно быть больше 0. Давайте попробуем еще раз!"); // выполняем цикл еще раз. До ввода пользователем положительного числа.
            }
        }
    }

    void NowDayMonth(Scanner scanner) { //этот метод запрашивает у пользоателя Сегодняшние дату и месяц. Лучше всего запросить информацию 1 раз перед вызовом главного меню. Т.К. данные в течении дня не меняются
        System.out.println("Какой сейчас месяц? Введите номер месяца от 0 до 11 (январь - 0, декабрь - 11)");
        while (true) {
            monthNow = scanner.nextInt(); // записали
            if (monthNow >= 0 && monthNow <= 11) { //проверка корректности введенного числа
                break;
            } else {
                System.out.println("Извините, такого месяца нет. Введите число от 0 до 11"); // выполняем цикл еще раз.
            }
        }
        System.out.println("Какое сегодня число? (от 1 до 30)");
        while (true) {
            dayNow = scanner.nextInt(); // записали
            if (dayNow > 0 && dayNow <= 30) { //проверка корректности введенного числа
                break;
            } else {
                System.out.println("Извините, такого дня нет. Введите число от 1 до 30"); // выполняем цикл еще раз.
            }
        }
    }

    void statisticsForTheMonth(Scanner scanner) {//Статистика
        System.out.println("За какой месяц показать статистику? Введите номер месяца от 0 до 11 (январь - 0, декабрь - 11) ");
        while (true) {
            m = scanner.nextInt(); // записали
            if (m >= 0 && m <= 11){
                break;//проверка корректности введенного числа{
            } else {
                System.out.println("Извините, такого месяца нет. Введите число от 0 до 11"); // выполняем цикл еще раз.
            }
        }

        if (m==monthNow && dayNow==1 ) { //нужна проверка на день и месяц. Если текущий месяц равен месяцу по которому запрошены данные, то все данные должны быть 0
            System.out.println("Месяц только начался! Данные не накоплены!");
            System.out.println("Количество пройденных шагов по дням: 0");
            System.out.println("Общее количество шагов за месяц: 0");
            System.out.println("Максимальное пройденное количество шагов в этом месяце: 0");
            System.out.println("Среднее количество шагов за день: 0");
            System.out.println("Пройденная дистанция в километрах: 0");
            System.out.println("Количество сожжённых килокалорий: 0");
            System.out.println("Выполнили дневную цель по шагам подряд: 0 раз");


        }else { //если все в порядке - выводим статистику
            System.out.println("Количество пройденных шагов по дням:");
            for (int i=0; i<dataStep[0].length; i++){//кол-во шагов по дням
                System.out.print((i+1)+" день: "+dataStep[m][i]+",");
                }

                 //общее кол-во шагов за месяц
                summStep = 0; //обнуляем число для исключения накопления значения при повторной рабоет цикла
                for (int i=0; i<dataStep[0].length; i++){
                summStep = summStep+dataStep[m][i];
                 }
                 System.out.println("\nОбщее количество шагов за месяц: " + summStep);
                 int maxStep=0; //Максимальное кол-во шагов в месяце
                 for (int i=0; i<dataStep[0].length; i++){
                    if (dataStep[m][i]>maxStep){
                    maxStep=dataStep[m][i];
                    }
                 }
                 System.out.println("Максимальное пройденное количество шагов в этом месяце: "+maxStep);

                double averagePerDay = 0;
                int s=0;
                 if (m==monthNow){//среднее кол-во шагов. Если запрошенный месяц совпадает с текущим месяцем, то среднее кол-во считаем по дням с 1 по текущий день. Если месяц другой, то за 30 дней
                    for (int i=0; i<(d-1); i++){  // считаем сумму шагов за неполный месяц
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
            int a=0; // дополнительная переменная
            for (int i=0; i<dataStep[0].length; i++){  //перебор массива месяца
                if (dataStep[m][i]>=goalStep){
                    a=a+1;
                } else if (a>maxSeries){
                    maxSeries=a;
                } else {
                    a=0;
                }
            }
            System.out.println("\nЛучшая серия: " +maxSeries +" дн");
                }

    }


    }
