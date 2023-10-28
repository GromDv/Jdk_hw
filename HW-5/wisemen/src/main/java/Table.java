import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<Fork> forks;
    private List<Wiseman> wisemen;

    public Table(int num) {
        forks = new ArrayList<>();
        wisemen = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            forks.add(new Fork(i));
        }
        for (int i = 0; i < num; i++) {
            wisemen.add(new Wiseman(i, forks.get(i - 1 < 0 ? forks.size() - 1 : i - 1), forks.get(i)));
        }
//        for (Wiseman w : wisemen
//        ) {
//            System.out.println(w.toString());
//        }
    }

    public void startEating() {
        for (Wiseman w : wisemen
        ) {
            w.start();
        }
    }
}
