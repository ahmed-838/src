package services;

import java.util.Date;
import models.Chat;
import models.Message;
import models.User;

public class MessageBuilder {
    private Message message = new Message();

    public MessageBuilder setContent(String content) {
        message.setContent(content);
        return this;
    }

    public MessageBuilder setSender(User sender) {
        message.setSender(sender);
        return this;
    }

    public MessageBuilder setChat(Chat chat) {
        message.setChat(chat);
        return this;
    }

    public Message build() {
        message.setTimestamp(new Date());
        return message;
    }
} 