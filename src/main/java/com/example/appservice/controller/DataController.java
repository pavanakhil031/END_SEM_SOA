package com.example.appservice.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @GetMapping("/api/data")
    public Map<String, Object> getData() {
        return Map.of(
            "message", "Microservice is running successfully!",
            "application", "app-service",
            "status", "UP"
        );
    }
}
