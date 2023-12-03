package myUniversityPack.EntityService;

import myUniversityPack.DbUtil.DriverManagerConnectionPool;
import myUniversityPack.Entity.Credenziali;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CredenzialiService implements DatabaseService<Credenziali> {
    @Override
    public boolean doSave(Credenziali credenziali) {
        String query = "INSERT INTO CREDENZIALI (USERNAME, PASSWORD, MATRICOLA_STUDENTE) VALUES (?,?,?)";
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            c.setAutoCommit(false);
            try (PreparedStatement stm = c.prepareStatement(query)) {
                stm.setString(1, credenziali.getUsername());
                stm.setString(2, credenziali.getPassword());
                stm.setString(3, credenziali.getMatricola_studente());
                stm.executeUpdate();
                c.commit();
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remove(Credenziali credenziali) {
        String query = "DELETE FROM CREDENZIALI WHERE CREDENZIALI.ID = ?";
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            c.setAutoCommit(false);
            try (PreparedStatement stm = c.prepareStatement(query)) {
                stm.setInt(1, credenziali.getId());
                stm.executeUpdate();
                c.commit();
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    @Override
    public Credenziali findById(int id) {
        String query = "SELECT * FROM CREDENZIALI WHERE CREDENZIALI.ID = ?";
        try(Connection c = DriverManagerConnectionPool.getConnection()){
            try(PreparedStatement stm = c.prepareStatement(query)){
                stm.setInt(1, id);
                try(ResultSet rs = stm.executeQuery()){
                    Credenziali credenziali = new Credenziali();
                    while(rs.next()){
                        credenziali.setId(rs.getInt("ID"));
                        credenziali.setUsername(rs.getString("USERNAME"));
                        credenziali.setPassword(rs.getString("PASSWORD"));
                        credenziali.setMatricola_studente(rs.getString("MATRICOLA_STUDENTE"));
                    }
                    return credenziali;
                }
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    @Override
    public Credenziali findById(String id) {
        return this.findById(Integer.parseInt(id));
    }

    @Override
    public Collection<Credenziali> findAll() {
        String query = "SELECT * FROM CREDENZIALI";
        Collection<Credenziali> list = new ArrayList<>();
        try(Connection c = DriverManagerConnectionPool.getConnection()){
            try(PreparedStatement stm = c.prepareStatement(query)){
                try(ResultSet rs = stm.executeQuery()){
                    while(rs.next()){
                        Credenziali credenziali = new Credenziali();
                        credenziali.setId(rs.getInt("ID"));
                        credenziali.setUsername(rs.getString("USERNAME"));
                        credenziali.setPassword(rs.getString("PASSWORD"));
                        credenziali.setMatricola_studente(rs.getString("MATRICOLA_STUDENTE"));
                        list.add(credenziali);
                    }
                    return list;
                }
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public Credenziali retrieveByStudente(String matricola) {
        String query = "SELECT * FROM CREDENZIALI WHERE MATRICOLA_STUDENTE = ?";
        try(Connection c = DriverManagerConnectionPool.getConnection()){
            try(PreparedStatement stm = c.prepareStatement(query)){
                stm.setString(1, matricola);
                try(ResultSet rs = stm.executeQuery()){
                    Credenziali credenziali = new Credenziali();
                    while(rs.next()){
                        credenziali.setId(rs.getInt("ID"));
                        credenziali.setUsername(rs.getString("USERNAME"));
                        credenziali.setPassword(rs.getString("PASSWORD"));
                        credenziali.setMatricola_studente(rs.getString("MATRICOLA_STUDENTE"));
                    }
                    return credenziali;
                }
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

}
