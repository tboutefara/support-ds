/*
 * Université de Jijel
 * Faculté des sciences exactes et d'informatique
 * Département d'Informatique
 * 3ème Année Licence
 * Données Semi-Structurées - Corrigé de TP 03
 */
package dz.univjijel.ds.lirexml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * Cette classe contient la méthode qui lit le fichier XML.
 * Mettre ces méthodes dans une classe séparée permet une meilleure maintenance 
 * du code.
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class GestionnaireXML {

    /**
     * Cette méthode lit le fichier XML.
     * Les données sont encapsulées sous forme d'un objet configuration.
     * @return L'bjet configuration qui contient les données du fichier.
     */
    public static Configuration lireXML() {
        
        // Préparation de l'objet qui va contenir les données
        Configuration c = new Configuration();

        try {
            // Création du document. Pour cela, nous aurons besoins d'un DocumentBuilder.
            // Pour créer ce dernier nous aurons besoin d'un DocumentBuilderFactory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            // Le document est créé à partir d'un fichier
            // Main.FICHIER contient le chemin du fichier à lire
            Document d = db.parse(new File(Main.FICHIER));

            // Lecture de la racine puis la navigation vers les différents noeuds
            Element racine = d.getDocumentElement();
            Element bdd = (Element) racine.getFirstChild();
            Element server = (Element) racine.getLastChild();
            
            Element url = (Element) bdd.getFirstChild();
            Element user = (Element) url.getNextSibling();
            Element password = (Element) user.getNextSibling();
            
            Element port = (Element) server.getFirstChild();
            
            // Extraction du contenu des balise pour initialiser les attributs
            // de l'objet Configuration à returner
            c.setUrl(url.getTextContent());
            c.setUser(user.getTextContent());
            c.setPassword(password.getTextContent());
            
            c.setPort(port.getTextContent());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GestionnaireXML.class.getName()).log(Level.SEVERE, null, ex);
            c = null;
        } catch (SAXException ex) {
            Logger.getLogger(GestionnaireXML.class.getName()).log(Level.SEVERE, null, ex);
            c = null;
        } catch (IOException ex) {
            Logger.getLogger(GestionnaireXML.class.getName()).log(Level.SEVERE, null, ex);
            c = null;
        }
        
        return c;
    }

}
