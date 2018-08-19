package com.smola.service;

import com.smola.model.Child;
import com.smola.model.Family;
import com.smola.model.Father;
import org.springframework.http.ResponseEntity;

public interface FamilyService {
    ResponseEntity<Family> addFatherToFamily(Family family,Father father);

    ResponseEntity<?> addChildToFamily(Child child);


    ResponseEntity<?> readFamily();

    ResponseEntity<?> readFather();

    ResponseEntity<?> readChild();

    ResponseEntity<?> searchChild();

    ResponseEntity<Family> createFamily(Family family);
}
