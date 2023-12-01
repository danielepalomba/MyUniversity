package myUniversityPack;

import myUniversityPack.Entity.Studente;
import myUniversityPack.EntityService.StudenteService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("global");

        ArrayList<Studente> studenti = new ArrayList<>();
        StudenteService ss = new StudenteService();
        studenti.addAll(ss.findAll());
        System.out.println(studenti);
    }
}