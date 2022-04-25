/*
 * Université de Jijel
 * Faculté des sciences exactes et d'informatique
 * Département d'Informatique
 * 3ème Année Licence
 * Données Semi-Structurées - Corrigé de TP 03
 */
package dz.univjijel.ds.lirexml;

/**
 * Cette classe sert à encapsuler les données (le modèle) de cet exemple.
 * Ces données sont : l'URL, l'utilisateur, le mot de passe et le port. Ces données
 * vont être envoyées de l'utilitaire vers l'interface graphique.
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Configuration {
    
    /**
     * Contenu de la balise &lt;url&gt;
     */
    String url;
    /**
     * Contenu de la balise &lt;user&gt;
     */
    String user;
    /**
     * Contenu de la balise &lt;password&gt;
     */
    String password;
    
    /**
     * Contenu de la balise &lt;port&gt;
     */
    String port;

    /**
     * Constructeur vide.
     */
    public Configuration() {
    }

    /**
     * Constructeur avec paramètres.
     * @param url L'URL
     * @param user L'utilisateur
     * @param password Le mot de passe
     * @param port Le port
     */
    public Configuration(String url, String user, String password, String port) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    
}
