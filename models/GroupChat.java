package models;

import java.util.ArrayList;
import java.util.List;

public class GroupChat extends Chat {
    private String groupName;
    private User admin;

    public GroupChat(List<User> participants) {
        super(new ArrayList<>(participants));
        this.admin = participants.get(0);
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public User getAdmin() {
        return admin;
    }

    public void addParticipant(User user) {
        getParticipants().add(user);
        registerObserver(user);
    }

    public void removeParticipant(User user) {
        getParticipants().remove(user);
        removeObserver(user);
    }
} 