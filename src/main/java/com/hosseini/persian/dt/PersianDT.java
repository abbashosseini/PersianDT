package com.hosseini.persian.dt;

import com.hosseini.persian.dt.PersianDate.AgoTime;
import com.hosseini.persian.dt.PersianDate.Current;
import com.hosseini.persian.dt.PersianDate.Generate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
 * @author      AbbaS Hosseini  <mrabbashosseini@gmail.com>
 * @version     0.1
 * @since       3/8/16
 */

public class PersianDT {

    private static PersianDT singleton;

    /**
     *  Do not instantiate PersianDT
     * <p>
     * we use Singleton Pattern to don't allow leak memory
     * and make sure we have ust one instance out there
     * <p>
     */
    private PersianDT() {}

    public static PersianDT Instance() {

        if (singleton == null) {
            synchronized (PersianDT.class) {
                if (singleton == null) {
                    singleton = new PersianDT();
                }
            }
        }
        return singleton;
    }

    /**
     * Builder Pattern Style
     * <p>
     *     this method will give you access to all method and api you need to
     *     return current date from device/Server/pc or ...
     *     for you of course persian date and before that make sure you
     *     have sentence or just need date and if you just need date you
     *     can pass {@code ""} as param to it
     * <p>
     * we can use this like functional Programming and more fun
     * use it like Builder pattern make devs have more fun with it
     *
     * @param  sentence
     *              accepte Object type because not every time
     *              developers need or want use date in some where
     *              in sentence mostly just need date.
     *
     * @return A Current object
     *
     * @see Current
     */
    public Current Current(Object sentence) {

        final String formatDate =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date());

        if (sentence instanceof String)
            return new Current(formatDate, (String) sentence);
        else
            return new Current(formatDate, "");


    }

    /**
     * Builder Pattern Style
     * <p>
     *     this method will give you access to all method and api you need to
     *     return Given date to persian date from device/Server/pc or ...
     *     for you of course persian date and before that make sure you
     *     have sentence or just need date and if you just need date you
     *     can pass {@code ""} as param to it
     * <p>
     * we can use this like functional Programming and more fun
     * use it like Builder pattern make devs have more fun with it
     *
     * @param  sentence
     *              accept Object type because not every time
     *              developers need or want use date in some where
     *              in sentence mostly just need date.
     * @param  date
     *              accept enlish date as string
     *
     * @return A Generate object
     *
     * @see Generate
     */

    public Generate generate(String date, Object sentence) {

        if (sentence instanceof String)
            return new Generate(date, (String) sentence);
        else
            return new Generate(date, "");
    }

    /**
     * Builder Pattern Style
     * <p>
     *     this method create Ago object and will give you access to all method
     *     and api you need for create date from your given date like <b>1 year ago</b>
     *     return Date with ago fromat from current device/Server/pc or ...
     * <p>
     * we can use this like functional Programming and more fun
     * use it like Builder pattern make devs have more fun with it
     *
     * @param  sentence
     *              accept Object type because not every time
     *              developers need or want use date in some where
     *              in sentence mostly just need date and so if you
     *              just need date you can pass {@code ""} as param to it.
     * @param  date
     *              accept enlish date as string
     *
     * @return A AgoTime object
     *
     * @see AgoTime
     */

    public AgoTime Ago(String date, Object sentence) {

        if (sentence instanceof String)
            return new AgoTime(date, (String) sentence);
        else
            return new AgoTime(date, "");
    }

}
