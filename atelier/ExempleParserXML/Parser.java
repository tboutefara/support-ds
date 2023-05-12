import java.util.*;

public class Parser{
	
	public static void main (String args[]) {
		
		List<Livre> liste = AccessXML.lireXML();
		CreerInterface.creerFrame(liste);
		
	}
		
}

