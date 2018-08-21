package com.smola.service;

import com.smola.model.Family;
import com.smola.model.Father;
import org.springframework.http.ResponseEntity;

public interface FamilyService {
    ResponseEntity<?> addFatherToFamily(Integer familyId, Father father);

    ResponseEntity<?> addChildToFamily();


    ResponseEntity<?> readFamily(Integer familyId);

    ResponseEntity<?> readFather();

    ResponseEntity<?> readChild();

    ResponseEntity<?> searchChild();

    ResponseEntity<Family> createFamily(Family family);
}
