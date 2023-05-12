/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.univjijel.ds.controletp01.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Wilaya {
    
    int code;
    String nom;
    
    List<Daira> dairas;

    public Wilaya() {
    }

    public Wilaya(int code, String nom) {
        this.code = code;
        this.nom = nom;
        dairas = new ArrayList<>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Daira> getDairas() {
        return dairas;
    }

    public void setDairas(List<Daira> dairas) {
        this.dairas = dairas;
    }
    
}
