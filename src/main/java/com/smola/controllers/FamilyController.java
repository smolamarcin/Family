package com.smola.controllers;

import com.smola.model.Child;
import com.smola.model.Family;
import com.smola.model.Father;
import com.smola.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @PostMapping
    public HttpEntity<Family> createFamily(@RequestBody Family family) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.familyService.createFamily(family));
    }

    @GetMapping(value = "/family/{familyId}")
    public HttpEntity<Family> readFamily(@PathVariable Integer familyId) {
        return this.familyService.readFamily(familyId)
                .map(f -> ResponseEntity.status(HttpStatus.FOUND).body(f))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(value = "family/all")
    public HttpEntity<List<Family>> readFamily() {
        return ResponseEntity.ok().body(this.familyService.readFamily());
    }

    @PostMapping(value = "/family/{familyId}/father")
    public HttpEntity<Father> addFatherToFamily(@PathVariable Integer familyId,
                                                @RequestBody Father father) {
        if (this.familyService.addFatherToFamily(familyId, father)) {
            return ResponseEntity.status(HttpStatus.OK).body(father);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping(value = "/family/{familyId}/child")
    public ResponseEntity<Child> addChildToFamily(@PathVariable Integer familyId,
                                                  @RequestBody Child child) {
        if (this.familyService.addChildToFamily(familyId, child)) {
            return ResponseEntity.status(HttpStatus.OK).body(child);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping(value = "/family")
    public ResponseEntity<List<Family>> findFamiliesByChildParams(@RequestParam Map<String,String> params) {

        return this.familyService.findByChildParams(params)
                .map(f -> ResponseEntity.status(HttpStatus.FOUND).body(f))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
