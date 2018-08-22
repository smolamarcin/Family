package com.smola.service;

import com.smola.model.Child;

import java.util.List;

public interface ChildService {
    List<Child> readChild(Integer familyId);
}
