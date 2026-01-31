/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author AMINE
 */
public class Stage {
    private int id;
    private String entreprise;
    private String sujet;
    private Date date_debut;
    private Date date_fin;

    public Stage(int id, String entreprise, String sujet, Date date_debut, Date date_fin) {
        this.id = id;
        this.entreprise = entreprise;
        this.sujet = sujet;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Stage(String entreprise, String sujet, Date date_debut, Date date_fin) {
        this.entreprise = entreprise;
        this.sujet = sujet;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return this.entreprise;
    }
    
    
            
    
}
