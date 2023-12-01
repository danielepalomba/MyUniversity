package myUniversityPack.EntityService;

import com.mysql.cj.protocol.x.ResultMessageListener;
import myUniversityPack.DbUtil.DriverManagerConnectionPool;
import myUniversityPack.Entity.Credenziali;
import myUniversityPack.Entity.EsameStudente;
import myUniversityPack.Entity.Studente;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudenteService implements DatabaseService<Studente>{

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
                stm.setDate(6, studente.getData_di_nascita());
                stm.setDate(7, studente.getData_di_immatricolazione());
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
    public Studente findById(long id) {
        return this.findById(Long.toString(id));
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
                        String matrcola = rs.getString("MATRICOLA");
                        String nome = rs.getString("NOME");
                        String cognome = rs.getString("COGNOME");
                        String indirizzo = rs.getString("INDIRIZZO");
                        String cellulare = rs.getString("CELLULARE");
                        Date data_di_nascita = rs.getDate("DATA_DI_NASCITA");
                        Date data_immatricolazione = rs.getDate("DATA_IMMATRICOLAZIONE");
                        int id_dipartimento = rs.getInt("ID_DIPARTIMENTO");
                        s = new Studente(matricola, nome, cognome, indirizzo, cellulare, data_di_nascita, data_immatricolazione,id_dipartimento);
                        s.setCredenziali(this.getCredenziali(s.getMatricola()));
                        s.setEsami(this.getEsami(s.getMatricola()));
                    }
                    return s;
                }
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }

    private Credenziali getCredenziali(String matricola){
        String query = "SELECT * FROM CREDENZIALI WHERE MATRICOLA_STUDENTE = ?";
        Credenziali credenziali = null;
        try(Connection c = DriverManagerConnectionPool.getConnection()){
            try(PreparedStatement stm = c.prepareStatement(query)){
                stm.setString(1, matricola);
                try(ResultSet rs = stm.executeQuery()){
                    while(rs.next()){
                        String username = rs.getString("USERNAME");
                        String password = rs.getString("PASSWORD");
                        String matricola_studente = rs.getString("MATRICOLA_STUDENTE");
                        credenziali = new Credenziali(username, password, matricola_studente);
                    }
                    return credenziali;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private List<EsameStudente> getEsami(String matricola){
        String query = "SELECT * FROM STUDENTE_ESAME WHERE MATRICOLA_STUDENTE = ?";
        List<EsameStudente> lista = new ArrayList<>();
        try(Connection c = DriverManagerConnectionPool.getConnection()) {
            try(PreparedStatement stm = c.prepareStatement(query)) {
                stm.setString(1, matricola);
                try(ResultSet rs = stm.executeQuery()) {
                    while(rs.next()){
                        EsameStudente es = new EsameStudente();
                        es.setId(rs.getInt("ID"));
                        es.setMatricola_studente(rs.getString("MATRICOLA_STUDENTE"));
                        es.setId_esame(rs.getInt("ID_ESAME"));
                        lista.add(es);
                    }
                    return lista;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
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
                        s.setData_di_nascita(rs.getDate("DATA_DI_NASCITA"));
                        s.setData_di_immatricolazione(rs.getDate("DATA_IMMATRICOLAZIONE"));
                        s.setId_dipartimento(rs.getInt("ID_DIPARTIMENTO"));
                        s.setCredenziali(this.getCredenziali(s.getMatricola()));
                        s.setEsami(this.getEsami(s.getMatricola()));
                        lista.add(s);
                    }
                    return lista;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
