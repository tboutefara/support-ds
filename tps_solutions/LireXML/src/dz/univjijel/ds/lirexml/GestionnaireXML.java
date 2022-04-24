/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class GestionnaireXML {

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
