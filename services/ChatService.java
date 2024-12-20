package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Chat;
import models.GroupChat;
import models.User;
import models.Message;


public class ChatService {
    private Map<String, Chat> chats;

    public ChatService() {
        this.chats = new HashMap<>();
    }

    public Chat createPrivateChat(User user1, User user2) {
        Chat chat = ChatFactory.createChat("private", List.of(user1, user2));
        chats.put(chat.getChatId(), chat);
        return chat;
    }

    public GroupChat createGroupChat(List<User> participants, String groupName) {
        GroupChat groupChat = (GroupChat) ChatFactory.createChat("group", participants);
        groupChat.setGroupName(groupName);
        chats.put(groupChat.getChatId(), groupChat);
        return groupChat;
    }

    public void sendMessage(Chat chat, User sender, String content) {
        Message message = new MessageBuilder()
            .setContent(content)
            .setSender(sender)
            .setChat(chat)
            .build();
        
        chat.sendMessage(message);
    }

    public Chat getChat(String chatId) {
        return chats.get(chatId);
    }

    public List<Chat> getUserChats(User user) {
        return chats.values().stream()
            .filter(chat -> chat.getParticipants().contains(user))
            .toList();
    }
} 