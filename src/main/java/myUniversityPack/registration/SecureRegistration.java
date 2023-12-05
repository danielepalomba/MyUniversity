package myUniversityPack.registration;

import myUniversityPack.entity.Credenziali;
import myUniversityPack.entity.Studente;
import myUniversityPack.entityService.CredenzialiService;
import myUniversityPack.entityService.StudenteService;
import myUniversityPack.util.PasswordManager;
import myUniversityPack.util.RegexValidator;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SecureRegistration {

    public static Studente registration(String username, String password, String matricola, String nome, String cognome, String indirizzo, String cellulare, Timestamp data_di_nascita, Timestamp data_di_immatricolazione, int id_dipartimento) throws RuntimeException{
        StudenteService ss = new StudenteService();
        CredenzialiService cs = new CredenzialiService();

        boolean check1 = RegexValidator.checkUsernameAndPassword(username,password);
        boolean check2 = RegexValidator.checkTelefonoAndMatricola(cellulare, matricola);

        if(check1 && check2 && checkDate(data_di_nascita, data_di_immatricolazione)){
            ss.doSave(new Studente(matricola, nome, cognome, indirizzo, cellulare, data_di_nascita, data_di_immatricolazione, id_dipartimento));
            cs.doSave(new Credenziali(username, PasswordManager.encryptPassword(password), matricola));
        }
        return ss.findById(matricola);
    }

    private static boolean checkDate(Timestamp birth, Timestamp immatricolazione) {
        LocalDate birthDate = birth.toLocalDateTime().toLocalDate();
        LocalDate immatricolazioneDate = immatricolazione.toLocalDateTime().toLocalDate();

        long yearsDifference = ChronoUnit.YEARS.between(birthDate, immatricolazioneDate);

        if (yearsDifference < 18) {
            throw new IllegalArgumentException("La differenza tra le date è inferiore a 18 anni.");
        } else {
            return true;
        }
    }
}
