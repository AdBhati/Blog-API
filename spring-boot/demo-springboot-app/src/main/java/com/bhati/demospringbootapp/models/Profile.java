package com.bhati.demospringbootapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.EnumType;
// import jakarta.persistence.Enumerated;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue
    private Integer id;

    // @Enumerated(EnumType.STRING)
    // @Column(length = 20)
    // private Eroles name;

    public Profile() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // public Eroles getName() {
    // return name;
    // }

    // public void setName(Eroles name) {
    // this.name = name;
    // }
}
