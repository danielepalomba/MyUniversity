package myUniversityPack.entityService;

import myUniversityPack.dbUtil.DriverManagerConnectionPool;
import myUniversityPack.entity.Dipartimento;
import myUniversityPack.entity.Esame;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DipartimentoService implements DatabaseService<Dipartimento> {

    private EsameService es = new EsameService();

    @Override
    public boolean doSave(Dipartimento dipartimento) {
        String query = "INSERT INTO DIPARTIMENTO (NOME, EDIFICIO) VALUES (?, ?)";
        try(Connection c = DriverManagerConnectionPool.getConnection()){
            c.setAutoCommit(false);
            try(PreparedStatement stm = c.prepareStatement(query)){
                stm.setString(1,dipartimento.getNome());
                stm.setString(2, dipartimento.getEdificio());
                stm.executeUpdate();
                c.commit();
                return true;
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remove(Dipartimento dipartimento) {
        String query = "DELETE FROM DIPARTIMENTO WHERE DIPARTIMENTO.ID = ?";
        try(Connection c = DriverManagerConnectionPool.getConnection()){
            c.setAutoCommit(false);
            try(PreparedStatement stm = c.prepareStatement(query)){
                stm.setInt(1, dipartimento.getId());
                stm.executeUpdate();
                c.commit();
                return true;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    @Override
    public Dipartimento findById(int id) {
        String query = "SELECT * FROM DIPARTIMENTO WHERE DIPARTIMENTO.ID = ?";
        try(Connection c = DriverManagerConnectionPool.getConnection()){
            try(PreparedStatement stm = c.prepareStatement(query)){
                stm.setInt(1, id);
                try(ResultSet rs = stm.executeQuery()){
                    Dipartimento d = new Dipartimento();
                    while(rs.next()){
                        d.setId(rs.getInt("ID"));
                        d.setNome(rs.getString("NOME"));
                        d.setEdificio(rs.getString("EDIFICIO"));
                        d.setEsami((List<Esame>) es.retrieveByDipartimento(d.getId()));
                    }
                    return d;
                }
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    @Override
    public Dipartimento findById(String matricola) {
        return findById(Integer.parseInt(matricola));
    }

    @Override
    public Collection<Dipartimento> findAll() {
        String query = "SELECT * FROM DIPARTIMENTO";
        Collection<Dipartimento> list = new ArrayList<>();
        try(Connection c = DriverManagerConnectionPool.getConnection()){
            try(PreparedStatement stm = c.prepareStatement(query)){
                try(ResultSet rs = stm.executeQuery()){
                    while(rs.next()){
                        Dipartimento d = new Dipartimento();
                        d.setId(rs.getInt("ID"));
                        d.setNome(rs.getString("NOME"));
                        d.setEdificio(rs.getString("EDIFICIO"));
                        d.setEsami((List<Esame>) es.retrieveByDipartimento(d.getId()));
                        list.add(d);
                    }
                    return list;
                }
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
