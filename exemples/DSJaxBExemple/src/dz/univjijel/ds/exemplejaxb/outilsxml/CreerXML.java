/*
 * Université de Jijel
 * Faculté des Sciences Exactes et d'Informatique
 * Département d'Informatique
 * 3ème Année Licence - Informatique
 * Données Semi-structurées (DS)
 * Exemple : l'utilisation de JAXB pour manipuler les fichiers XML 
 * (Mapping XMl - Objets)
 */
package dz.univjijel.ds.exemplejaxb.outilsxml;

import dz.univjijel.ds.exemplejaxb.modele.Donnees;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

public class CreerXML {

    public static void creerXml(Donnees donnees, String fichier) throws PropertyException, JAXBException {
        // Le contexte est toujours créé, pour la lecture et pur la créatin
        // Le contexte doit connaître l'objet correspondant
        JAXBContext jaxbC = JAXBContext.newInstance(Donnees.class);
        
        // L'objet qui fait la traduction Objet --> XML s'appelle Marshaller
        Marshaller jaxbM = jaxbC.createMarshaller();
        
        // Une simple mise en forme
        jaxbM.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        //Création du fichier
        jaxbM.marshal(donnees, new File(fichier));
        
        // Un simple affichage, pas obligatire
        jaxbM.marshal(donnees, System.out);
    }

}
