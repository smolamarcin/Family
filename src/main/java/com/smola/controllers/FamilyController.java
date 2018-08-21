package com.smola.controllers;

import com.smola.model.Child;
import com.smola.model.Family;
import com.smola.model.Father;
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

    @PostMapping(value = "/family")
    public ResponseEntity<Family> createFamily(@RequestBody Family family) {
        return familyService.createFamily(family);
    }

    @GetMapping(value = "/family/{familyId}")
    public ResponseEntity<?> readFamily(@PathVariable Integer familyId) {
        return familyService.readFamily(familyId);
    }

    @PutMapping(value = "/family/{familyId}/father")
    public ResponseEntity<?> addFatherToFamily(@PathVariable Integer familyId,
                                               @RequestBody Father father) {
        return familyService.addFatherToFamily(familyId,father);
    }

    @GetMapping(value = "/readFather")
    public ResponseEntity<?> readFather() {
        return familyService.readFather();
    }

    @GetMapping(value = "/readChild")
    public ResponseEntity<?> readChild() {
        return familyService.readChild();
    }

    @GetMapping(value = "searchChild")
    public ResponseEntity<?> searchChild() {
        return familyService.searchChild();
    }

    @PutMapping(value = "/addChild")
    public ResponseEntity<?> addChildToFamily() {
        return familyService.addChildToFamily();
    }
}
