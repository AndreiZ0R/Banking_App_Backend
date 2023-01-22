package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Persoane")
public class User implements Serializable {

    private int idpers;
    private String nume;
    private String adresa;
    private char gen;
    private Date data_nasterii;
    private String email;

    public User() {
    }

    public User(int idpers, String nume, String adresa, char gen, Date data_nasterii, String email) {
        this.idpers = idpers;
        this.nume = nume;
        this.adresa = adresa;
        this.gen = gen;
        this.data_nasterii = data_nasterii;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdpers() {
        return idpers;
    }

    public void setIdpers(int idpers) {
        this.idpers = idpers;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public char getGen() {
        return gen;
    }

    public void setGen(char gen) {
        this.gen = gen;
    }

    public Date getData_nasterii() {
        return data_nasterii;
    }

    public void setData_nasterii(Date data_nasterii) {
        this.data_nasterii = data_nasterii;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
