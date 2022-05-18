/*
 * Université de Jijel
 * Faculté des sciences exactes et d'informatique
 * Département d'Informatique
 * 3ème Année Licence
 * Données Semi-Structurées - Corrigé de TP 03
 */
package dz.univjijel.ds.exemplexml;

/**
 * La classe main.
 * Elle lit le fichier XML et crée la fenêtre principale et l'affiche.
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Main {
    
    /**
     * Le chemin vers le fichier à créer
     */
    public static String FICHIER = "exemple.xml";

    /**
     * Méthode main
     * @param args pas d'arguments
     */
    public static void main(String[] args) {
        Configuration c = GestionnaireXML.lireXML();
        (new MainFrame(c)).setVisible(true);
    }
    
}
