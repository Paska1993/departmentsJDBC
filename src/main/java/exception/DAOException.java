package exception;

/**
 * Created on 28.04.15.
 */
public class DAOException extends Exception {
    private final String DatabaseException = "We have some trouble with Database, sorry for that!";

    public DAOException(){
    }

    public String getDatabaseException(){
        return DatabaseException;
    }
}
