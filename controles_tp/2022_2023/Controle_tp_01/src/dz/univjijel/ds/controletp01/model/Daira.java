/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.univjijel.ds.controletp01.model;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Daira {
    
    String nom;
    int codePostal;

    public Daira() {
    }

    public Daira(String nom, int codePostal) {
        this.nom = nom;
        this.codePostal = codePostal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }
    
}
