package utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DataTypeUtils {

    public static Date stringToSqlDate (String s) throws ParseException {
        java.util.Date date = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH).parse(s);
        return new Date(date.getTime());
    }
}
