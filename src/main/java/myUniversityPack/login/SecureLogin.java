package myUniversityPack.login;


import myUniversityPack.Entity.Credenziali;
import myUniversityPack.Entity.Studente;
import myUniversityPack.EntityService.CredenzialiService;
import myUniversityPack.EntityService.StudenteService;

public class SecureLogin {

    public static Studente login(String username, String password) throws RuntimeException {
        CredenzialiService cs = new CredenzialiService();
        StudenteService ss = new StudenteService();

        Credenziali c = cs.findByUsernameAndPassword(username, password);
        System.out.println(c);

        if(c==null)
            throw new RuntimeException("Credenziali errate");
        else if(c.getUsername().equals(username) && c.getPassword().equals(password))
            System.out.println("Login effettuato!");
        else
            throw new RuntimeException("Credenziali errate");

        return ss.findById(c.getMatricola_studente());
    }
}
