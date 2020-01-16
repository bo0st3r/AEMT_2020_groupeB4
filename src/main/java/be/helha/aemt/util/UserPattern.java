package be.helha.aemt.util;

import java.util.regex.Pattern;

public class UserPattern {
	public static final Pattern USERNAME_PATTERN = Pattern.compile("^(?=.*[a-zA-Z]{1,})(?=.*[\\d]{0,})[a-zA-Z0-9]{3,50}$");
    public static final Pattern PASSWORD_PATTERN = Pattern.compile("^\\S*$");
    public static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]+(([' -][a-zA-Z ])?[a-zA-Z]*)*$");
    public static final Pattern MAIL_PATTERN = Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d"
	            + "-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"
	            + "|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\"
	            + "x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", Pattern.CASE_INSENSITIVE);
    
    public static boolean validatePseudo(String pseudo){
        return Pattern.matches(USERNAME_PATTERN.pattern(), pseudo);
    }

    public static boolean validatePassword(String password){
        return Pattern.matches(PASSWORD_PATTERN.pattern(), password);
    }

    public static boolean validateName(String name){
        return Pattern.matches(NAME_PATTERN.pattern(), name);
    }

    public static boolean validateMail(String mail){
        return Pattern.matches(MAIL_PATTERN.pattern(), mail);
    }

}
