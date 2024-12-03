package com.quest.case_study.playlist_manager;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    // Add a new user
    public void addUser(String username) {
        if (users.containsKey(username)) {
            throw new IllegalArgumentException("User already exists.");
        }
        users.put(username, new User(username));
    }

    // Get an existing user by username
    public User getUser(String username) {
        return users.get(username);
    }

    // Remove a user
    public void removeUser(String username) {
        if (!users.containsKey(username)) {
            throw new IllegalArgumentException("User not found.");
        }
        users.remove(username);
    }

    // Display all users
    public void displayAllUsers() {
        users.keySet().forEach(System.out::println);
    }
}
