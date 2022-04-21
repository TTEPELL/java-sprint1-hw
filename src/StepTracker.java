public class StepTracker {
    int[][] dataStep = new int[12][30];
    int goalStep = 10000;
    int summStep = 0;
    private Converter converter = new Converter();

    void exGoalStep(int newGoalStep) {
        goalStep = newGoalStep;
    }
    void stepPerDay(int m, int d, int stepDay) {
        dataStep[m][d - 1] = stepDay;
    }
    void statisticsForTheMonth(int monthNow, int dayNow, int m) {//Статистика
        if (m != monthNow && dayNow != 1) { //нужна проверка на день и месяц. Если текущий месяц равен месяцу по которому запрошены данные, то все данные должны быть
            printStepsForAMonth(m);
            System.out.println("\nОбщее количество шагов за месяц: " + summStep);
            System.out.println("Максимальное пройденное количество шагов в этом месяце: " + maxStep(m));
            System.out.printf("Среднее количество шагов за день: %.0f", averagePerDay(m, monthNow, dayNow));
            System.out.printf("\nЗа месяц вы прошли: %.2f километров", converter.stepToKm(summStep));
            System.out.printf("\nЗа месяц вы сожгли: %.0f Ккал ", converter.stepToKcalories(summStep));
            System.out.println("\nЛучшая серия: " + maxSeries(m) + " дн");
        } else {
            System.out.println("Месяц только начался! Данные не накоплены!\nКоличество пройденных шагов по дням: 0\nОбщее количество шагов за месяц: 0\nМаксимальное пройденное количество шагов в этом месяце: 0\nСреднее количество шагов за день: 0\nПройденная дистанция в километрах: 0\nКоличество сожжённых килокалорий: 0\nВыполнили дневную цель по шагам подряд: 0 раз");
        }
    }
    int maxSeries(int m) {
        int maxSeries = 0; //серия
        int a = 0;
        for (int i = 0; i < dataStep[0].length; i++) {
            if (dataStep[m][i] >= goalStep) {
                a = a + 1;
            } else if (a > maxSeries) {
                maxSeries = a;
                a = 0;
            } else {
                a = 0;
            }
        }
        return maxSeries;
    }
    double averagePerDay(int m, int monthNow, int dayNow) {
        double averagePerDay = 0;
        int s = 0;
        if (m == monthNow) {//среднее кол-во шагов. Если запрошенный месяц совпадает с текущим месяцем, то среднее кол-во считаем по дням с 1 по текущий день. Если месяц другой, то за 30 дней
            for (int i = 0; i < (dayNow - 1); i++) {
                if (dataStep[m][i] > summStep) {
                    s = s + dataStep[m][i];
                }
                averagePerDay = summStep / dayNow; // среднее за неполный месяц
            }
        } else {
            averagePerDay = summStep / dataStep[0].length; //среднее за полный месяц
        }
        return averagePerDay;
    }
    int maxStep (int m){
    int maxStep = 0;
            for (int i = 0; i < dataStep[0].length; i++) {
        if (dataStep[m][i] > maxStep) {
            maxStep = dataStep[m][i];
        }
    }
        return maxStep;
    }
    void printStepsForAMonth(int m){
        System.out.println("Количество пройденных шагов по дням:");
        for (int i = 0; i < dataStep[0].length; i++) {
            System.out.print((i + 1) + " день: " + dataStep[m][i] + ",");
        }

        //общее кол-во шагов за месяц
        summStep = 0; //обнуляем число для исключения накопления значения при повторной рабоет цикла
        for (int i = 0; i < dataStep[0].length; i++) {
            summStep = summStep + dataStep[m][i];
        }
}


}




