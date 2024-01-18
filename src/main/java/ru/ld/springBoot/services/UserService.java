package ru.ld.springBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ld.springBoot.model.User;

@Service
public class UserService {

    @Autowired
    private NotificationService notificationService;

    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setEmail(email);
        notificationService.notifyUser(user); // сообщение о создании пользователя
        return user;
    }
}
