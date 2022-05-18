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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Master implements Serializable {
    
    // On peut définir des attributs grâce  cette annotation
    @XmlAttribute
    public int id;
    
    @XmlElement
    public String code;
    
    @XmlElement
    public String titre;

    public Master() {
    }

    public Master(int id, String code, String titre) {
        this.id = id;
        this.code = code;
        this.titre = titre;
    }

    @Override
    public String toString() {
        return '{' + titre + '}';
    }
    
    
    
}
