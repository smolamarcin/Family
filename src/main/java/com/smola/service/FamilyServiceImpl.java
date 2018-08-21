package com.smola.service;

import com.smola.model.Family;
import com.smola.model.Father;
import com.smola.repositories.FamilyRepository;
import com.smola.repositories.FatherRepository;
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

    @Autowired
    private FatherRepository fatherRepository;

    public FamilyServiceImpl(FamilyRepository familyRepository,
                             FatherRepository fatherRepository) {
        this.familyRepository = familyRepository;
        this.fatherRepository = fatherRepository;
    }

    public ResponseEntity<?> addFatherToFamily(Integer familyId, Father father) {
        Optional<Family> family = familyRepository.findById(familyId);
        return family.map(e -> {
            //todo; shall I have double binding for family-father relationship?
            // Do I need double return statemetne here?
            Family foundedFamily = family.get();
            foundedFamily.addFather(father);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(familyRepository.save(foundedFamily));
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    public ResponseEntity<?> addChildToFamily() {
        throw new NotImplementedException();
    }


    public ResponseEntity<?> readFamily(Integer familyId) {
        Optional<Family> family = familyRepository.findById(familyId);
        return family
                .map(e -> ResponseEntity.status(HttpStatus.FOUND).body(e))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
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
