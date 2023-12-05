package myUniversityPack.login;


import myUniversityPack.entity.Credenziali;
import myUniversityPack.entity.Studente;
import myUniversityPack.entityService.CredenzialiService;
import myUniversityPack.entityService.StudenteService;
import myUniversityPack.util.PasswordManager;

public class SecureLogin {

    public static Studente login(String username, String password) throws RuntimeException {
        CredenzialiService cs = new CredenzialiService();
        StudenteService ss = new StudenteService();

        String inputPassword = PasswordManager.encryptPassword(password);

        Credenziali c = cs.findByUsernameAndPassword(username, inputPassword);
        System.out.println(c);

        if(c==null)
            throw new RuntimeException("Credenziali errate");
        else if(c.getUsername().equals(username) && c.getPassword().equals(inputPassword))
            System.out.println("Login effettuato!");
        else
            throw new RuntimeException("Credenziali errate");

        return ss.findById(c.getMatricola_studente());
    }
}
