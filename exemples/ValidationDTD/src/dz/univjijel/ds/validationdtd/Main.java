/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.univjijel.ds.validationdtd;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(true);
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            db.setErrorHandler(new ExempleValidateur());

            System.out.println("\n\n---------------------\nPremier fichier :\n---------------------");
            Document d1 = db.parse(new File("Personne01.xml"));
            System.out.println(d1.getDocumentElement());

            System.out.println("\n\n---------------------\nDeuxieme fichier :\n---------------------");
            Document d2 = db.parse(new File("Personne02.xml"));
            System.out.println(d2.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

class ExempleValidateur implements ErrorHandler {

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.out.println("Il y avait une alerte"); 
        System.out.println(exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        System.out.println("Il y avait une erreur");
        System.out.println(exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println("Il y avait une erreur grave");
        System.out.println(exception.getMessage());
    }

}
