package com.smola.controllers;

import com.smola.model.Child;
import com.smola.service.ChildService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChildController {
    private ChildService childService;

    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping(value = "/children/{familyId}")
    public HttpEntity<List<Child>> readChild(@PathVariable Integer familyId) {
        return ResponseEntity.ok().body(this.childService.readChild(familyId));
    }

}


