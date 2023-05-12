package dz.univjijel.ds.controletp02.main;
// started 00:24
// finished 00:53

import dz.univjijel.ds.controletp02.gui.MainFrame;
import dz.univjijel.ds.controletp02.model.Client;
import dz.univjijel.ds.controletp02.outilsxml.OutilsXML;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;


/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Main {
    
    public static File file;
    public static List<Client> liste = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFileChooser jfc = new JFileChooser();
        if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            file = jfc.getSelectedFile();
            
            try {
                liste = OutilsXML.lireXML(file);
            } catch (SAXException | IOException | ParserConfigurationException ex) {
                liste = new ArrayList<>();
            }
            
            (new MainFrame()).setVisible(true);
        }
    }

    public static void sauverXML() {
        try {
            OutilsXML.sauverXML(liste, file);
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }
    
}
