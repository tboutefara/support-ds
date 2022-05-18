/*
 * Université de Jijel
 * Faculté des Sciences Exactes et d'Informatique
 * Département d'Informatique
 * 3ème Année Licence - Informatique
 * Données Semi-structurées (DS)
 * Exemple : l'utilisation de JAXB pour manipuler les fichiers XML 
 * (Mapping XMl - Objets)
 */
package dz.univjijel.ds.exemplejaxb.main;

import dz.univjijel.ds.exemplejaxb.modele.Departement;
import dz.univjijel.ds.exemplejaxb.modele.Donnees;
import dz.univjijel.ds.exemplejaxb.modele.Master;
import dz.univjijel.ds.exemplejaxb.outilsxml.CreerXML;
import dz.univjijel.ds.exemplejaxb.outilsxml.LireXML;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fichier = "exemple.xml";
        
        List<Master> mastersInformatique = Arrays.asList(
                new Master(1, "SIAD", "Systèmes d'Information d'Aide à la Décision"),
                new Master(2, "RetS", "Réseaux et Sécurité")
        );
        
        List<Master> mastersMaths = Arrays.asList(
                new Master(1, "MA", "Mathématiques Appliquées"),
                new Master(2, "Stat", "Statistiques")
        );
        
        Departement informatique = new Departement(1, "Informatique", mastersInformatique);
        Departement maths = new Departement(2, "Mathématiques", mastersMaths);
        
        Donnees donnees = new Donnees(Arrays.asList(informatique, maths));
        
        try {
            CreerXML.creerXml(donnees, fichier);
        } catch (JAXBException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("\n\n -------------------------- \n\n");
        
        try {
            Donnees donneesLues = LireXML.lireXML(fichier);
            System.out.println(donneesLues);
        } catch (JAXBException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
