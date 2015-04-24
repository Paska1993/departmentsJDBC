package exception;

/**
 * Created on 24.04.15.
 */
public class SameEmailException extends Exception {
    String email;

    public SameEmailException(String email){
        this.email = email;
    }

    public String getEmailException(){
        return this.email;
    }
}
