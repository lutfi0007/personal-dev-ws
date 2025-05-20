package com.example.roundrobin.service;

import com.example.roundrobin.model.User;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Arrays;

@Service
public class UserService {
    private final List<User> users;
    private final AtomicInteger currentIndex;

    public UserService() {
        // Initialize with mock users
        this.users = Arrays.asList(
            new User(1L, "John Doe", "john@example.com"),
            new User(2L, "Jane Smith", "jane@example.com"),
            new User(3L, "Bob Johnson", "bob@example.com"),
            new User(4L, "Alice Brown", "alice@example.com"),
            new User(5L, "Charlie Wilson", "charlie@example.com")
        );
        this.currentIndex = new AtomicInteger(0);
    }

    public User getNextUser() {
        int index = currentIndex.getAndIncrement() % users.size();
        return users.get(index);
    }

    public List<User> getAllUsers() {
        return users;
    }
} 