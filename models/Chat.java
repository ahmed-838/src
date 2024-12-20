package models;

import java.util.ArrayList;
import java.util.List;

import patterns.observer.Observer;
import patterns.observer.Subject;

public class Chat implements Subject {
    private String chatId;
    private List<User> participants;
    private List<Message> messages;
    private List<Observer> observers;

    public Chat(List<User> participants) {
        this.chatId = generateChatId();
        this.participants = participants;
        this.messages = new ArrayList<>();
        this.observers = new ArrayList<>();
        
        // Add all participants as observers
        participants.forEach(participant -> registerObserver(participant));
    }

    private String generateChatId() {
        return "chat_" + System.currentTimeMillis();
    }

    public void sendMessage(Message message) {
        messages.add(message);
        notifyObservers("New message from " + message.getSender().getUsername() + ": " + message.getContent());
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // Getters
    public String getChatId() {
        return chatId;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public List<Message> getMessages() {
        return messages;
    }
} 