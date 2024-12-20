# Java Chat Application Documentation

## Overview
A robust chat application implementing various design patterns and object-oriented principles to provide private and group chat functionality with user roles and real-time message notifications.

## Architecture

### Design Patterns Used
1. **Observer Pattern**
   - Used for real-time message notifications
   - `Subject` interface implemented by `Chat` class
   - `Observer` interface implemented by `User` class

2. **Builder Pattern**
   - Used in `User` class creation
   - Provides fluent interface for user construction

3. **Factory Pattern**
   - `ChatFactory` creates different types of chats
   - Supports private and group chat creation

## Core Components

### User Management
- **UserService**
  - Creates and manages user accounts
  - Generates unique user IDs
  - Stores user records

- **User Roles**
  - `AdminRole`: Can modify users and manage chats
  - `UserRole`: Basic chat participant capabilities

### Chat System
- **ChatService**
  - Manages chat creation and message delivery
  - Maintains chat records
  - Handles message routing

- **Chat Types**
  1. Private Chat
     - Two participants only
     - Direct message exchange
  
  2. Group Chat
     - Multiple participants
     - Group-wide messaging
     - Participant management (add/remove)

### Messaging
- **Message Features**
  - Timestamp recording
  - Sender tracking
  - Chat context association
  
- **MessageBuilder**
  - Fluent interface for message creation
  - Handles message metadata

## Class Structure

### Models
- `User`: Chat participant with role-based permissions
- `Chat`: Base chat functionality
- `GroupChat`: Extended chat with group-specific features
- `Message`: Communication unit
- `Role`: Permission interface

### Services
- `UserService`: User management operations
- `ChatService`: Chat and message handling
- `ChatFactory`: Chat instance creation
- `MessageBuilder`: Message construction

## Features

### User Features
- Create account with role
- Join private/group chats
- Send/receive messages
- Real-time message notifications

### Admin Features
- Modify user permissions
- Manage group participants
- Monitor chat activities

### Chat Features
- Private messaging
- Group conversations
- Participant management
- Message history tracking

## Usage Example & Sample Output

### Example Code
```java
// Create services
UserService userService = new UserService();
ChatService chatService = new ChatService();

// Create users
User admin = userService.createUser("admin", new AdminRole());
User user1 = userService.createUser("Alice", new UserRole());
User user2 = userService.createUser("Bob", new UserRole());
User user3 = userService.createUser("Charlie", new UserRole());

// Create and use private chat
Chat privateChat = chatService.createPrivateChat(user1, user2);
chatService.sendMessage(privateChat, user1, "Hi Bob!");
chatService.sendMessage(privateChat, user2, "Hello Alice!");

// Create and use group chat
List<User> groupParticipants = new ArrayList<>(Arrays.asList(user1, user2, user3));
GroupChat groupChat = chatService.createGroupChat(groupParticipants, "Friends Group");
```

### Sample Output

1. **Private Chat Interactions**
```
Alice received: New message from Alice: Hi Bob!
Bob received: New message from Alice: Hi Bob!
Alice received: New message from Bob: Hello Alice!
Bob received: New message from Bob: Hello Alice!
```

2. **Group Chat Interactions**
```
Alice received: New message from Alice: Welcome everyone!
Bob received: New message from Alice: Welcome everyone!
Charlie received: New message from Alice: Welcome everyone!
Alice received: New message from Charlie: Hi all!
Bob received: New message from Charlie: Hi all!
Charlie received: New message from Charlie: Hi all!
```

3. **Admin Operations**
```
Admin removed Bob from the group chat
```

### Output Analysis
- **Real-time Notifications**: Each message triggers immediate notifications to all relevant participants
- **Private Chat**: Messages are delivered only to the two participants
- **Group Chat**: Messages are broadcast to all group members
- **Admin Controls**: Successful demonstration of admin privileges in managing group membership

## Technical Details

### Dependencies
- Java 8 or higher
- No external libraries required

### Package Structure
```
src/
├── models/
├── services/
└── patterns/
    ├── observer/
    └── singleton/
```

## Best Practices
- Implements SOLID principles
- Uses design patterns appropriately
- Follows clean code practices
- Maintains separation of concerns

## Future Enhancements
1. Persistence layer integration
2. Authentication system
3. Message encryption
4. File sharing capabilities
5. Read receipts