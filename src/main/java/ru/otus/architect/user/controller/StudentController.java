package ru.otus.architect.user.controller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.architect.user.model.Student;

import java.util.Random;

@Log
@RestController
@RequestMapping("student/{name}")
public class StudentController {

    private static final Random RAND = new Random();

    @RequestMapping(value = "getScore", method = RequestMethod.GET)
    public Integer score(@PathVariable("name")String name) {
        return RAND.nextInt(RAND.ints(1, 10)
                .findFirst().orElse(-1));
    }

    @RequestMapping(value = "getInfo", method = RequestMethod.GET)
    public Student info(@PathVariable("name")String name) {
        return Student.builder()
                .firstName(name)
                .secondName(name)
                .score(RAND.nextInt(RAND.ints(1, 10)
                        .findFirst().orElse(-1)))
                .build();
    }

}