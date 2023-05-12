/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.univjijel.ds.controletp02.model;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Client {
    
    int id;
    String nomComplet;
    String nTel;
    String adresse;

    public Client() {
    }

    public Client(int id, String nomComplet, String nTel, String adresse) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.nTel = nTel;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getnTel() {
        return nTel;
    }

    public void setnTel(String nTel) {
        this.nTel = nTel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
}
