package pair;

/**
 * Обобщённый класс, который представляет собой пару значений разного типа.
 *
 * @param <T> - любой
 * @param <U> - любой
 */
public class Pair<T, U> {

    @Override
    public String toString() {
        return "Pair:{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public T getFirst() {
        return a;
    }

    public U getSecond() {
        return b;
    }

    private T a;
    private U b;

    public Pair(T a, U b) {
        this.a = a;
        this.b = b;
    }
}
