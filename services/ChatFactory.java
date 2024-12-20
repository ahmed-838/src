package services;

import java.util.List;
import models.Chat;
import models.GroupChat;
import models.User;

public class ChatFactory {
    public static Chat createChat(String type, List<User> participants) {
        if (type.equals("group")) {
            return new GroupChat(participants);
        }
        return new Chat(participants);
    }
} 