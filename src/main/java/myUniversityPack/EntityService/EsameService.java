package myUniversityPack.EntityService;

import myUniversityPack.DbUtil.DriverManagerConnectionPool;
import myUniversityPack.Entity.Esame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class EsameService implements DatabaseService<Esame> {
    @Override
    public boolean doSave(Esame esame) {
        String query = "INSERT INTO ESAME (NOME, CFU, ORE_TEORIA, ORE_LABORATORIO, ID_DIPARTIMENTO) VALUES (?,?,?,?,?)";
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            c.setAutoCommit(false);
            try (PreparedStatement stm = c.prepareStatement(query)) {
                stm.setString(1, esame.getNome());
                stm.setInt(2, esame.getCfu());
                stm.setInt(3, esame.getOre_teoria());
                stm.setInt(4, esame.getOre_laboratorio());
                stm.setInt(5, esame.getId_dipartimento());
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
    public boolean remove(Esame esame) {
        String query = "DELETE FROM ESAME WHERE ID = ?";
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            c.setAutoCommit(false);
            try (PreparedStatement stm = c.prepareStatement(query)) {
                stm.setInt(1, esame.getId());
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
    public Esame findById(int id) {
        String query = "SELECT * FROM ESAME WHERE ID = ?";
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            try (PreparedStatement stm = c.prepareStatement(query)) {
                stm.setInt(1, id);
                try (ResultSet rs = stm.executeQuery()) {
                    Esame esame = new Esame();
                    while (rs.next()) {
                        esame.setId(rs.getInt("ID"));
                        esame.setNome(rs.getString("NOME"));
                        esame.setCfu(rs.getInt("CFU"));
                        esame.setOre_teoria(rs.getInt("ORE_TEORIA"));
                        esame.setOre_laboratorio(rs.getInt("ORE_LABORATORIO"));
                        esame.setId_dipartimento(rs.getInt("ID_DIPARTIMENTO"));
                    }
                    return esame;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    @Override
    public Esame findById(String id) {
        return this.findById(Integer.parseInt(id));
    }

    @Override
    public Collection<Esame> findAll() {
        String query = "SELECT * FROM ESAME";
        Collection<Esame> list = new ArrayList<>();
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            try (PreparedStatement stm = c.prepareStatement(query)) {
                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        Esame esame = new Esame();
                        esame.setId(rs.getInt("ID"));
                        esame.setNome(rs.getString("NOME"));
                        esame.setCfu(rs.getInt("CFU"));
                        esame.setOre_teoria(rs.getInt("ORE_TEORIA"));
                        esame.setOre_laboratorio(rs.getInt("ORE_LABORATORIO"));
                        esame.setId_dipartimento(rs.getInt("ID_DIPARTIMENTO"));
                        list.add(esame);
                    }
                    return list;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    public Collection<Esame> retrieveByDipartimento(int id) {
        String query = "SELECT * FROM ESAME WHERE ID_DIPARTIMENTO = ?";
        Collection<Esame> list = new ArrayList<>();
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            try (PreparedStatement stm = c.prepareStatement(query)) {
                stm.setInt(1, id);
                try (ResultSet rs = stm.executeQuery()) {
                    while (rs.next()) {
                        Esame esame = new Esame();
                        esame.setId(rs.getInt("ID"));
                        esame.setNome(rs.getString("NOME"));
                        esame.setCfu(rs.getInt("CFU"));
                        esame.setOre_teoria(rs.getInt("ORE_TEORIA"));
                        esame.setOre_laboratorio(rs.getInt("ORE_LABORATORIO"));
                        esame.setId_dipartimento(rs.getInt("ID_DIPARTIMENTO"));
                        list.add(esame);
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
