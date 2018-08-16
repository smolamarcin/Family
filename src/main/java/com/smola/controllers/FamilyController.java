package com.smola.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class FamilyController {

    @Autowired
    private Environment environment;

    @GetMapping("/")
    public String hello() throws UnknownHostException {
        String datePattern = "dd/MM/yyyy HH:mm:ss";
        DateTimeFormatter df = DateTimeFormatter.ofPattern(datePattern);
        LocalDateTime now = LocalDateTime.now();

        String hostName = InetAddress.getLocalHost().getHostName();
        String port = environment.getProperty("local.server.port");

        return " Do you speak whale? - Web server @ " + df.format(now) + " Host: " + hostName + " port: " + port;
    }
}
