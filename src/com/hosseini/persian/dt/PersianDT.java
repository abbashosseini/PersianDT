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
 * @since 3/8/16.
 */

public class PersianDT {

    private static PersianDT singleton;
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

    public Current Current(Object sentence){

        final String formatDate =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date());

        if (sentence instanceof String)
            return new Current(formatDate, (String) sentence);
        else
            return new Current(formatDate, "");


    }

    public Generate generate(String date, Object sentence){

        if (sentence instanceof String)
            return new Generate(date,  (String) sentence);
        else
            return new Generate(date,  "");
    }


    public AgoTime Ago(String date, Object sentence){

        if (sentence instanceof String)
            return new AgoTime(date, (String) sentence);
        else
            return new AgoTime(date, "");
    }

}
