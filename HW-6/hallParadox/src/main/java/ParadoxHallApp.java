import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.HashMap;
import java.util.Random;

public class ParadoxHallApp {
    public static Random rnd = new Random();
    public static final int MAX_NUM_TESTS = 1000;
    public static final int NUM_DOORS = 3;
    public static final boolean PRINT_LOG = false;

    public static void main(String[] args) {

        HashMap<Integer, Boolean> result1 = new HashMap<>();// мне непонятно для чего это, но в задании есть такое условие
        HashMap<Integer, Boolean> result2 = new HashMap<>();// мне непонятно для чего это, но в задании есть такое условие
        DescriptiveStatistics stat1 = new DescriptiveStatistics();
        DescriptiveStatistics stat2 = new DescriptiveStatistics();

        System.out.println("========================================\nПроверяем первый вариант, когда игрок меняет свой первый выбор:");
        int numWins = 0, numLosses = 0;// на мой взгляд - самый простой вариант решения
        for (int i = 0; i < MAX_NUM_TESTS; i++) {
            if (game(true)) {
                result1.put(i, true);// мне непонятно для чего это, но в задании есть такое условие
                stat1.addValue(1);
                numWins++;
            } else {
                result1.put(i, false);// мне непонятно для чего это, но в задании есть такое условие
                stat1.addValue(0);
                numLosses++;
            }
        }
        System.out.printf("Побед: %d, Проигрышей: %d, всего тестов: %d.\n", numWins, numLosses, numWins + numLosses);
        System.out.printf("Статистика: из %d тестов - побед %.0f, поражений %.0f.\n", stat1.getN(), stat1.getSum(), stat1.getN() - stat1.getSum());

        System.out.println("========================================\nПроверяем второй вариант, когда игрок НЕ меняет свой первый выбор:");
        numWins = 0;
        numLosses = 0;
        for (int i = 0; i < MAX_NUM_TESTS; i++) {
            if (game(false)) {
                result2.put(i, true);// мне непонятно для чего это, но в задании есть такое условие
                stat2.addValue(1);
                numWins++;
            } else {
                result2.put(i, false);// мне непонятно для чего это, но в задании есть такое условие
                stat2.addValue(0);
                numLosses++;
            }
        }
        System.out.printf("Побед: %d, Проигрышей: %d, всего тестов: %d.\n", numWins, numLosses, numWins + numLosses);
        System.out.printf("Статистика: из %d тестов - побед %.0f, поражений %.0f.\n", stat2.getN(), stat2.getSum(), stat2.getN() - stat2.getSum());
    }

    /***
     * Метод реализует один раунд игры
     * @param type - тип игры: true - игрок меняет свой первый выбор,
     *             false - игрок не меняет свой первый выбор
     * @return - true если выигрыш, иначе - false
     */
    public static boolean game(boolean type) {
        int winDoor, playerTurn1;
        int showmanDoor = -1;
        boolean result = false;

        // одна дверь случайная - выигрышная
        winDoor = rnd.nextInt(3);

        // Игрок делает первый выбор
        playerTurn1 = rnd.nextInt(3);
        if (PRINT_LOG) System.out.printf("Игрок выбрал %d  дверь,", playerTurn1);

        // Ведущий открывает не выбранную игроком проигрышную дверь
        for (int j = 0; j < NUM_DOORS; j++) {
            if (j != winDoor && j != playerTurn1) {
                showmanDoor = j;
                if (PRINT_LOG) System.out.printf(" ведущий открыл %d дверь! Пусто!", showmanDoor);
                break;
            }
        }

        if (type) { // Игрок меняет решение и открывает другую дверь
            for (int j = 0; j < NUM_DOORS; j++) {
                if (j != showmanDoor && j != playerTurn1) {
                    if (PRINT_LOG) System.out.printf(" Открываем %d  дверь!", j);
                    if (j == winDoor) {
                        if (PRINT_LOG)
                            System.out.println("Победа!!! ");
                        result = true;
                    } else {
                        if (PRINT_LOG)
                            System.out.println("Проигрыш! (((");
                        result = false;
                    }
                }
            }
        } else {    // Игрок не меняет решение
            if (PRINT_LOG) System.out.printf(" Открываем %d  дверь!", playerTurn1);
            if (playerTurn1 == winDoor) {
                if (PRINT_LOG)
                    System.out.println("Победа!!! ");
                result = true;
            } else {
                if (PRINT_LOG)
                    System.out.println("Проигрыш! (((");
                result = false;
            }
        }
        return result;
    }
}
