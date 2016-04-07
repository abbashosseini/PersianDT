package com.hosseini.persian.dt.PersianDate.enumCollections;

/**
 * Created by abbas on 4/4/16.
 */
public enum AgoFomat {
    year("سال", 31536000),
    month("ماه", 2592000),
    week("هفته", 604800),
    day("روز", 86400),
    hour("ساعت", 3600),
    minute("دقیقه", 60),
    Know(" ثانیه پیش", 0);

    private String name;
    private int format;

    AgoFomat(String name, int format) {
        this.name = name;
        this.format = format;
    }

    public String getFormatname() {
        return name;
    }

    public int getFormatNumber() {
        return format;
    }
}
