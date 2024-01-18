package ru.ld.springBoot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ld.springBoot.model.User;
import ru.ld.springBoot.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks") // localhost:8080/tasks
public class TaskController {

    @Autowired
    private DataProcessingService dataProcessingService;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUsersByAge(){
        return dataProcessingService.sortUserByAge(dataProcessingService.getUserRepository().getUsers());
    }

    /**
     * Метод возвращает отфильтрованный список юзеров по возрасту (старше заданного значения)
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age) {
        return dataProcessingService.filterUserByAge(dataProcessingService.getUserRepository().getUsers(), age);
    }

    /**
     * Метод возвращает среднее арифметическое возратов юзеров
     */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        return dataProcessingService.calculateAge(dataProcessingService.getUserRepository().getUsers());
    }
}
