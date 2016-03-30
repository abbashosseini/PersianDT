package com.hosseini.persian.dt.PersianDate;

import com.hosseini.persian.dt.PersianDate.Collections.Days;
import com.hosseini.persian.dt.PersianDate.Collections.Months;
import com.hosseini.persian.dt.PersianDate.Iface.CallBack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

/**
 *  This class provide Months in letters and make it more readable
 *  @author  abbashosseini
 *  @version 1.0
 *  @since   3/1/2016
 */

public final class Current extends Config {

    private final Locale loc = new Locale("en_US");
    private final Generate.CCalendar sc;
    private String SEPARATOR = " ";
    private static final String DEFAULT_FORMAT = "EEE";

    public Current(String date, String sentence) {
        super(date, sentence);
        Generate util = new Generate(super.getDate(), super.getSentence());
        sc = util.new CCalendar();
    }

    /*
    * no need for make it public we use it just parse date for DayName Method*/
    private String parse(String ft){

        ft = ft.equals("") ? DEFAULT_FORMAT : ft;

        Date date = new Date();
        SimpleDateFormat format
                = new SimpleDateFormat(ft, Locale.ENGLISH);

        try {   date = format.parse(super.getDate());  }

        catch ( ParseException ignored ) {}

        return format.format(date);
    }

    public final Current Separator(String separator){
        SEPARATOR = separator;
        return this;
    }

    public String DigitAndLetters(){
    /*
     *  and its get string date as persian not english SO you have to
     *  first get persian date like this yyyy-MM-dd then pass it
     */

        String year = String.valueOf(sc.year);
        String month = String.valueOf(sc.month);
        String day = String.valueOf(sc.date);
        String monthName = String.valueOf("");


        for (Months months: Months.values())
            if (Objects.equals(months.getMonthAsInt(), Integer.parseInt(month)))
                monthName = months.getMonthAsString();


        return String.format("%s%s%s%s%s",day, SEPARATOR, monthName, SEPARATOR, year);

    }


    public String fullDigit() {
        return String.format(
                loc,
                "%d%s%d%s%d",
                sc.year, SEPARATOR,  sc.month, SEPARATOR, sc.date);
    }

    public String dayName() {

        String day =  parse("");
        String dayName = "";

        for (Days dayy: Days.values())
            if (Objects.equals(dayy.name(), day))
                dayName = dayy.getDay();

        return dayName;
    }

    public String MonthAndDay() {

        String monthName = "";
        for (Months months: Months.values())
            if (Objects.equals(months.getMonthAsInt(), sc.month))
                monthName = months.getMonthAsString();

        return String.format(
                loc,
                "%s%s%d",
                monthName, SEPARATOR, sc.date);
    }


    public Current CallBack(CallBack callBack){
        super.callBack = callBack;
        return this;

    }

    public void WithDigit(){

        String date = super.Location(fullDigit());
        super.callBack.onReceive(date);
    }

    public void WithMonthName(){

        String date = super.Location(DigitAndLetters());
        super.callBack.onReceive(date);
    }

    public void WithoutYear(){

        String date = super.Location(MonthAndDay());
        super.callBack.onReceive(date);
    }

    public void WithDayName(){

        String date = super.Location(dayName());
        super.callBack.onReceive(date);
    }

}
