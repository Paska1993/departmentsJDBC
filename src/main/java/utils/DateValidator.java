package utils;

import exception.DateFormatException;

import java.sql.Date;

/**
 * Created on 30.04.15.
 */
public class DateValidator {

    public static Date validation(String date) throws DateFormatException {
        try{
            return Date.valueOf(date);
        }catch(Exception e){
            throw new DateFormatException(date);
        }
    }
}
