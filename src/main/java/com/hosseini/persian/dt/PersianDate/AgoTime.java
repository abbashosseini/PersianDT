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
 * AgoTime Class
 * <p>
 * This class provide and generate persian date in Ago format
 * like {@code //1 year ago}
 * <p>
 *
 * @author abbashosseini <mrabbashosseini@gmail.com>
 * @version 0.1
 * @see Config
 * @since 3/1/2016
 */

import com.hosseini.persian.dt.PersianDate.Iface.CallBack;
import com.hosseini.persian.dt.PersianDate.enumCollections.AgoFomat;

public final class AgoTime extends Config {

    //StateLess
    public AgoTime(String date, String sentence) {
        super(date, sentence);
    }

    /**
     * its pass date in Ago Format and String, its more readable and userfrndly
     * and  Does not support the century's
     *
     * @return A Formated date in Ago Format
     **/
    public String format() {

        long current = System.currentTimeMillis(), timestamp = getDateContaindateObject().getTime(), diff = (current - timestamp) / 1000;
        int amount;
        String what;
        String Extenion = "پیش";

        for (AgoFomat format : AgoFomat.values())
        /** check and make sure divide (/) don't be zero and don't allow
         * java.lang.ArithmeticException execption going to happen*/
            if (diff > AgoFomat.minute.getFormatNumber())
                // Check and know how to format thw date in ago
                if (diff > format.getFormatNumber()) {
                    // get digit for Ago format
                    amount = (int) (diff / format.getFormatNumber());
                    //get name (year/month/day) for Ago format
                    what = format.getFormatname();

                    if (amount == 1) {

                        if (what.equals(AgoFomat.day.getFormatname())) {
                            return "دیروز";
                        }

                    }

                    return String.format("%s %s %s", amount, what, Extenion);
                }

        amount = (int) (diff);
        return String.format("%d %s", amount, AgoFomat.Know.getFormatname());
    }


    /**
     * its pass date in Ago Format and String, its more readable and userfrndly
     * and  Does not support the century's
     *
     * @see AgoTime#format()
     * @deprecated this method has awful design .
     */
    @Deprecated
    public String dateTime() {


        long current = System.currentTimeMillis(),
                timestamp = getDateContaindateObject().getTime(),
                diff = (current - timestamp) / 1000;

        int amount = 0;
        String what = null;


        if (diff > 31536000) {
            amount = (int) (diff / 31536000);
            what = "سال";
        } else if (diff > 2592000) {
            amount = (int) (diff / 2592000);
            what = "ماه";

        } else if (diff > 604800) {
            amount = (int) (diff / 604800);
            what = "هفته";

        } else if (diff > 86400) {
            amount = (int) (diff / 86400);
            what = "روز";
        } else if (diff > 3600) {
            amount = (int) (diff / 3600);
            what = "ساعت";
        } else if (diff > 60) {
            amount = (int) (diff / 60);
            what = "دقیقه";
        } else {
            amount = (int) (diff);
            return amount + " ثانیه پیش";
        }

        if (amount == 1) {
            if (what.equals("روز")) {
                return "دیروز";
            } else if (what.equals("هفته") || what.equals("ماه") || what.equals("سال")) {
                return what + " پیش ";
            }
        }

        return String.format("%s %s %s ", amount, what, "پیش ");
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
     * @return a AgoTime object
     * @see <a href="https://github.com/abbashosseini/PersianDT/blob/master/src/com/hosseini/persian/dt/Example/ago/useitLLikeBuilderPattern.java">AgoTime Example</a>
     * @see <a href="https://github.com/abbashosseini/PersianDT/blob/master/src/com/hosseini/persian/dt/Example/current/CustomYourdate.java">Current date Example</a>
     * @see <a href="https://github.com/abbashosseini/PersianDT/blob/master/src/com/hosseini/persian/dt/Example/current/useItEasyWayLikeBuilderpattern.java">Current date Example</a>
     * @see <a href="https://github.com/abbashosseini/PersianDT/blob/master/src/com/hosseini/persian/dt/Example/generate/CustomDate.java">generate date Example</a>
     * @see <a href="https://github.com/abbashosseini/PersianDT/blob/master/src/com/hosseini/persian/dt/Example/generate/useitLikeBuilderpattern.java">Genrate Date Example</a>
     */

    public AgoTime CallBack(CallBack callBack) {
        super.callBack = callBack;
        return this;
    }

    /**
     * get date in Ago format
     **/
    public void parse() {
        String date = super.Location(format());
        super.callBack.onReceive(date);
    }

}