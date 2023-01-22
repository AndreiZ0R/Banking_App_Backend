package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "Miscari")
public class Moving implements Serializable {
    private Long nrcard;
    private Timestamp data_ora;
    private double valoare;
    private String scop;


    public Moving() {
    }

    public Moving(Long nrcard, Timestamp data_ora, double valoare, String scop) {
        this.nrcard = nrcard;
        this.data_ora = data_ora;
        this.valoare = valoare;
        this.scop = scop;
    }

    @Id
    public Long getNrcard() {
        return nrcard;
    }

    public void setNrcard(Long nrcard) {
        this.nrcard = nrcard;
    }

    public Timestamp getData_ora() {
        return data_ora;
    }

    public void setData_ora(Timestamp data_ora) {
        this.data_ora = data_ora;
    }

    public double getValoare() {
        return valoare;
    }

    public void setValoare(double valoare) {
        this.valoare = valoare;
    }

    public String getScop() {
        return scop;
    }

    public void setScop(String scop) {
        this.scop = scop;
    }
}
