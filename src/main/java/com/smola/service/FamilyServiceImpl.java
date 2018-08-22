package com.smola.service;

import com.smola.model.Child;
import com.smola.model.Family;
import com.smola.model.Father;
import com.smola.repositories.FamilyRepository;
import com.smola.repositories.FatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public boolean addFatherToFamily(Integer familyId, Father father) {
        Optional<Family> family = familyRepository.findById(familyId);
        family.ifPresent(e -> e.addFather(father));
        return family.isPresent();
    }

    @Transactional
    public boolean addChildToFamily(Integer familyId, Child child) {
        Optional<Family> family = familyRepository.findById(familyId);
        family.ifPresent(f -> f.addChild(child));
        return family.isPresent();
    }


    public Optional<Family> readFamily(Integer familyId) {
        return familyRepository.findById(familyId);
    }

    public Optional<Father> readFather(Integer fatherId) {
        return fatherRepository.findById(fatherId);
    }


    @Transactional
    public Family createFamily(Family family) {
        return familyRepository.save(family);
    }
}
