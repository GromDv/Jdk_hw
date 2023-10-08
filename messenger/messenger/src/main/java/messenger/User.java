package messenger;

import messenger.interfaces.UserProfile;

public class User implements UserProfile {

    private String login;
    private Client client;
    private String name;
    private String password;

    public User(String login, Client cli) {
        this.login = login;
        client = cli;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public Client getClientInstance() {
        return client;
    }
}
