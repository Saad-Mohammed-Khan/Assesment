package com.mindex.challenge.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Compensation {
    private String id;
    private Employee employee;
    private Double salary;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date effectiveDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
