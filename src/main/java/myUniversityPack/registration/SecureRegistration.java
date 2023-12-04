package myUniversityPack.registration;

import myUniversityPack.Entity.Credenziali;
import myUniversityPack.Entity.Studente;
import myUniversityPack.EntityService.CredenzialiService;
import myUniversityPack.EntityService.StudenteService;
import myUniversityPack.login.PasswordManager;

import java.sql.Date;

public class SecureRegistration {

    public static void registration(String username, String password,String matricola, String nome, String cognome, String indirizzo, String cellulare, Date data_di_nascita, Date data_di_immatricolazione, int id_dipartimento){
        StudenteService ss = new StudenteService();
        CredenzialiService cs = new CredenzialiService();
        ss.doSave(new Studente(matricola, nome, cognome, indirizzo, cellulare, data_di_nascita, data_di_immatricolazione, id_dipartimento));
        cs.doSave(new Credenziali(username, PasswordManager.encryptPassword(password), matricola));
    }
}
