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
            + "where(:firstName is null or chi.firstName = :firstName) "
            + "and (:secondName is null or chi.secondName = :secondName)"
            + "and (:pesel is null or chi.pesel = :pesel)"
            + "and (:childSex is null or chi.sex = :childSex)")
    Optional<List<Family>> findByChildren_FirstName(@Param("firstName") String firstName,
                                                    @Param("secondName") String secondName,
                                                    @Param("pesel") String pesel,
                                                    @Param("childSex") String childSex);

}
