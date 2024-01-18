package ru.ld.springBoot.services;

import org.springframework.stereotype.Service;
import ru.ld.springBoot.model.User;

@Service
public class NotificationService {
    public String notifyUser(User user) {
        String message = "A new user has been created: " + user.getName();
        System.out.println(message);
        return message;
    }
}
