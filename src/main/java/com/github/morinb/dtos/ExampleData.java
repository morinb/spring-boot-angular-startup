package com.github.morinb.dtos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "ExampleData.findAll", query = "SELECT e FROM com.github.morinb.dtos.ExampleData e")
})
public class ExampleData {
    @Id
    private String key;
    private double value;

    public ExampleData() {
    }

    public ExampleData(String key, double value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
