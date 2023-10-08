package messenger;

import messenger.interfaces.UserProfile;
import messenger.interfaces.UserRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class UserList implements UserRepository, Iterable<User> {

    private ArrayList<User> userArrayList;

    public UserList() {
        userArrayList = new ArrayList<>();
    }

    @Override
    public void addUser(UserProfile user) {
        userArrayList.add((User) user);
    }

    @Override
    public void clearList() {
        userArrayList.clear();
    }

    @Override
    public Iterator<User> iterator() {
        return userArrayList.iterator();
    }

    @Override
    public void forEach(Consumer<? super User> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<User> spliterator() {
        return Iterable.super.spliterator();
    }
}
