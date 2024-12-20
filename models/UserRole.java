package models;

public class UserRole implements Role {
    @Override
    public boolean canModifyUsers() {
        return false;
    }
} 