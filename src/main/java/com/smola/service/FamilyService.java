package com.smola.service;

import com.smola.model.Family;
import org.springframework.http.ResponseEntity;

public interface FamilyService {
    ResponseEntity<?> addFatherToFamily();

    ResponseEntity<?> addChildToFamily();


    ResponseEntity<?> readFamily();

    ResponseEntity<?> readFather();

    ResponseEntity<?> readChild();

    ResponseEntity<?> searchChild();

    ResponseEntity<Family> createFamily(Family family);
}
