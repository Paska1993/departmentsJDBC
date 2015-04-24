package exception;

import net.sf.oval.ConstraintViolation;

import java.util.List;

/**
 * Created on 24.04.15.
 */
public class EmployeeNullFieldsException extends Exception {
    List<ConstraintViolation> errorMessage;

    public EmployeeNullFieldsException(List<ConstraintViolation> violations){
        this.errorMessage = violations;
    }

    public List<ConstraintViolation> getErrorMessage(){
        return this.errorMessage;
    }
}
