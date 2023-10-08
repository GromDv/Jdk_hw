package messenger.interfaces;

public interface ServerCore {
    public boolean connectUser(UserProfile user);
    public String getHistory();
    public void sendMessage(String message);
    public void answer(String message);

}
