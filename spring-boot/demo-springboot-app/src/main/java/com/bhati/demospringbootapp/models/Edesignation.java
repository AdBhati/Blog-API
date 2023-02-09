package com.bhati.demospringbootapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "designation")
public class Edesignation {

    @Id
    @GeneratedValue
    private Integer id;

    private String designation_name;

    public Edesignation() {
    }

    public Edesignation(Integer id, String designation_name) {
        this.id = id;
        this.designation_name = designation_name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation_name() {
        return this.designation_name;
    }

    public void setDesignation_name(String designation_name) {
        this.designation_name = designation_name;
    }

}
