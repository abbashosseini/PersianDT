package com.hosseini.persian.dt.PersianDate.enumCollections;

/**
 * names of the day of the week
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
    public String getDay() {
        return day;
    }

}
