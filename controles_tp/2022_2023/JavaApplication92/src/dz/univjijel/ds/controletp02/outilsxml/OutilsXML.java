/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.univjijel.ds.controletp02.outilsxml;

import dz.univjijel.ds.controletp02.model.Client;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class OutilsXML {

    public static List<Client> lireXML(File file) throws SAXException, IOException, ParserConfigurationException {
        List<Client> liste = new ArrayList<>();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(file);

        Element racine = document.getDocumentElement();
        NodeList clients = racine.getChildNodes();

        for (int i = 0; i < clients.getLength(); i++) {
            Element client = (Element) clients.item(i);

            NodeList infos = client.getChildNodes();
            Client c = new Client(
                    Integer.parseInt(infos.item(0).getTextContent()),
                    infos.item(1).getTextContent(),
                    infos.item(2).getTextContent(),
                    infos.item(3).getTextContent()
            );

            liste.add(c);
        }

        return liste;
    }

    public static void sauverXML(List<Client> liste, File file) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();
        
        Element clients = document.createElement("clients");
        document.appendChild(clients);
        
        for(Client c : liste){
            Element client = document.createElement("client");
            clients.appendChild(client);
            
            Element id = document.createElement("id");
            id.appendChild(document.createTextNode(c.getId() + ""));
            client.appendChild(id);
            
            Element nom = document.createElement("nom");
            nom.appendChild(document.createTextNode(c.getNomComplet()));
            client.appendChild(nom);
            
            Element nTel = document.createElement("nTel");
            nTel.appendChild(document.createTextNode(c.getnTel()));
            client.appendChild(nTel);
            
            Element adresse = document.createElement("adresse");
            adresse.appendChild(document.createTextNode(c.getAdresse()));
            client.appendChild(adresse);
        }

        DOMSource source = new DOMSource(document);
        StreamResult sr = new StreamResult(file);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();

        t.transform(source, sr);
    }

}
