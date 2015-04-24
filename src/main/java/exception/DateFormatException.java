package exception;

/**
 * Created on 24.04.15.
 */
public class DateFormatException extends Exception {
    public String date;

    public DateFormatException(String date){
        this.date = date;
    }

    public String getDate(){
        return this.date;
    }
}
