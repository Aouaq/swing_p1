/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author AMINE
 */
public class AffectationStage {
    private Stage stage;
    private Etudiant etudiant;
    private Encadrant encadrant;

    public AffectationStage(Stage stage, Etudiant etudiant, Encadrant encadrant) {
        this.stage = stage;
        this.etudiant = etudiant;
        this.encadrant = encadrant;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Encadrant getEncadrant() {
        return encadrant;
    }

    public void setEncadrant(Encadrant encadrant) {
        this.encadrant = encadrant;
    }

    @Override
    public String toString() {
        return "AffectationStage{" + "stage=" + stage.getId() + ", etudiant=" + etudiant.getId() + ", encadrant=" + encadrant.getId() + '}';
    }

    
    
    
    
}
