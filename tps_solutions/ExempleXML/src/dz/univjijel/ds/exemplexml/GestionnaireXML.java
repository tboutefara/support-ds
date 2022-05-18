/*
 * Université de Jijel
 * Faculté des sciences exactes et d'informatique
 * Département d'Informatique
 * 3ème Année Licence
 * Données Semi-Structurées - Corrigé de TP 03
 */
package dz.univjijel.ds.exemplexml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * Cette classe contient les méthodes qui interagissent avec le fichier XML.
 * Mettre ces méthodes dans une classe séparée permet une meilleure maintenance 
 * du code.
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class GestionnaireXML {

    /**
     * Cette méthode crée un fichier XML.
     * Les balises sont remplies à partir des données contenues dans l'objet
     * configuration.
     * @param configuration Le contenu à mettre dans le fichier
     * @return Vrai si le fichier est créé avec succès, Faux autrement.
     */
    public static boolean creerXML(Configuration configuration) {
        
        boolean ok = true;

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.newDocument();

            Element racine = d.createElement("configuration");
            d.appendChild(racine);

            Element bdd = d.createElement("bdd");
            Element url = d.createElement("url");
            Element user = d.createElement("user");
            Element password = d.createElement("password");

            Element server = d.createElement("server");
            Element port = d.createElement("port");

            url.appendChild(d.createTextNode(configuration.getUrl()));
            user.appendChild(d.createTextNode(configuration.getUser()));
            password.appendChild(d.createTextNode(configuration.getPassword()));

            port.appendChild(d.createTextNode(configuration.getPort()));

            racine.appendChild(bdd);
            racine.appendChild(server);

            bdd.appendChild(url);
            bdd.appendChild(user);
            bdd.appendChild(password);

            server.appendChild(port);

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(d);
            StreamResult destination = new StreamResult(new File(Main.FICHIER));
            transformer.transform(source, destination);

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(GestionnaireXML.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        } catch (TransformerException ex) {
            Logger.getLogger(GestionnaireXML.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }
    
    public static Configuration lireXML() {
        
        Configuration c = new Configuration();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.parse(new File(Main.FICHIER));

            Element racine = d.getDocumentElement();
            Element bdd = (Element) racine.getFirstChild();
            Element server = (Element) racine.getLastChild();
            
            Element url = (Element) bdd.getFirstChild();
            Element user = (Element) url.getNextSibling();
            Element password = (Element) user.getNextSibling();
            
            Element port = (Element) server.getFirstChild();
            
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
