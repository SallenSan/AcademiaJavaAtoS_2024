package org.example.demo_servlet.service;

import org.example.demo_servlet.model.User;

import java.util.List;

public class Authenticator {
    private User user;
    private List<User> users;

    public User authenticate(User user, List<User> users) {
        if(users.contains(user)) {
            user = users.get(users.indexOf(user));
            return user;
        }
        return null;
    }
}
