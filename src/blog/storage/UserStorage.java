package blog.storage;

import blog.model.User;

public class UserStorage {
    User[] users = new User[10];
    private int size = 0;

    public void add(User user) {
        if (size == users.length) {
            extend();
        }
        users[size++] = user;
    }

    private void extend() {
        User[] temp = new User[users.length + 10];
        System.arraycopy(users, 0, temp, 0, users.length);
        users = temp;
    }

    public void printAllUsers() {
        for (int i = 0; i < size; i++) {
            System.out.println(users[i]);
        }
    }

    public User getUserbyEmailOrPassword(String userEmail, String userInput) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(userEmail) && users[i].getPassword().equals(userInput)) {
                return users[i];
            }

        }
        return null;
    }

    public User userSearchpass(String userPass) {
        for (int i = 0; i < size; i++) {
            if (users[i].getPassword().equals(userPass)) {
                return users[i];
            }

        }
        return null;
    }
}
