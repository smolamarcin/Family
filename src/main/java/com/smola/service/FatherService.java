package com.smola.service;

import com.smola.model.Father;

import java.util.Optional;

public interface FatherService {
    Optional<Father> readFather(Integer id);
}
