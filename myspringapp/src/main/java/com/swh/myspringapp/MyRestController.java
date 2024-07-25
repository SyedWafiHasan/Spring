package com.swh.myspringapp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @Value("${coach.name}")
    String coachName;

    @Value("${team.name}")
    String teamName;

    @GetMapping("/") // exposes / that will return hello world
    public String sayHello() {
        return "Hello world 123!";
    }

    //exposing new endpoint to test
    @GetMapping("/test")
    public String testHealth() {
        return "It works!";
    }

    @GetMapping("/custom")
    public String customPropertiesInjection() {
        return "Coach: " + coachName + "\n" + "Team Name: " + teamName;
    }
}
