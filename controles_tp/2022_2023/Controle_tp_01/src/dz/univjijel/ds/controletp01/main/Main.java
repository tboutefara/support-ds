package dz.univjijel.ds.controletp01.main;
// started 23:22
// finished 23:55
import dz.univjijel.ds.controletp01.gui.MainFrame;
import dz.univjijel.ds.controletp01.model.Daira;
import dz.univjijel.ds.controletp01.model.Wilaya;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
public class Main {
    
    public static List<Wilaya> liste = new ArrayList<>();
    public static MainFrame mainFrame = new MainFrame();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        mainFrame.setVisible(true);
    }

    public static void sauvegarder() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();
            
            Element racine = document.createElement("wilayas");
            document.appendChild(racine);
            
            for(Wilaya w : liste){
                Element wilaya = document.createElement("wilaya");
                racine.appendChild(wilaya);
                
                Element code = document.createElement("code");
                code.appendChild(document.createTextNode(w.getCode() + ""));
                wilaya.appendChild(code);
                                
                Element nom = document.createElement("nom");
                nom.appendChild(document.createTextNode(w.getNom()));
                wilaya.appendChild(nom);
                
                Element dairas = document.createElement("dairas");
                wilaya.appendChild(dairas);
                
                for(Daira d : w.getDairas()){
                    Element daira = document.createElement("daira");
                    dairas.appendChild(daira);
                    
                    Element nomDaira = document.createElement("nomDaira");
                    nomDaira.appendChild(document.createTextNode(d.getNom()));
                    daira.appendChild(nomDaira);
                    
                    Element codePostal = document.createElement("codePostal");
                    codePostal.appendChild(document.createTextNode(d.getCodePostal() + ""));
                    daira.appendChild(codePostal);
                }
                
            }
            
            DOMSource source = new DOMSource(document);
            StreamResult sr = new StreamResult(new File("sortie.xml"));
            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            
            t.transform(source, sr);
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
