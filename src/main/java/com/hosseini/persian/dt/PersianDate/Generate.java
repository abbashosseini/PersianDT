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


/**
 * Henerate Class
 * <p>
 * This class provide generate persian date from given date and
 * you can customize your date any way you like and we make sure this
 * class threadSafe
 * <p>
 *
 * @author abbashosseini
 * @version 0.1
 * @see Config
 * @since 3/1/2016
 */


import com.hosseini.persian.dt.PersianDate.enumCollections.Days;
import com.hosseini.persian.dt.PersianDate.enumCollections.Months;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Logger;

public final class Generate extends Config {

    /**
     * mostly we use Timestamp like date format so for easy and re-using
     * we make it as Default format
     */
    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final Logger logger = Logger.getLogger(Generate.class.getSimpleName());
    private final DateFormat dateFormat;
    private CallbackHolder holder;

    /**
     * create persian date and can access it  as follow
     * {@code sc.year} and {@code sc.month} and {@code sc.date}
     * and  use it golbaly and ThreadSafe
     **/
    private final CCalender sc;

    //maybe  user dont like default SEPARATOR so can change it with Separator(param)    //
    private String SEPARATOR = " ";

    public Generate(String rawDate, String sentence) {
        super(rawDate, sentence);
        dateFormat = new SimpleDateFormat(Format(""), Locale.ENGLISH);
        Date date = null;
        try {
            date = dateFormat.parse(super.getDateContainStringObject());
        } catch (ParseException ignored) {
            logger.warning("check seem you pass date dont match the format, " +
                    "please check what date and in what foemat you are pass ing to  " +
                    "getDateContainStringObject() method in superclass (Config) ");
        }
        sc = new CCalender(date);
    }

    /*
    * no need for make it public we use it just
    * format dates just in this class for now so
    * we mka eit privaye
    * */
    private String Format(String ft) {

        return ft.equals("") ? DEFAULT_FORMAT : ft;
    }


    /**
     * change Separator if you dont like sepace between your date,  example
     * <pre>
     *     <code>
     *          //default date
     *          //1395 1 1
     *           PersianDT
     *                   .Instance()
     *                   .Current("Today {DATE} in Iran.")
     *                   .Separator(" / ")
     *                   .CallBack(new CallBack() {
     *                            public void onReceive(String date) {
     *                                               //Another way to use CallBacks
     *                                               System.out.println(date);
     *                                                  }
     *                                               })
     *                   .WithDigit();
     *
     *
     *  </code>
     * </pre>
     * <p>
     * answer will be {@code //1395 / 1 / 1}
     *
     * @param separator set your seperator you want between your dates
     * @return A Generate Class object
     */
    public final Generate Separator(String separator) {
        SEPARATOR = separator;
        return this;
    }

    /**
     * @return a formated String contain just digit
     */
    public String getWithFullDateInDigits() {
        return String.format("%d%s%d%s%d", sc.getYear().get(), SEPARATOR, sc.getMonth().get(), SEPARATOR, sc.getDate().get());
    }

    /**
     * <p>
     * this method contain year, month and day and
     * formated like 2016 tir 1
     * </p>
     *
     * @return a formated String
     */
    public String getWithMonthName() {
        return String.format("%d%s%s%s%d", sc.getYear().get(), SEPARATOR, findMonth(), SEPARATOR, sc.getDate().get());
    }

    /**
     * Getter for monthname for any mehod he need it
     *
     * @return a String
     */
    public int getJustMonthDigit() {
        return sc.getMonth().get();
    }

    public String getJustMonthName() {
        return findMonth();
    }

    private String findMonth() {

        String monthName = "";
        for (Months months : Months.values())
            if (Objects.equals(months.getMonthAsInt(), sc.getMonth().get()))
                monthName = months.getMonthAsString();

        return monthName;
    }

    /**
     * <p>
     * this getter have return value like tir 1
     * </p>
     *
     * @return a String
     */
    public String getMonthAndDay() {

        return String.format("%s%s%d", findMonth(), SEPARATOR, sc.getDate().get());
    }

    /**
     * <p>
     * this getter have return value Contain name of the day of the week
     * </p>
     *
     * @return a String
     */
    public String getDayName() {

        Date calendar = new Date();
        SimpleDateFormat JustDayofWeek = new SimpleDateFormat(Format("EEE"), Locale.ENGLISH);

        if (!super.getDateContainStringObject().equals("")) {
            DateFormat format = new SimpleDateFormat(Format("yyyy-MM-dd HH:mm:ss"), Locale.ENGLISH);
            try {
                calendar = format.parse(super.getDateContainStringObject());
            } catch (ParseException ignored) {
                throw new IllegalAccessError("is Formatted as Date really ? ");
            }
        }

        String day = JustDayofWeek.format(calendar);
        String dayName = "";

        for (Days dayy : Days.values())
            if (Objects.equals(dayy.name(), day))
                dayName = dayy.getDay();

        return dayName;
    }

    /**
     * Getter contain day of the month
     *
     * @return a int
     */
    public int getDayDigit() {

        return sc.getDate().get();
    }

    /**
     * Getter retuen just year
     *
     * @return a int
     */
    public int getYear() {
        return sc.getYear().get();
    }


    /**
     * CallBack Pattern
     * <p>
     * we use callback to get value from any where possible in PersianDT
     * and this is Asynchronous way to get date and pass it to dev/user
     * can get response and deal with it
     * and of course we add Builder Pattern how ? easy we return current
     * object so we can access it after we implement or what ever correct
     * way you are gonna use.
     * <p>
     *
     * @param callBack we have too declare callback it
     *                 how ? you can implement the
     *                 class or use lambda or method refrence
     *                 of course in java 8 or use Anonymous implement
     *                 for more you can see examples in Example folder
     * @return a Current object
     * @see <a href="https://github.com/abbashosseini/PersianDT/blob/master/src/com/hosseini/persian/dt/Example/ago/useitLLikeBuilderPattern.java">AgoTime Example</a>
     * @see <a href="https://github.com/abbashosseini/PersianDT/blob/master/src/com/hosseini/persian/dt/Example/current/CustomYourdate.java">Current date Example</a>
     * @see <a href="https://github.com/abbashosseini/PersianDT/blob/master/src/com/hosseini/persian/dt/Example/current/useItEasyWayLikeBuilderpattern.java">Current date Example</a>
     * @see <a href="https://github.com/abbashosseini/PersianDT/blob/master/src/com/hosseini/persian/dt/Example/generate/CustomDate.java">generate date Example</a>
     * @see <a href="https://github.com/abbashosseini/PersianDT/blob/master/src/com/hosseini/persian/dt/Example/generate/useitLikeBuilderpattern.java">Genrate Date Example</a>
     */

    public Generate CallBack(CallBack callBack) {
        holder = new CallbackHolder(callBack);
        return this;
    }


    /**
     * <p>
     * get date complete in Numerical
     * fill Callback with date and return reponse Asynchronously
     * </p>
     *
     * @see CallBack
     * @see CCalender
     */

    public void generateFullDate() {

        String date = super.Location(getWithFullDateInDigits());
        holder.getCallBack().onReceive(date);
    }


    /**
     * <p>
     * get date like 2016 April 1 so you can see in here we retuen
     * month name instead month number fill Callback with date and
     * return reponse Asynchronously
     * </p>
     *
     * @see CallBack
     * @see CCalender
     */
    public void generateWithMonthName() {

        String date = super.Location(getWithMonthName());
        holder.getCallBack().onReceive(date);
    }


    /**
     * <p>
     * get date complete in Numerical without year
     * fill Callback with date and return reponse
     * Asynchronously
     * </p>
     *
     * @see CallBack
     * @see CCalender
     */
    public void generateWithoutYear() {

        String date = super.Location(getMonthAndDay());
        holder.getCallBack().onReceive(date);
    }

}