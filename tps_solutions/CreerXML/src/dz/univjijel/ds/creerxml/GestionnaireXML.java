/*
 * Université de Jijel
 * Faculté des sciences exactes et d'informatique
 * Département d'Informatique
 * 3ème Année Licence
 * Données Semi-Structurées - Corrigé de TP 03
 */
package dz.univjijel.ds.creerxml;

import java.io.File;
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

/**
 * Cette classe contient la méthode qui crée le fichier XML.
 * Mettre cette méthode dans une classe séparée permet une meilleure maintenance 
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
            // Création du document. Pour cela, nous aurons besoins d'un DocumentBuilder.
            // Pour créer ce dernier nous aurons besoin d'un DocumentBuilderFactory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            // La méthode newDocument() crée un document vide (même sans une racine)
            Document d = db.newDocument();

            // Création de la racine
            Element racine = d.createElement("configuration");
            // Attacher la racine au document
            d.appendChild(racine);

            // Création des différents noeuds
            Element bdd = d.createElement("bdd");
            Element url = d.createElement("url");
            Element user = d.createElement("user");
            Element password = d.createElement("password");

            Element server = d.createElement("server");
            Element port = d.createElement("port");

            // Créer les noeuds textes qui stoqueront le contenu
            url.appendChild(d.createTextNode(configuration.getUrl()));
            user.appendChild(d.createTextNode(configuration.getUser()));
            password.appendChild(d.createTextNode(configuration.getPassword()));

            port.appendChild(d.createTextNode(configuration.getPort()));

            // Création des liens entre les différents noeuds pour construire l'arborescence
            racine.appendChild(bdd);
            racine.appendChild(server);

            bdd.appendChild(url);
            bdd.appendChild(user);
            bdd.appendChild(password);

            server.appendChild(port);

            // Transfert du document vers le fichier.
            // La variable Main.FICHIER contient le lien vers le fichier à créer
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

}
