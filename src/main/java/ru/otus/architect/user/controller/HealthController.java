package ru.otus.architect.user.controller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.architect.user.model.HealthCheck;

import java.util.UUID;

import static java.util.Optional.ofNullable;

@Log
@RestController
public class HealthController {

    private static final UUID SVC_UUID = UUID.randomUUID();
    private static final String SVC_NAME = ofNullable(System.getenv("SVC_NAME")).orElse("UNNAMED");

    @RequestMapping(value = "health", method = RequestMethod.GET)
    public HealthCheck health() {
        HealthCheck hc = new HealthCheck("OK", SVC_UUID, SVC_NAME);
        log.fine("HEALTH CHECK: " + hc);
        return hc;
    }

}
