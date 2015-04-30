package utils;

import exception.SalaryFormatException;

/**
 * Created by pavel on 23.04.15.
 */
public class NumberParser {

    public static Double parseDouble(String num) throws SalaryFormatException {
        if (num.trim().equals("")){
            return null;
        }else {
            try {
                Double d = Double.valueOf(num);
                return d;
            }catch(Exception e){
                throw new SalaryFormatException(num);
            }
        }
    }

    public static Integer parseInteger(String num){
        if(num.trim().equals("")){
            return null;
        }else return Integer.valueOf(num);
    }
}
