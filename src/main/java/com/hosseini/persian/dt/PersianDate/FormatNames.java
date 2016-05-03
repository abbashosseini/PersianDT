package com.hosseini.persian.dt.PersianDate;

import com.hosseini.persian.dt.PersianDate.enumCollections.AgoFomat;

/**
 * Created by abbas on 4/28/16.
 */
public class FormatNames {

    /**
     * you can use Enum AgoFomat instead thid
     * @see AgoFomat
     **/

    private static final String YEAR_AGO = "سال";
    private static final String MONTH_AGO = "ماه";
    private static final String WEEK_AGO = "هفته";
    private static final String DAY_AGO = "روز";
    private static final String HOUR_AGO = "ساعت";
    private static final String MIN_AGO = "دقیقه";
    private static final String SEC_AGO = "ثانیه";
    private static final String YESTERDAY = "دیروز";
    private static final String Extenion = "پیش";

    public static String YearAgo() {
        return YEAR_AGO;
    }

    public static String MonthAgo() {
        return MONTH_AGO;
    }

    public static String WeekAgo() {
        return WEEK_AGO;
    }

    public static String DayAgo() {
        return DAY_AGO;
    }

    public static String HourAgo() {
        return HOUR_AGO;
    }

    public static String MinAgo() {
        return MIN_AGO;
    }

    public static String SecAgo() {
        return SEC_AGO;
    }

    public static String YESTERDAY() {
        return YESTERDAY;
    }

    public static String Extenion() {
        return Extenion;
    }


}
