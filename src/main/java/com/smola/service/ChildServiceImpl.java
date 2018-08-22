package com.smola.service;

import com.smola.model.Child;
import com.smola.model.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    private FamilyService familyService;

    public ChildServiceImpl(FamilyService familyService) {
        this.familyService = familyService;
    }

    @Transactional
    public List<Child> readChild(Integer familyId) {
        Optional<Family> family = familyService.readFamily(familyId);
        return family.get().getChildren();
    }
}
