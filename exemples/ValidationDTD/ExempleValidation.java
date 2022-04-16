import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;

public class ExempleValidation {
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