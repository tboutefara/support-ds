/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarekboutefara.exemplejaxb.main;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Main {

    public static void main(String[] args) {
        try {
            File fichier = new File("etudiant.xml");
            
            JAXBContext contexte = JAXBContext.newInstance(Etudiant.class);
            Marshaller marshaller = contexte.createMarshaller();
            
            Etudiant etudiant = new Etudiant(1, "Benomar", "Omar");
            marshaller.marshal(etudiant, fichier);
        } catch (JAXBException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
