/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.AffectationStage;
import beans.Encadrant;
import beans.Etudiant;
import beans.Stage;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AMINE
 */
public class AffectationStageService implements IDao<AffectationStage>{
    private Connexion connexion;
    private EtudiantService es;
    private StageService sv;
    private EncadrantService ens;

    public AffectationStageService() {
        connexion = Connexion.getInstance();
        es = new EtudiantService();
        sv = new StageService();
        ens = new EncadrantService();
    }

    @Override
    public boolean create(AffectationStage o) {
        String req = "insert into AffectationStage (stage_id, etudiant_id,encadrant_id) values (?, ?, ?)"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getStage().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.setInt(3, o.getEncadrant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(AffectationStage o) {
        String req = "delete from AffectationStage where stage_id = ? AND etudiant_id= ? AND encadrant_id = ?"; 
       try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getStage().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.setInt(3, o.getEncadrant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(AffectationStage o) {
        String req = "update AffectationStage SET stage_id = ?, etudiant_id = ?, encadrant_id = ? WHERE stage_id = ? AND etudiant_id = ?"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getStage().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.setInt(3, o.getEncadrant().getId());
            ps.setInt(4, o.getStage().getId());
            ps.setInt(5, o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public AffectationStage findById(int id) {
        return null;
    }

    @Override
    public List<AffectationStage> findAll() {
        List<AffectationStage>  affectationStages = new ArrayList<>();
        String req = "select * from AffectationStage"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Stage stage = sv.findById(rs.getInt("stage_id"));
                Etudiant etudiant = es.findById(rs.getInt("etudiant_id"));
                Encadrant encadrant = ens.findById(rs.getInt("encadrant_id"));
                affectationStages.add(new AffectationStage(stage, etudiant, encadrant));
            }
                
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectationStages;
    }
    
}
