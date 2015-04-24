package exception;

/**
 * Created on 24.04.15.
 */
public class SalaryFormatException extends Exception {
    String salary;

    public SalaryFormatException(String salary){
        this.salary = salary;
    }

    public String getSalaryException(){
        return this.salary;
    }
}
