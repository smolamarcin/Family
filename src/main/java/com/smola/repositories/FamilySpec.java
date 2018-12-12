package com.smola.repositories;

import com.smola.model.Family;
import com.smola.util.RequestParams;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@And({
        @Spec(path = "firstName", spec = Like.class),
        @Spec(path = "secondName", spec = Like.class),
        @Spec(path = "pesel", spec = Like.class),
        @Spec(path = "childSex", spec = Like.class)
})

public interface FamilySpec extends Specification<Family> {
}
