package com.smola.service;

import com.smola.model.Child;
import com.smola.model.Family;
import com.smola.model.Father;
import com.smola.repositories.FamilyRepository;
import com.smola.repositories.FamilySpec;
import com.smola.util.Parser;
import com.smola.util.RequestParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FamilyServiceImpl implements FamilyService {
    private FamilyRepository familyRepository;
    private Parser parser;

    @Autowired
    public FamilyServiceImpl(FamilyRepository familyRepository, Parser parser) {
        this.familyRepository = familyRepository;
        this.parser = parser;
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

    @Transactional
    public Family createFamily(Family family) {
        return familyRepository.save(family);
    }

    @Override
    public List<Family> readFamily() {
        return familyRepository.findAll();
    }

    @Override
    public List<Family> findByChildParams(FamilySpec familySpec) {
        return familyRepository.findAll(familySpec);
    }
}
