/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.univjijel.ds.exemplexml;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Main {
    
    public static String FICHIER = "exemple.xml";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Configuration c = GestionnaireXML.lireXML();
        (new MainFrame(c)).setVisible(true);
    }
    
}
