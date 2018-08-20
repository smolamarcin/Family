package com.smola.service;

import com.smola.model.Family;
import com.smola.model.RequestWrapper;
import org.springframework.http.ResponseEntity;

public interface FamilyService {
    ResponseEntity<?> addFatherToFamily(RequestWrapper requestWrapper);

    ResponseEntity<?> addChildToFamily(RequestWrapper child);


    ResponseEntity<?> readFamily();

    ResponseEntity<?> readFather();

    ResponseEntity<?> readChild();

    ResponseEntity<?> searchChild();

    ResponseEntity<Family> createFamily(Family family);
}
