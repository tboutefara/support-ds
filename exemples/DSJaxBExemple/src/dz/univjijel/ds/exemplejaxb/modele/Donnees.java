/*
 * Université de Jijel
 * Faculté des Sciences Exactes et d'Informatique
 * Département d'Informatique
 * 3ème Année Licence - Informatique
 * Données Semi-structurées (DS)
 * Exemple : l'utilisation de JAXB pour manipuler les fichiers XML 
 * (Mapping XMl - Objets)
 */
package dz.univjijel.ds.exemplejaxb.modele;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// La racine de notre fichier parce que nous avons plusieurs départements
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "departements")
public class Donnees {
    
    @XmlElement(name = "departement")
    List<Departement> departements;

    public Donnees() {
    }

    public Donnees(List<Departement> departements) {
        this.departements = departements;
    }

    @Override
    public String toString() {
        return '{' + departements.toString() + '}';
    }
    
}
