package exception;

/**
 * Created on 24.04.15.
 */
public class DepartmentNullNameExceptin extends Exception {
    private String errorMessage;

    public DepartmentNullNameExceptin(String message){
        this.errorMessage = message;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
