package com.smola.service;

import com.smola.model.Child;
import com.smola.model.Family;
import com.smola.model.Father;
import com.smola.repositories.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;

@Service
public class FamilyServiceImpl implements FamilyService {
    @Autowired
    private FamilyRepository familyRepository;

    public FamilyServiceImpl(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public ResponseEntity<Family> addFatherToFamily(Family family, Father father) {
        family.addFather(father);
        return ResponseEntity.status(HttpStatus.OK).body(familyRepository.save(family));
    }

    public ResponseEntity<?> addChildToFamily(Child child) {
        throw new NotImplementedException();
    }


    public ResponseEntity<?> readFamily() {
        throw new NotImplementedException();
    }

    public ResponseEntity<?> readFather() {
        throw new NotImplementedException();
    }

    public ResponseEntity<?> readChild() {
        throw new NotImplementedException();
    }

    public ResponseEntity<?> searchChild() {
        throw new NotImplementedException();
    }

    public ResponseEntity<Family> createFamily(Family family) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(familyRepository.save(family));
    }
}
