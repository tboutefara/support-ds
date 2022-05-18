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
import javax.xml.bind.Unmarshaller;

public class LireXML {

    public static Donnees lireXML(String fichier) throws JAXBException {
        // Le contexte est toujours créé, pour la lecture et pur la créatin
        // Le contexte doit connaître l'objet correspondant
        JAXBContext jaxbC = JAXBContext.newInstance(Donnees.class);
        
        // le Unmarshaller fait l'inverse du Marshaller (de triage et la garde de l'ordre)
        Unmarshaller jaxbU = jaxbC.createUnmarshaller();
        
        // La lecture du fichier et la création de l'objet
        Donnees donnees = (Donnees) jaxbU.unmarshal(new File(fichier));
        return donnees;
    }

}
