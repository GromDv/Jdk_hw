public class Wiseman extends Thread {
    public Wiseman(int id, Fork fork1, Fork fork2) {
        this.id = id;
        this.fork1 = fork1;
        this.fork2 = fork2;
        eatCounter = 0;
    }

    public boolean isThinking() {
        return thinking;
    }

    public void setThinking(boolean thinking) {
        this.thinking = thinking;
    }

    private int id;
    private boolean thinking = true;

    public int getEatCounter() {
        return eatCounter;
    }

    public void setEatCounter(int eatCounter) {
        this.eatCounter = eatCounter;
    }

    private int eatCounter;
    private Fork fork1, fork2;

    @Override
    public void run() {

        while (eatCounter < 3) {
            tryToEat();
        }
        System.out.println("Wiseman " + id + " is finished.");
    }

    public void tryToEat() {
        if (fork1.isFree() && fork2.isFree()) {
            fork1.setFree(false);
            fork2.setFree(false);
            thinking = false;
            System.out.println("Wiseman " + id + " is eating " + (++eatCounter) + " time.");
            try {
                sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            fork1.setFree(true);
            fork2.setFree(true);
            thinking = true;
            System.out.println("Wiseman " + id + " is thinking...");
        }
    }

    @Override
    public String toString() {
        return "Wiseman{" +
                "id=" + id +
                ", thinking=" + thinking +
                ", fork1=" + fork1 +
                ", fork2=" + fork2 +
                '}';
    }
}
