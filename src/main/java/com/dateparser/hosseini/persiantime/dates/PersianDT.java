package com.dateparser.hosseini.persiantime.dates;

import com.dateparser.hosseini.persiantime.dates.PersianDate.AgoTime;
import com.dateparser.hosseini.persiantime.dates.PersianDate.Current;
import com.dateparser.hosseini.persiantime.dates.PersianDate.Generate;

import java.util.Date;

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

     public enum  Location {
        OFF
    }

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

        String localsentence;
        if (sentence instanceof String)
            localsentence = (String) sentence;
        else
            localsentence = "";

        return new Current(new Date().toString(), localsentence);
    }

    public Generate generate(String date, Object sentence){

        String localsentence;
        if (sentence instanceof String)
            localsentence = (String) sentence;
        else
            localsentence = "";

        return new Generate(date, localsentence);
    }


    public AgoTime Ago(String date, Object sentence){

        String localsentence;
        if (sentence instanceof String)
            localsentence = (String) sentence;
        else
            localsentence = "";

        return new AgoTime(date,localsentence);
    }

}
