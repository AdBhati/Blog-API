package com.bhati.demospringbootapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Eaccounts {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer salary;

    private Integer bonous;

    private Integer allowances;

    private Integer reimbursments;

    public Eaccounts() {
    }

    public Eaccounts(Integer id, Integer salary, Integer bonous, Integer allowances, Integer reimbursments) {
        this.id = id;
        this.salary = salary;
        this.bonous = bonous;
        this.allowances = allowances;
        this.reimbursments = reimbursments;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalary() {
        return this.salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getBonous() {
        return this.bonous;
    }

    public void setBonous(Integer bonous) {
        this.bonous = bonous;
    }

    public Integer getAllowances() {
        return this.allowances;
    }

    public void setAllowances(Integer allowances) {
        this.allowances = allowances;
    }

    public Integer getReimbursments() {
        return this.reimbursments;
    }

    public void setReimbursments(Integer reimbursments) {
        this.reimbursments = reimbursments;
    }

}
