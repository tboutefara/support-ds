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
package dz.univjijel.ds.validationxmlschema;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

/**
 * Exemple sur la validation d'un fichier XML en utilisant un schéma XSD.
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Main {

    /**
     * Pas de paramètres,
     * Pour cette première versioon, les nooms des fichiers sont "hard-coded".
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Source fichierSchema = new StreamSource("personne.xsd");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Source[] schemas = new Source[]{fichierSchema};
        
        try {
           
            Schema schema = schemaFactory.newSchema(schemas);
            factory.setSchema(schema);
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            
            reader.setErrorHandler(new ExempleValidateur());
            reader.parse("Personne01.xml");
            
            System.out.println("Fin de validation");
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
