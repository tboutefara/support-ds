import javax.swing.*;
import javax.swing.table.*;

import java.util.*;

public class CreerInterface {
	
	public static void creerFrame(List<Livre> liste){
		JFrame f = new JFrame();
		f.setSize(600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		String[] colonnes = new String[]{"id", "titre", "année"};
		DefaultTableModel modele = new DefaultTableModel(null, colonnes);
			
		JTable table = new JTable(modele);
		
		for(Livre l : liste){
			Vector ligne = new Vector();
			ligne.add(l.id);
			ligne.add(l.titre);
			ligne.add(l.annee);
			modele.addRow(ligne);
		}
		
		f.getContentPane().add(table);
		f.setVisible(true);
	}
}

