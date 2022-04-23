/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class GestionnaireXML {

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

}
