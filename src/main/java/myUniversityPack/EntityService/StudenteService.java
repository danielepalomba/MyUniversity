package myUniversityPack.EntityService;

import myUniversityPack.DbUtil.DriverManagerConnectionPool;
import myUniversityPack.Entity.Studente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

public class StudenteService implements DatabaseService<Studente>{
    @Override
    public boolean doSave(Studente studente) {
        String query = "INSERT INTO STUDENTE (NOME, COGNOME, DATA_DI_NASCITA, EMAIL, MATRICOLA, ID_DIPARTIMENTO, ID_CREDENZIALI) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            c.setAutoCommit(false);
            try(PreparedStatement stm = c.prepareStatement(query)) {
                stm.setString(1, studente.getNome());
                stm.setString(2, studente.getCognome());
                stm.setDate(3, studente.getData_di_nascita());
                stm.setString(4, studente.getEmail());
                stm.setString(5, studente.getMatricola());
                stm.setInt(6, studente.getId_dipartimento());
                stm.setInt(7, studente.getId_credenziali());
                int rowAffected = stm.executeUpdate();
                if(rowAffected > 0){
                    c.commit();
                    return true;
                }else{
                    return false;
                }
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remove(Studente studente) {
        String query = "DELETE FROM Studente WHERE id = ?;";
        try(Connection c = DriverManagerConnectionPool.getConnection()){
            c.setAutoCommit(false);
            try(PreparedStatement stm = c.prepareStatement(query)) {
                stm.setInt(1, studente.getId());
                int rowAffected = stm.executeUpdate();
                if(rowAffected>0){
                    c.commit();
                    return true;
                }else {
                    return false;
                }
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    @Override
    public Studente findById(int id) {
        Studente studente = new Studente();
        String query = "SELECT * FROM STUDENTE WHERE ID = ?";
        try(Connection c = DriverManagerConnectionPool.getConnection()) {
            try(PreparedStatement stm = c.prepareStatement(query)){
                stm.setInt(1, id);
                try(ResultSet rs = stm.executeQuery()){
                    while(rs.next()){
                        setStudente(studente, rs);
                    }
                    return studente;
                }
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Studente> findAll() {
        String query = "SELECT * FROM STUDENTE";
        Collection<Studente> collection = new ArrayList<>();
        try(Connection c = DriverManagerConnectionPool.getConnection()){
            try(PreparedStatement stm = c.prepareStatement(query)){
                try(ResultSet rs = stm.executeQuery()){
                    while(rs.next()){
                        Studente studente = new Studente();
                        setStudente(studente, rs);
                        collection.add(studente);
                    }
                    return collection;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    private void setStudente(Studente studente, ResultSet rs) throws Exception{
        studente.setId(rs.getInt("ID"));
        studente.setNome(rs.getString("NOME"));
        studente.setCognome(rs.getString("COGNOME"));
        studente.setData_di_nascita(rs.getDate("DATA_DI_NASCITA"));
        studente.setEmail(rs.getString("EMAIL"));
        studente.setMatricola(rs.getString("MATRICOLA"));
        studente.setId_dipartimento(rs.getInt("ID_DIPARTIMENTO"));
        studente.setId_credenziali(rs.getInt("ID_CREDENZIALI"));
    }
}
