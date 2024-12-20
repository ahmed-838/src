package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.User;
import models.Role;


public class UserService {
    private Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public User createUser(String username, Role role) {
        String userId = generateUserId();
        User user = new User.Builder()
            .setId(userId)
            .setUsername(username)
            .setRole(role)
            .build();
        users.put(userId, user);
        return user;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void removeUser(String userId) {
        users.remove(userId);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    private String generateUserId() {
        return "user_" + System.currentTimeMillis();
    }
} 