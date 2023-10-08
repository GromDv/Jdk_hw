package messenger;

public class ServerMain {
    public static void main(String[] args) {
        Server srv = new Server();
        new ClientGUI(srv);
        new ClientGUI(srv);
    }
}
