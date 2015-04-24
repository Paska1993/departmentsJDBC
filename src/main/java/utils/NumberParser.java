package utils;

/**
 * Created by pavel on 23.04.15.
 */
public class NumberParser {

    public static Double parseDouble(String num) {
        if (num.trim().equals("")){
            return null;
        }else return Double.valueOf(num);
    }

    public static Integer parseInteger(String num){
        if(num.trim().equals("")){
            return null;
        }else return Integer.valueOf(num);
    }
}
