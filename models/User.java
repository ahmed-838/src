package models;

import patterns.observer.Observer;

public class User implements Observer {
    private String userId;
    private String username;
    private Role role;

    private User(Builder builder) {
        this.userId = builder.userId;
        this.username = builder.username;
        this.role = builder.role;
    }

    public static class Builder {
        private String userId;
        private String username;
        private Role role;

        public Builder setId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public void update(String message) {
        System.out.println(username + " received: " + message);
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Role getRole() {
        return role;
    }
} 