/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.univjijel.validationxmlschema;

import java.io.File;
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
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Source fichierSchema = new StreamSource("personne.xsd");
        File fichierXML = new File("Personne01.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Source[] schemas = new Source[]{fichierSchema};
        
        try {
           
            Schema schema = schemaFactory.newSchema(schemas);
            factory.setSchema(schema);
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            
            reader.setErrorHandler(new ExempleErrorHandler());
            reader.parse("Personne01.xml");
            
            System.out.println("Fin de validation");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class ExempleErrorHandler implements ErrorHandler {

    @Override
    public void warning(SAXParseException arg0) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void error(SAXParseException arg0) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fatalError(SAXParseException arg0) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
