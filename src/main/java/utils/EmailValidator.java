package utils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created on 24.04.15.
 */
public class EmailValidator {

    public static boolean check(String email){
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
