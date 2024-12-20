package models;

public class AdminRole implements Role {
    @Override
    public boolean canModifyUsers() {
        return true;
    }
} 