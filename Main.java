import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;  
import models.*;
import services.*;

public class Main {
    public static void main(String[] args) {
        // Create services
        UserService userService = new UserService();
        ChatService chatService = new ChatService();

        // Create users with different roles
        User admin = userService.createUser("admin", new AdminRole());
        User user1 = userService.createUser("Alice", new UserRole());
        User user2 = userService.createUser("Bob", new UserRole());
        User user3 = userService.createUser("Charlie", new UserRole());

        // Create a private chat
        Chat privateChat = chatService.createPrivateChat(user1, user2);
        
        // Send messages in private chat
        chatService.sendMessage(privateChat, user1, "Hi Bob!");
        chatService.sendMessage(privateChat, user2, "Hello Alice!");

        // Create a group chat
        List<User> groupParticipants = new ArrayList<>(Arrays.asList(user1, user2, user3));
        GroupChat groupChat = chatService.createGroupChat(groupParticipants, "Friends Group");
        
        // Send messages in group chat
        chatService.sendMessage(groupChat, user1, "Welcome everyone!");
        chatService.sendMessage(groupChat, user3, "Hi all!");

        // Admin operations
        if (admin.getRole().canModifyUsers()) {
            groupChat.removeParticipant(user2);
            System.out.println("Admin removed Bob from the group chat");
        }
    }
} 