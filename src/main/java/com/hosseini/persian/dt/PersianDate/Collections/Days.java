package com.hosseini.persian.dt.PersianDate.Collections;

/**
 * Created by abbas on 3/29/16.
 */
public enum Days {
    Sun("يکشنبه"),
    Mon("دوشنبه"),
    Tue("سه شنبه"),
    Wed("چهارشنبه"),
    Thu("پنج شنبه"),
    Fri("جمعه"),
    Sat("شنبه");

    private String day;

    Days(String day) {
        this.day = day;
    }

    /**
     * Getter for property 'day'.
     *
     * @return Value for property 'day'.
     */
    public synchronized String getDay() {
        return day;
    }

}
