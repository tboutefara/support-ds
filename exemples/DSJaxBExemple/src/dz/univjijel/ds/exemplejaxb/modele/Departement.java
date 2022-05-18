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

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

// La classe doit implémenter l'interface Serializable.
// Cette interface ne définit pas de méthodes.

// On puvons définir le mode d'accès : par champs ou par propriété (setters et getters)
@XmlAccessorType(XmlAccessType.FIELD)
public class Departement implements Serializable {
    
    // Cet attribut sera ignoré et ne sera pas sauvegardé dans le fichier XML
    @XmlTransient
    public int id;
    
    // On peut définir un nom différent de nom donné à l'attribut
    @XmlElement(name = "nom")
    public String nomDepartement;
    
    // On peut définir la hiérarchie en utilisant la composition des objets
    // On peut définir la balise qui va regrouper la liste des noeuds fils
    @XmlElement(name = "master")
    @XmlElementWrapper(name = "masters")
    public List<Master> masters;

    public Departement() {
    }

    public Departement(int id, String nomDepartement, List<Master> masters) {
        this.id = id;
        this.nomDepartement = nomDepartement;
        this.masters = masters;
    }

    @Override
    public String toString() {
        return '{' + nomDepartement + " " + masters + '}';
    }
    
    
}
