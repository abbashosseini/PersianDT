package com.hosseini.persian.dt.PersianDate;


/*
 * Copyright (C) 2015 Abbashosseini
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import com.hosseini.persian.dt.PersianDate.Collections.Days;
import com.hosseini.persian.dt.PersianDate.Collections.Months;
import com.hosseini.persian.dt.PersianDate.Iface.CallBack;
import jdk.nashorn.internal.objects.NativeDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public final class Generate extends Config {

    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private String SEPARATOR = " ";
    final DateFormat dateFormat;
    private final CCalendar sc;

    public Generate(String rawDate, String sentence) {
        super(rawDate, sentence);
        dateFormat = new SimpleDateFormat(Format(""), Locale.ENGLISH);
        Date date = null;
        try {  date = dateFormat.parse(super.getDate());  }
        catch ( ParseException ignored) {}
        sc = this.new CCalendar(date);
    }

    public String Format(String ft){

        return ft.equals("") ? DEFAULT_FORMAT : ft;
    }


    public final Generate Separator(String separator){
        SEPARATOR = separator;
        return this;
    }


    public String getCalendar() {
        return String.format("%d%s%d%s%d", sc.year, SEPARATOR, sc.month, SEPARATOR, sc.date);
    }

    public String getWithMonthName() {
        return String.format("%d%s%s%s%d", sc.year, SEPARATOR, findMonth(), SEPARATOR, sc.date);
    }

    private String findMonth(){

        String monthName = "";
        for (Months months: Months.values())
            if (Objects.equals(months.getMonthAsInt(), sc.month))
                monthName = months.getMonthAsString();

        return monthName;
    }

    public String getMonthAndDay() {

        return String.format("%s%s%d", findMonth(), SEPARATOR, sc.date);
    }

    public String getDay(){
        /*
        get Name of day from device and translate english name to persian name.
        */

        Date calendar = new Date();
        SimpleDateFormat JustDayofWeek = new SimpleDateFormat(Format("EEE"), Locale.ENGLISH);

        if (!super.getDate().equals("")) {
            DateFormat format = new SimpleDateFormat(Format("yyyy-MM-dd HH:mm:ss"), Locale.ENGLISH);
            try {
                calendar = format.parse(super.getDate());
            } catch (ParseException ignored) {
                throw new IllegalAccessError("is Formatted as Date really ? ");
            }
        }


        String day =  JustDayofWeek.format(calendar);
        String dayName = "";

        for (Days dayy: Days.values())
            if (Objects.equals(dayy.name(), day))
                dayName = dayy.getDay();

        return dayName;
    }

    public Generate CallBack(CallBack callBack){
        super.callBack = callBack;
        return this;

    }

    public void generateDay(){

        String date = super.Location(getDay());
        super.callBack.onReceive(date);
    }

    public void generateFullDate(){

        String date = super.Location(getCalendar());
        super.callBack.onReceive(date);
    }

    public void generateWithMonthName(){

        String date = super.Location(getWithMonthName());
        super.callBack.onReceive(date);
    }

    public void generateWithoutYear(){

        String date = super.Location(getMonthAndDay());
        super.callBack.onReceive(date);
    }


    protected class CCalendar {

        int date;
        int month;
        int year;

        protected int getDate() {
            return date;
        }


        protected void setDate(int date) {
            this.date = date;
        }

        public CCalendar()
        {
            Date MiladiDate = new Date();
            calcSolarCalendar(MiladiDate);
        }

        protected CCalendar(Date date)
        {
            calcSolarCalendar(date);
        }

        private void calcSolarCalendar(Date MiladiDate) {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(MiladiDate);
            int ld;
            int miladiYear = calendar.get(Calendar.YEAR);
            int miladiMonth = calendar.get(Calendar.MONTH) + 1;
            int miladiDate = calendar.get(Calendar.DAY_OF_MONTH);

            int[] buf1 = new int[12];
            int[] buf2 = new int[12];

            buf1[0] = 0;
            buf1[1] = 31;
            buf1[2] = 59;
            buf1[3] = 90;
            buf1[4] = 120;
            buf1[5] = 151;
            buf1[6] = 181;
            buf1[7] = 212;
            buf1[8] = 243;
            buf1[9] = 273;
            buf1[10] = 304;
            buf1[11] = 334;

            buf2[0] = 0;
            buf2[1] = 31;
            buf2[2] = 60;
            buf2[3] = 91;
            buf2[4] = 121;
            buf2[5] = 152;
            buf2[6] = 182;
            buf2[7] = 213;
            buf2[8] = 244;
            buf2[9] = 274;
            buf2[10] = 305;
            buf2[11] = 335;

            if ((miladiYear % 4) != 0) {
                date = buf1[miladiMonth - 1] + miladiDate;

                if (date > 79) {
                    date = date - 79;
                    if (date <= 186) {
                        switch (date % 31) {
                            case 0:
                                month = date / 31;
                                date = 31;
                                break;
                            default:
                                month = (date / 31) + 1;
                                date = (date % 31);
                                break;
                        }
                        year = miladiYear - 621;
                    } else {
                        date = date - 186;

                        switch (date % 30) {
                            case 0:
                                month = (date / 30) + 6;
                                date = 30;
                                break;
                            default:
                                month = (date / 30) + 7;
                                date = (date % 30);
                                break;
                        }
                        year = miladiYear - 621;
                    }
                } else {
                    if ((miladiYear > 1996) && (miladiYear % 4) == 1) {
                        ld = 11;
                    } else {
                        ld = 10;
                    }
                    date = date + ld;

                    switch (date % 30) {
                        case 0:
                            month = (date / 30) + 9;
                            date = 30;
                            break;
                        default:
                            month = (date / 30) + 10;
                            date = (date % 30);
                            break;
                    }
                    year = miladiYear - 622;
                }
            } else {
                date = buf2[miladiMonth - 1] + miladiDate;

                if (miladiYear >= 1996) {
                    ld = 79;
                } else {
                    ld = 80;
                }
                if (date > ld) {
                    date = date - ld;

                    if (date <= 186) {
                        switch (date % 31) {
                            case 0:
                                month = (date / 31);
                                date = 31;
                                break;
                            default:
                                month = (date / 31) + 1;
                                date = (date % 31);
                                break;
                        }
                        year = miladiYear - 621;
                    } else {
                        date = date - 186;

                        switch (date % 30) {
                            case 0:
                                month = (date / 30) + 6;
                                date = 30;
                                break;
                            default:
                                month = (date / 30) + 7;
                                date = (date % 30);
                                break;
                        }
                        year = miladiYear - 621;
                    }
                }

                else {
                    date = date + 10;

                    switch (date % 30) {
                        case 0:
                            month = (date / 30) + 9;
                            date = 30;
                            break;
                        default:
                            month = (date / 30) + 10;
                            date = (date % 30);
                            break;
                    }
                    year = miladiYear - 622;
                }

            }
        }

    }

}