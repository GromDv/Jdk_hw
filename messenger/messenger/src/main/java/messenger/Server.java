package messenger;

import messenger.interfaces.ChatLog;
import messenger.interfaces.ServerCore;
import messenger.interfaces.UserProfile;

public class Server implements ServerCore {
    private ServerGUI serverGUI;
    private UserList userList;
    private ChatLog msgLog;
    public static final String LOG_PATH = "log.txt";
    private boolean work;

    public Server() {
        serverGUI = new ServerGUI(this);
        userList = new UserList();
        msgLog = new MessageLog(LOG_PATH);
        work = false;
    }

    public boolean isWorking() {
        return work;
    }

    public void start() {
        work = true;
    }

    public void stop() {
        work = false;
    }

    @Override
    public boolean connectUser(UserProfile user) {
        if (!work) {
            return false;
        }
        userList.addUser(user);
        serverGUI.appendLog("Подключился " + user.getLogin());
        answer("Подключился " + user.getLogin());
        return true;
    }

    public void disconnectAllUsers() {
        for (User u : userList) {
            u.getClientInstance().disconnect();
        }
        userList.clearList();
    }

    @Override
    public String getHistory() {
        return msgLog.readLog();
    }

    @Override
    public void sendMessage(String message) {
        serverGUI.appendLog(message);
        msgLog.writeLog(message);
        answer(message);
    }

    @Override
    public void answer(String message) {
        if (!work)
            return;
        for (User u : userList) {
            u.getClientInstance().serverAnswer(message);
        }
    }
}
