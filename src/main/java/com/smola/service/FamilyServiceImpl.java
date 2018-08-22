package com.smola.service;

import com.smola.model.Child;
import com.smola.model.Family;
import com.smola.model.Father;
import com.smola.repositories.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FamilyServiceImpl implements FamilyService {
    private FamilyRepository familyRepository;

    @Autowired
    public FamilyServiceImpl(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
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
    public Optional<List<Family>> findByChildParams(Map<String,String> params) {
        Map<String, String> paramsToLowerCase = params.keySet()
                .stream()
                .collect(Collectors.toMap(String::toLowerCase, params::get));

        String firstName = paramsToLowerCase.get("firstName");
        String childSecondName = paramsToLowerCase.get("childSecondName");
        String pesel  = paramsToLowerCase.get("pesel");
        String childSex = paramsToLowerCase.get("childsex");
        return this.familyRepository.findFamilyByMultipleChildrenAndFatherParams(firstName,childSecondName,pesel,childSex);
    }
}
