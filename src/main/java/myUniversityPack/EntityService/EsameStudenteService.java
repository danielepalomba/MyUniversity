package myUniversityPack.EntityService;

import myUniversityPack.DbUtil.DriverManagerConnectionPool;
import myUniversityPack.Entity.EsameStudente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EsameStudenteService implements DatabaseService<EsameStudente> {
    @Override
    public boolean doSave(EsameStudente esameStudente) {
        String query = "CALL AggiungiStudenteEsame(?, ?);";
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            c.setAutoCommit(false);
            try (PreparedStatement stm = c.prepareStatement(query)) {
                stm.setString(1, esameStudente.getMatricola_studente());
                stm.setInt(2, esameStudente.getId_esame());
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
    public boolean remove(EsameStudente esameStudente) {
        String query = "DELETE FROM STUDENTE_ESAME WHERE ID = ?";
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            c.setAutoCommit(false);
            try (PreparedStatement stm = c.prepareStatement(query)) {
                stm.setInt(1, esameStudente.getId());
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
    public EsameStudente findById(int id) {
        String query = "SELECT * FROM STUDENTE_ESAME WHERE ID = ?";
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            try (PreparedStatement stm = c.prepareStatement(query)) {
                stm.setInt(1, id);
                try (ResultSet rs = stm.executeQuery()) {
                    EsameStudente esameStudente = new EsameStudente();
                    while (rs.next()) {
                        esameStudente.setId(rs.getInt("ID"));
                        esameStudente.setMatricola_studente(rs.getString("MATRICOLA_STUDENTE"));
                        esameStudente.setId_esame(rs.getInt("ID_ESAME"));
                    }
                    return esameStudente;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    @Override
    public EsameStudente findById(String id) {
        return this.findById(Integer.parseInt(id));
    }

    @Override
    public Collection<EsameStudente> findAll() {
        String query = "SELECT * FROM STUDENTE_ESAME";
        Collection<EsameStudente> list = new ArrayList<>();
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            try (PreparedStatement stm = c.prepareStatement(query)) {
                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        EsameStudente esameStudente = new EsameStudente();
                        esameStudente.setId(rs.getInt("ID"));
                        esameStudente.setMatricola_studente(rs.getString("MATRICOLA_STUDENTE"));
                        esameStudente.setId_esame(rs.getInt("ID_ESAME"));
                        list.add(esameStudente);
                    }
                    return list;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public Collection<EsameStudente> retrieveByMatricola(String matricola) {
        String query = "SELECT * FROM STUDENTE_ESAME WHERE MATRICOLA_STUDENTE = ?";
        Collection<EsameStudente> list = new ArrayList<>();
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            try (PreparedStatement stm = c.prepareStatement(query)) {
                stm.setString(1, matricola);
                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        EsameStudente esameStudente = new EsameStudente();
                        esameStudente.setId(rs.getInt("ID"));
                        esameStudente.setMatricola_studente(rs.getString("MATRICOLA_STUDENTE"));
                        esameStudente.setId_esame(rs.getInt("ID_ESAME"));
                        list.add(esameStudente);
                    }
                    return list;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
