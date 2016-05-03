package com.hosseini.persian.dt.PersianDate.enumCollections;

/**
 * Month name and month number
 */
public enum Months {

    /*
    * dont worry we just use values */
    Farvardin("فروردین", 1),
    Ordibehesht("ارديبهشت", 2),
    Khordad("خرداد", 3),
    tir("تير", 4),
    Mordad("مرداد", 5),
    shahrivar("شهريور", 6),
    Mehr("مهر", 7),
    Aban("آبان", 8),
    Azar("آذر", 9),
    Dy("دي", 10),
    Bahman("بهمن", 11),
    Esfand("اسفند", 12);

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
