package myUniversityPack.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator {

    public static boolean checkUsernameAndPassword(String username, String password)throws RuntimeException{
        String regexPattern = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher usernameMatcher = pattern.matcher(username);
        Matcher passwordMatcher = pattern.matcher(password);
        if(usernameMatcher.matches()&&passwordMatcher.matches())
            return true;
        else
            throw new RuntimeException("Username non valido");
    }

    public static boolean checkTelefonoAndMatricola(String numero, String matricola) throws RuntimeException{
        String regexPattern = "^\\d{10}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher numeroMatcher = pattern.matcher(numero);
        Matcher matricolaMatcher = pattern.matcher(matricola);
        if(numeroMatcher.matches()&&matricolaMatcher.matches())
            return true;
        else
            throw new RuntimeException("Username non valido");
    }
}

