package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "Conturi")
public class Account implements Serializable {
    private Long nrcont;
    private double sold;
    private int idpers;

    public Account(){}

    public Account(long nrcont, double sold, int idpers) {
        this.nrcont = nrcont;
        this.sold = sold;
        this.idpers = idpers;
    }

    @Id
    public Long getNrcont() {
        return nrcont;
    }

    public void setNrcont(long nrcont) {
        this.nrcont = nrcont;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public int getIdpers() {
        return idpers;
    }

    public void setIdpers(int idpers) {
        this.idpers = idpers;
    }
}
