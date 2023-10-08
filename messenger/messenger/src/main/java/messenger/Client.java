package messenger;

import messenger.interfaces.ClientView;
import messenger.interfaces.ServerCore;
import messenger.interfaces.UserProfile;

public class Client {
    private ClientView clientView;
    private ServerCore server;
    private boolean connected;

    public Client(ClientView clientView, ServerCore server) {
        this.clientView = clientView;
        this.server = server;
    }

    public boolean connectToServer(UserProfile user) {
        if (server.connectUser(user)) {
            connected = true;
            String log = server.getHistory();
            if (log != null)
                printText(log);
            printText("Вы успешно подключились!\n");
            return true;
        } else {
            printText("Подключение не удалось");
            return false;
        }
    }

    //мы посылаем
    public void sendMessage(String message) {
        if (connected) {
            if (!message.isEmpty()) {
                server.sendMessage(message);
            }
        } else {
            printText("Нет подключения к серверу");
        }
    }

    //нам посылают
    public void serverAnswer(String answer) {
        printText(answer);
    }

    public void disconnect() {
        if (connected) {
            connected = false;
            clientView.disconnectFromServer();
            printText("Вы были отключены от сервера!");
        }
    }

    private void printText(String text) {
        clientView.showMessage(text);
    }
}
