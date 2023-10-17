package calculator;

public class Calc {
    /**
     * Обобщённый метод сложения
     *
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <U extends Number, T extends Number> Double sum(T a, U b) {
        return Double.valueOf(a.doubleValue() + b.doubleValue());
    }

    /**
     * Обобщённый метод умножения
     *
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <U extends Number, T extends Number> Double multiply(T a, U b) {
        return Double.valueOf(a.doubleValue() * b.doubleValue());
    }

    /**
     * Обобщённый метод деления
     *
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <U extends Number, T extends Number> Double divide(T a, U b) {
        return Double.valueOf(a.doubleValue() / b.doubleValue());
    }

    /**
     * Обобщённый метод вычитания
     *
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <U extends Number, T extends Number> Double subtract(T a, U b) {
        return Double.valueOf(a.doubleValue() - b.doubleValue());
    }
}
