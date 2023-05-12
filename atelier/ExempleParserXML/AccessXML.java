import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

import java.util.*;

public class AccessXML {
	
	public static List<Livre> lireXML(){
		List<Livre> reponse = new ArrayList<>();
		try{
			File fichierXml =new File("exemple.xml");
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(fichierXml);
			
			Element racine = document.getDocumentElement();
			
			NodeList livres = racine.getChildNodes();
			for(int i = 0; i < livres.getLength(); i++){
				if(livres.item(i) instanceof Element){
					
					Element livre = (Element) livres.item(i);
					NodeList infos = livre.getChildNodes();

					Livre l = new Livre();
					for(int j = 0; j < infos.getLength(); j++){
						if(infos.item(j) instanceof Element){
							
							Element info = (Element) infos.item(j);
							
							if(info.getTagName().equals("id"))
								l.id = info.getTextContent();
								
							if(info.getTagName().equals("titre"))
								l.titre = info.getTextContent();
							
							if(info.getTagName().equals("dpublication"))
								l.annee = info.getTextContent();
						}
					}
					
					reponse.add(l);

				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return reponse;
	}
	
}

