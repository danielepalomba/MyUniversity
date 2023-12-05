package myUniversityPack.app;

import myUniversityPack.entity.Esame;
import myUniversityPack.entity.EsameStudente;
import myUniversityPack.entity.Studente;
import myUniversityPack.entityService.EsameService;
import myUniversityPack.entityService.EsameStudenteService;
import myUniversityPack.login.SecureLogin;
import myUniversityPack.registration.SecureRegistration;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

public class University {
  private static Studente studente;

  public static Studente login(String username, String password){
     return studente =  SecureLogin.login(username, password);
  }

  public static Studente registra(String username, String password, String matricola, String nome, String cognome, String indirizzo, String cellulare, Timestamp data_di_nascita, Timestamp data_di_immatricolazione, int id_dipartimento){
     return studente = SecureRegistration.registration(username, password, matricola, nome, cognome,indirizzo,cellulare,data_di_nascita,data_di_immatricolazione,id_dipartimento);
  }

  public static List<Esame> getEsami(){
      if(studente == null)
          return null;

      EsameStudenteService esameStudenteService = new EsameStudenteService();
      EsameService esameService = new EsameService();
      Collection<EsameStudente> lista_esami_studente = esameStudenteService.retrieveByMatricola(studente.getMatricola());
      return lista_esami_studente.stream().map(e->esameService.findById(e.getId_esame())).toList();
  }

  public static List<Esame> getEsamiDisponinili(){
      EsameService esameService = new EsameService();
      return (List<Esame>) esameService.retrieveByDipartimento(studente.getId_dipartimento());
  }
  public static void addEsame(String matricola_studente, int id_esame){
      EsameStudenteService esameStudenteService = new EsameStudenteService();
      EsameStudente es = new EsameStudente(matricola_studente, id_esame);
      esameStudenteService.doSave(es);
      studente.getEsami().add(es);
  }

    public static void main(String[] args) {
       // Studente s = University.registra("Danipalo", "Danipalo10", "0512114347", "Daniele", "Palomba", "indirizzo", "3925281335", TimeService.getTime("2002", "12", "7"), TimeService.getTime("2023" , "12" ,"07"), 1);
        Studente s = University.login("Danipalo", "Danipalo10");


    }
}