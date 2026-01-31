/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Encadrant;
import beans.Etudiant;
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
public class EncadrantService implements IDao<Encadrant>{
    private Connexion connexion;
     
     public EncadrantService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Encadrant o) {
         String req = "insert into Encadrant (id, nom, prenom,email) values (null, ?, ?, ?)"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Encadrant o) {
       String req = "delete from Encadrant where id = ?"; 
       try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Encadrant o) {
         String req = "update Encadrant set nom = ?, prenom = ?, email = ? where id  = ?"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Encadrant findById(int id) {
       String req = "select * from Encadrant where id  = ?"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return new Encadrant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),rs.getString("email"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Encadrant> findAll() {
       List<Encadrant>  encadrants = new ArrayList<>();
        String req = "select * from Encadrant"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                encadrants.add(new Encadrant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email")));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return encadrants;
    }
    
}
