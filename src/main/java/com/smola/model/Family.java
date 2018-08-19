package com.smola.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.CascadeType.*;

@Entity
@NoArgsConstructor
@Getter
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private Father father;


    @OneToMany(mappedBy = "family",
            cascade = ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Child> children = new ArrayList();

    public void addChild(Child child) {
        children.add(child);
        child.setFamily(this);
    }

    public void removeChild(Child child) {
        children.remove(child);
        child.setFamily(null);
    }

    public void addFather(Father father){
        this.father = father;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(id, family.id) &&
                Objects.equals(father, family.father) &&
                Objects.equals(children, family.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, father, children);
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", father=" + father +
                ", children=" + children +
                '}';
    }
}
