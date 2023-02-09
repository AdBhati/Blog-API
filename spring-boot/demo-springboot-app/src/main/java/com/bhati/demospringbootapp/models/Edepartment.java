package com.bhati.demospringbootapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Edepartment {

    @Id
    @GeneratedValue
    private Integer id;

    private String department_name;

    public Edepartment() {
    }

    public Edepartment(Integer id, String department_name) {
        this.id = id;
        this.department_name = department_name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment_name() {
        return this.department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

}
