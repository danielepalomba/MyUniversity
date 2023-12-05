package myUniversityPack.entityService;


import myUniversityPack.dbUtil.DriverManagerConnectionPool;
import myUniversityPack.entity.EsameStudente;
import myUniversityPack.entity.Studente;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudenteService implements DatabaseService<Studente>{
    private CredenzialiService cs = new CredenzialiService();
    private EsameStudenteService es = new EsameStudenteService();
    @Override
    public boolean doSave(Studente studente) {
        String query = "INSERT INTO STUDENTE (MATRICOLA, NOME, COGNOME, INDIRIZZO, CELLULARE, DATA_DI_NASCITA, DATA_IMMATRICOLAZIONE, ID_DIPARTIMENTO) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection c = DriverManagerConnectionPool.getConnection()) {
            c.setAutoCommit(false);
            try (PreparedStatement stm = c.prepareStatement(query)) {
                stm.setString(1, studente.getMatricola());
                stm.setString(2, studente.getNome());
                stm.setString(3, studente.getCognome());
                stm.setString(4, studente.getIndirizzo());
                stm.setString(5, studente.getCellulare());
                stm.setTimestamp(6, studente.getData_di_nascita());
                stm.setTimestamp(7, studente.getData_di_immatricolazione());
                stm.setInt(8, studente.getId_dipartimento());
                stm.executeUpdate();
                c.commit();
                return true;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remove(Studente studente) {
        String query = "DELETE FROM STUDENTE WHERE STUDENTE.MATRICOLA = ?";
        try(Connection c = DriverManagerConnectionPool.getConnection()){
            c.setAutoCommit(false);
            try(PreparedStatement stm = c.prepareStatement(query)) {
                stm.setString(1, studente.getMatricola());
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
    public Studente findById(String matricola) {
        String query = "SELECT * FROM STUDENTE WHERE STUDENTE.MATRICOLA = ?";
        Studente s = null;
        try(Connection c = DriverManagerConnectionPool.getConnection()){
            try(PreparedStatement stm = c.prepareStatement(query)){
                stm.setString(1, matricola);
                try(ResultSet rs = stm.executeQuery()){
                    while(rs.next()){
                        String matricola_s = rs.getString("MATRICOLA");
                        String nome = rs.getString("NOME");
                        String cognome = rs.getString("COGNOME");
                        String indirizzo = rs.getString("INDIRIZZO");
                        String cellulare = rs.getString("CELLULARE");
                        Timestamp data_di_nascita = rs.getTimestamp("DATA_DI_NASCITA");
                        Timestamp data_immatricolazione = rs.getTimestamp("DATA_IMMATRICOLAZIONE");
                        int id_dipartimento = rs.getInt("ID_DIPARTIMENTO");
                        s = new Studente(matricola, nome, cognome, indirizzo, cellulare, data_di_nascita, data_immatricolazione,id_dipartimento);
                        s.setCredenziali(cs.retrieveByStudente(matricola_s));
                        s.setEsami((List<EsameStudente>) es.retrieveByMatricola(matricola_s));
                    }
                    return s;
                }
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Studente> findAll() {
        String query = "SELECT * FROM STUDENTE";
        List<Studente> lista = new ArrayList<>();
        try(Connection c = DriverManagerConnectionPool.getConnection()) {
            try(PreparedStatement stm = c.prepareStatement(query)) {
                try(ResultSet rs = stm.executeQuery()){
                    while(rs.next()){
                        Studente s = new Studente();
                        s.setMatricola(rs.getString("MATRICOLA"));
                        s.setNome(rs.getString("NOME"));
                        s.setCognome(rs.getString("COGNOME"));
                        s.setIndirizzo(rs.getString("INDIRIZZO"));
                        s.setCellulare(rs.getString("CELLULARE"));
                        s.setData_di_nascita(rs.getTimestamp("DATA_DI_NASCITA"));
                        s.setData_di_immatricolazione(rs.getTimestamp("DATA_IMMATRICOLAZIONE"));
                        s.setId_dipartimento(rs.getInt("ID_DIPARTIMENTO"));
                        s.setCredenziali(cs.retrieveByStudente(s.getMatricola()));
                        s.setEsami((List<EsameStudente>) es.retrieveByMatricola(s.getMatricola()));
                        lista.add(s);
                    }
                    return lista;
                }
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
