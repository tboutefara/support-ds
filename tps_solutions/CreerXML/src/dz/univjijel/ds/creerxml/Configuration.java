/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.univjijel.ds.creerxml;

/**
 *
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class Configuration {
    
    String url;
    String user;
    String password;
    
    String port;

    public Configuration() {
    }

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
