package com.smola.controllers;

import com.smola.model.Father;
import com.smola.service.FatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FatherController {
    private FatherService fatherService;

    public FatherController(FatherService fatherService) {
        this.fatherService = fatherService;
    }
    @GetMapping(value = "/father/{fatherId}")
    public ResponseEntity<Father> readFather(@PathVariable Integer fatherId) {
        return this.fatherService.readFather(fatherId)
                .map(f -> ResponseEntity.status(HttpStatus.FOUND).body(f))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
