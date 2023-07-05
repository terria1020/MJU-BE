package com.project.db.mju.webserver.web.v2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "v2HomeController")
@RequestMapping("/api/v2")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

}
