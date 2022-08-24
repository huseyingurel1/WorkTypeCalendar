package com.solmazDeneme.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String personDay;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "days")
    @ToString.Exclude
    private Set<User> users = new HashSet<>();

    public Day(String name) {
        this.personDay = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Day day = (Day) o;
        return id != null && Objects.equals(id, day.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

