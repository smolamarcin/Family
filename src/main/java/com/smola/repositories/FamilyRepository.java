package com.smola.repositories;

import com.smola.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Integer> {
    @Query("select c "
            + "from  Family fam "
            + "inner join fam.children chi "
            + "inner join chi.family c "
            + "where((:firstname is null or chi.firstName = :firstname) "
            + "and (:secondname is null or chi.secondName = :secondname)"
            + "and (:pesel is null or chi.pesel = :pesel)"
            + "and (:childsex is null or chi.sex = :childsex))")
    Optional<List<Family>> findFamilyByMultipleChildrenAndFatherParams(@Param("firstname") String firstName,
                                                                       @Param("secondname") String secondName,
                                                                       @Param("pesel") String pesel,
                                                                       @Param("childsex") String childSex);

}
