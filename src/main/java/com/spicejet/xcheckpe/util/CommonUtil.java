package com.spicejet.xcheckpe.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommonUtil {

    public static String addToCalender(String inputDate, int amountToAdd, String field) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(inputDate));

        if ("YR".equalsIgnoreCase(field)) {
            cal.add(Calendar.YEAR, amountToAdd);
        }
        else if ("MT".equalsIgnoreCase(field)) {
            cal.add(Calendar.MONTH, amountToAdd);
        }
        else if ("D".equalsIgnoreCase(field)) {
            cal.add(Calendar.DATE, amountToAdd);
        }

        return sdf.format(cal.getTime());
    }
}
