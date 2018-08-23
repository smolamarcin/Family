package com.smola.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Father father;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            mappedBy = "family")
    @JsonManagedReference
    private List<Child> children = new ArrayList<>();

    public void addChild(Child child) {
        children.add(child);
        child.setFamily(this);
    }

    public void removeCHild(Child child) {
        children.remove(child);
        child.setFamily(null);
    }

    public void addFather(Father father) {
        this.father = father;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(father, family.father) &&
                Objects.equals(children, family.children);
    }

    @Override
    public int hashCode() {

        return Objects.hash(father, children);
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                '}';
    }
}
