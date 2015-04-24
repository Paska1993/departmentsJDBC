package exception;

/**
 * Created on 24.04.15.
 */
public class SameDepartmentNameException extends Exception {
    private String errorMessage;

    public SameDepartmentNameException(String message){
        this.errorMessage = message;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
