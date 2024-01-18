package ru.ld.springBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ld.springBoot.model.User;
import ru.ld.springBoot.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/user") // localhost:8080/user
public class UserController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<User> userList() {
        return registrationService.getDataProcessingService().getUserRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        return registrationService.processRegistration(user);
    }

    /**
     * Метод добавления юзера через браузер в формате http://localhost:8080/user/body/sergey-21-1234@mail.ru
     * @param user формируем объект user из параметров, принятых на вход
     * @return возвращаем текст о том, что юзер создан
     */
    @RequestMapping("/body/{name}-{age}-{email}") // регистрация в карте обработчиков
    public String userAddFromHTML(@ModelAttribute("user") User user){
        return registrationService.processRegistration(user);
    }
}
