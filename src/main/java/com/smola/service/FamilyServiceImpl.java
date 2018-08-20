package com.smola.service;

import com.smola.model.Child;
import com.smola.model.Family;
import com.smola.model.Father;
import com.smola.model.RequestWrapper;
import com.smola.repositories.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService {
    @Autowired
    private FamilyRepository familyRepository;

    public FamilyServiceImpl(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public ResponseEntity<?> addFatherToFamily(RequestWrapper requestWrapper) {
        Father father = requestWrapper.getFather();
        Family family = requestWrapper.getFamily();
        family.addFather(father);
        return ResponseEntity.status(HttpStatus.OK).body(familyRepository.save(family));
    }

    public ResponseEntity<?> addChildToFamily(RequestWrapper requestWrapper) {
        Family family = requestWrapper.getFamily();
        List<Child> children = requestWrapper.getChildren();
        children.forEach(family::addChild);
        return ResponseEntity.status(HttpStatus.OK).body(familyRepository.save(family));
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
