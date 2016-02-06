package com.dateparser.hosseini.persiantime.dates.PersianDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  This class provide Months in letters and make it more readable

 *  @author  abbashosseini
 *  @version 1.0
 *  @since   3/1/2016
 */
public class CurrentDate {

    public String getdateWithMonthLetters(String getdate){

    /*
     *
     *  and its get string date as persian not english SO you have to
     *  first get persian date like this yyyy-MM-dd then pass it
     *
     */

        Pattern pattern = Pattern.compile("^(\\d{4})\\/(\\d{1,2})\\/(\\d{1,2})$");
        Matcher matcher = pattern.matcher(getdate);

        if (!matcher.find())
            throw new IllegalAccessError("Date format is not correct !");

        String YEAR_FOR_STATUS = matcher.group(1);
        String MONTH_FOR_STATUS = matcher.group(2);
        String Display_Month_on_Status = String.valueOf("");
        String DAY_FOR_STATUS = matcher.group(3);

        switch (Integer.parseInt(MONTH_FOR_STATUS)) {
            case 1:
                Display_Month_on_Status = "فروردین";
                break;
            case 2:
                Display_Month_on_Status = "ارديبهشت";
                break;
            case 3:
                Display_Month_on_Status = "خرداد";
                break;
            case 4:
                Display_Month_on_Status = "تير";

                break;
            case 5:
                Display_Month_on_Status = "مرداد";

                break;
            case 6:
                Display_Month_on_Status = "شهريور";
                break;
            case 7:
                Display_Month_on_Status = "مهر";
                break;
            case 8:
                Display_Month_on_Status = "آبان";
                break;
            case 9:
                Display_Month_on_Status = "آذر";
                break;
            case 10:
                Display_Month_on_Status = "دي";
                break;
            case 11:
                Display_Month_on_Status = "بهمن";
                break;
            case 12:
                Display_Month_on_Status = "اسفند";
                break;
        }

        return DAY_FOR_STATUS + " " +Display_Month_on_Status + " " + YEAR_FOR_STATUS;

    }

    public static String getDay(String date){
        /*
        get Name of day from device and translate english name to persian name.
        */

        Date calendar = new Date();
        SimpleDateFormat JustDayofWeek = new SimpleDateFormat("EEE", Locale.ENGLISH);

        if (!date.equals("")) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            try {
                calendar = format.parse(date);
            } catch (ParseException ignored) {
                throw new IllegalAccessError("is Formatted as Date really ? ");
            }
        }


        String Day =  JustDayofWeek.format(calendar);
        String dayName = "";
        switch (Day) {
            case "Sun":
                dayName = "يکشنبه";
                break;
            case "Mon":
                dayName = "دوشنبه";
                break;
            case "Tue":
                dayName = "سه شنبه";
                break;
            case "Wed":
                dayName = "چهارشنبه";
                break;
            case "Thu":
                dayName = "پنج شنبه";
                break;
            case "Fri":
                dayName = "جمعه";
                break;
            case "Sat":
                dayName = "شنبه";
                break;
        }

        return dayName;
    }
}
