import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class CreerFichierXML {
	
	public static void main (String args[]) {
	
		Livre monLivre = new Livre("Java 2", "1200", "Gsoling");
		sauver(monLivre);
		
	}
	
	public static void sauver(Livre l){
		try{
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.newDocument();
			
			Element racine = document.createElement("livre");
			document.appendChild(racine);
			
			Element titre = document.createElement("titre");
			Text text_titre = document.createTextNode(l.titre);
			titre.appendChild(text_titre);
			racine.appendChild(titre);
			
			Element prix = document.createElement("prix");
			prix.appendChild(document.createTextNode(l.prix));
			racine.appendChild(prix);
			
			
			Element auteurs = document.createElement("auteurs");
			Element auteur = document.createElement("auteur");
			auteur.appendChild(document.createTextNode(l.auteur));
			auteurs.appendChild(auteur);
			racine.appendChild(auteurs);
			
			DOMSource source = new DOMSource(document);
			StreamResult dest = new StreamResult(new File("sortie.xml"));
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			transformer.transform(source, dest);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

class Livre{

		String titre;
		String prix;
		String auteur;
		
		public Livre(String t, String p, String a){
			this.titre = t;
			this.prix = p;
			this.auteur = a;
		}
	
}

