package com.keirnellyer.glencaldy.repository;

import com.keirnellyer.glencaldy.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository<String, User> {

    private final List<User> users = new ArrayList<>();

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User get(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public void add(User user) {
        users.add(user);
    }
}
