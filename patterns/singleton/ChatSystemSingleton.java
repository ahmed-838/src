package patterns.singleton;

public class ChatSystemSingleton {
    private static ChatSystemSingleton instance;
    
    private ChatSystemSingleton() {}
    
    public static ChatSystemSingleton getInstance() {
        if (instance == null) {
            instance = new ChatSystemSingleton();
        }
        return instance;
    }
} 