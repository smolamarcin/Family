package com.smola.service;

import com.smola.model.Father;
import com.smola.repositories.FatherRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FatherServiceImpl implements FatherService {
    private FatherRepository fatherRepository;

    public FatherServiceImpl(FatherRepository fatherRepository) {
        this.fatherRepository = fatherRepository;
    }

    @Override
    public Optional<Father> readFather(Integer id) {
        return fatherRepository.findById(id);
    }
}
