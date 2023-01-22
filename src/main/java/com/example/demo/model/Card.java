package com.example.demo.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Carduri")
public class Card implements Serializable {

    private Long nrcard;
    private Date data_de_la;
    private Date data_la;
    private double limita;
    private Long nrcont;
    private String tip;
    private String categorie;

    public Card() {
    }

    @Id
    public Long getNrcard() {
        return nrcard;
    }

    public void setNrcard(Long nrcard) {
        this.nrcard = nrcard;
    }

    public Date getData_de_la() {
        return data_de_la;
    }

    public void setData_de_la(Date data_de_la) {
        this.data_de_la = data_de_la;
    }

    public Date getData_la() {
        return data_la;
    }

    public void setData_la(Date data_la) {
        this.data_la = data_la;
    }

    public double getLimita() {
        return limita;
    }

    public void setLimita(double limita) {
        this.limita = limita;
    }

    public Long getNrcont() {
        return nrcont;
    }

    public void setNrcont(Long nrcont) {
        this.nrcont = nrcont;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
