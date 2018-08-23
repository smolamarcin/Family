package com.smola.repositories;


import com.smola.model.Father;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatherRepository extends JpaRepository<Father, Integer> {
}
