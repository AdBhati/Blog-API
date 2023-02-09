package com.bhati.demospringbootapp.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "personal")
public class Personal {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String address;
    private String city;

    @CreationTimestamp
    private Timestamp createdate;

    @UpdateTimestamp
    private Timestamp updatedate;

    public Personal(Integer id, String name, String address, String city, Timestamp createdate,
            UpdateTimestamp updatedateTimestamp) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Timestamp getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public Timestamp getUpdatedate() {
        return this.updatedate;
    }

    public void setUpdatedate(Timestamp updatedate) {
        this.updatedate = updatedate;
    }

}
