package com.hosseini.persian.dt.PersianDate.Collections;

/**
 * Created by abbas on 3/29/16.
 */
public enum Months {

    /*
    * dont worry we just use values */
    Jan("فروردین", 1),
    Feb("ارديبهشت", 2),
    Mar("خرداد", 3),
    Apr("تير", 4),
    May("مرداد", 5),
    Jun("شهريور", 6),
    Jul("مهر", 7),
    Aug("آبان", 8),
    Sep("آذر", 9),
    Oct("دي", 10),
    Nov("بهمن", 11),
    Dec("اسفند", 12);

    private String monthS;
    private int monthI;

    Months(String name, int index) {
        this.monthS = name;
        this.monthI = index;
    }

    /**
     * Getter for property 'monthAsString'.
     *
     * @return Value for property 'monthAsString'.
     */
    public String getMonthAsString() {
        return monthS;
    }


    /**
     * Getter for property 'monthAsInt'.
     *
     * @return Value for property 'monthAsInt'.
     */
    public int getMonthAsInt() {
        return monthI;
    }
}
