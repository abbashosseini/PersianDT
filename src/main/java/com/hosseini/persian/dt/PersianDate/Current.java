package com.hosseini.persian.dt.PersianDate;

import com.hosseini.persian.dt.PersianDate.enumCollections.Days;
import com.hosseini.persian.dt.PersianDate.enumCollections.Months;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Logger;

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
 * Current Class
 * <p>
 * This class provide generate persian date directly from System and
 * you can customize your date any way you like and we make sure this
 * class threadSafe.
 * <p>
 *
 * @author abbashosseini
 * @version 0.1
 * @see Config
 * @since 3/1/2016
 */
@Deprecated
public final class Current extends Config {

    /**
     * set default format for dates its basicly now use it
     * just for return Names of the days of the week
     **/
    private static final String DEFAULT_FORMAT = "EEE";
    private final Locale loc = new Locale("en_US");
    private CallbackHolder holder;
    /**
     * create persian date and can access it  as follow
     * {@code sc.year} and {@code sc.month} and {@code sc.date}
     * and  use it golbaly and ThreadSafe
     **/
    private final CCalender sc;
    private Logger logger = Logger.getLogger(getClass().getSimpleName());
    //maybe  user dont like default SEPARATOR so can change it with Separator(param)
    private String SEPARATOR = " ";

    public Current(String date, String sentence) {
        super(date, sentence);
        sc = new CCalender();
    }


    /**
     * change Separator if you dont like sepace between your date so example
     * <pre>
     *      <code>
     *          //default date
     *          //1395 1 1
     *           PersianDT
     *                   .Instance()
     *                   .Current("Today {DATE} in Iran.")
     *                   .Separator("#")
     *                   .CallBack(new CallBack() {
     *                             public void onReceive(String date) {
     *                                               //Another way to use CallBacks
     *                                               System.out.println(date);
     *                                                  }
     *                                               })
     *                   .WithDigit();}
     *     </code>
     * </pre>
     * <p>
     * answer will be {@code //1395#1#1}
     *
     * @param separator set your seperator you want between your dates
     * @return a Current class Object
     */

    public final Current Separator(String separator) {
        SEPARATOR = separator;
        return this;
    }


    /*
     *  and its get string date as persian not english SO you have to
     *  first get persian date like this yyyy-MM-dd then pass it so
     *  first you have to execute this class and make sure constractor
     *  execute it correctly
     */
    public String DigitAndLetters() {

        //At this time we have persian date contains just numbers
        String year = String.valueOf(sc.getYear().get());
        String month = String.valueOf(sc.getMonth().get());
        String day = String.valueOf(sc.getDate().get());

        // in here we put Month name
        String monthName = String.valueOf("");


        //we use enum like collection so here we find right month to grap and retuen
        for (Months months : Months.values())
            if (Objects.equals(months.getMonthAsInt(), Integer.parseInt(month)))
                monthName = months.getMonthAsString();


        return String.format("%s%s%s%s%s", day, SEPARATOR, monthName, SEPARATOR, year);

    }

    /**
     * @return a full persian date contain just digits
     */
    public String fullDigit() {
        return String.format(
                loc,
                "%d%s%d%s%d",
                sc.getYear().get(), SEPARATOR, sc.getMonth().get(), SEPARATOR, sc.getDate().get());
    }


    /**
     * @return a day of the month
     */
    public int Day() {
        return sc.getDate().get();
    }


    /**
     * @return a name of the day of the week
     */
    public String dayName() {

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(DEFAULT_FORMAT, Locale.ENGLISH);

        try {
            date = format.parse(super.getDateContainStringObject());
        } catch (ParseException ignored) {
        }


        String day = format.format(date);
        String dayName = "";

        /**+
         * loop through all days name {@code Days.values()}
         */
        for (Days dayy : Days.values())
            if (Objects.equals(dayy.name(), day))
                dayName = dayy.getDay();

        return dayName;
    }

    /**
     * @return a month name
     */
    public String monthName() {

        String monthName = "";
        for (Months months : Months.values())
            if (Objects.equals(months.getMonthAsInt(), sc.getMonth().get()))
                monthName = months.getMonthAsString();

        return monthName;
    }

    /**
     * @return a month number
     */
    public int monthDigit() {
        return sc.getMonth().get();
    }

    /**
     * @return a year
     */
    public int Year() {
        return sc.getYear().get();
    }

    /**
     * @return a month name and day of the month
     */
    public String MonthAndDay() {

        String monthName = "";
        for (Months months : Months.values())
            if (Objects.equals(months.getMonthAsInt(), sc.getMonth().get()))
                monthName = months.getMonthAsString();

        return String.format(
                loc,
                "%s%s%d",
                monthName, SEPARATOR, sc.getDate().get());
    }


    /**
     * CallBack Pattern
     * <p>
     * we use callback to get value from any where possible in PersianDT
     * and this is Asynchronous way to get date and pass it to dev/user
     * can get resonse and deal with it
     * and of course we add Builder Pattern how ? easy we return  current
     * object so we can access it after we implement or what ever correct
     * way you are gonna use.
     * <p>
     *
     * @param callBack we have too declare callback it
     *                 how ? easy you can implement the
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

    public Current CallBack(CallBack callBack) {
        holder = new CallbackHolder(callBack);
        return this;

    }

    /**
     * get date complete in Numerical
     * fill Callback with date and return reponse Asynchronously
     */
    public void WithDigit() {

        String date = super.Location(fullDigit());
        //fill callback
        holder.getCallBack().onReceive(date);
    }


    /**
     * get full date, year and day are Numerical and Month Name instead of month number
     * fill Callback with date and return reponse Asynchronously
     */
    public void WithMonthName() {

        String date = super.Location(DigitAndLetters());
        holder.getCallBack().onReceive(date);
    }


    /**
     * get month and day Numerical
     * fill Callback with date and return reponse Asynchronously
     */
    public void WithoutYear() {

        String date = super.Location(MonthAndDay());
        holder.getCallBack().onReceive(date);
    }

}
