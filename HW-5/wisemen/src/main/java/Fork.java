public class Fork {
    public Fork(int id) {
        this.id = id;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    private int id;
    private volatile boolean free = true;

    @Override
    public String toString() {
        return "Fork{" +
                "id=" + id +
                ", free=" + free +
                '}';
    }
}
