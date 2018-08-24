package com.smola.service;

import com.smola.model.Child;
import com.smola.model.Family;
import com.smola.model.Father;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FamilyService {
    boolean addFatherToFamily(Integer familyId, Father father);

    boolean addChildToFamily(Integer familyId, Child child);


    Optional<Family> readFamily(Integer familyId);



    Family createFamily(Family family);

    List<Family> readFamily();

    List<Family> findByChildParams(Map<String,String> params);
}
