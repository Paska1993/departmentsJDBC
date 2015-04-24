package exception;

/**
 * Created on 24.04.15.
 */
public class EmailFormatException extends Exception {
    String email;

    public EmailFormatException(String email){
        this.email = email;
    }

    public String getEmailException(){
        return this.email;
    }
}
