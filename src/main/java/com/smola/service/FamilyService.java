package com.smola.service;

import com.smola.model.Child;
import com.smola.model.Family;
import com.smola.model.Father;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface FamilyService {
    boolean addFatherToFamily(Integer familyId, Father father);

    boolean addChildToFamily(Integer familyId, Child child);


    Optional<Family> readFamily(Integer familyId);

    Optional<Father> readFather(Integer fatherId);


    Family createFamily(Family family);
}
