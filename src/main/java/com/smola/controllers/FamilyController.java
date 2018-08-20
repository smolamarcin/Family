package com.smola.controllers;

import com.smola.model.Child;
import com.smola.model.Family;
import com.smola.model.Father;
import com.smola.model.RequestWrapper;
import com.smola.service.FamilyService;
import com.smola.service.FamilyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @PostMapping(value = "/createFamily")
    public ResponseEntity<Family> createFamily(@RequestBody Family family){
        return familyService.createFamily(family);
    }

    @GetMapping(value = "/readFamily")
    public ResponseEntity<?> readFamily(){
        return familyService.readFamily();
    }

    @GetMapping(value = "/readFather")
    public ResponseEntity<?> readFather(){
        return familyService.readFather();
    }

    @GetMapping(value = "/readChild")
    public ResponseEntity<?> readChild(){
        return familyService.readChild();
    }

    @GetMapping(value = "searchChild")
    public ResponseEntity<?> searchChild(){
        return familyService.searchChild();
    }

    @PutMapping(value = "/addFather")
    public ResponseEntity<?> addFatherToFamily(@RequestBody RequestWrapper requestWrapper){
        return familyService.addFatherToFamily(requestWrapper);
    }

    @PutMapping(value = "/addChild")
    public ResponseEntity<?> addChildToFamily(@RequestBody RequestWrapper requestWrapper){
        return familyService.addChildToFamily(requestWrapper);
    }
}
