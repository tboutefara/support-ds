/*
 * Copyright (C) 2022 Tarek Boutefara <t_boutefara@esi.dz>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
 * Exemple sur la validation d'un fichier XML en utilisant un fichier DTD.
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Main {

    /**
     * Pad de paramètres,
     * Les noms des fichiers sont "hard-coded" pour cette première version.
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

/**
 * Le validateur implémente les méthodes nécessaires pour recevoir les différentes
 * exceptions (erreurs).
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
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
