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

import com.hosseini.persian.dt.PersianDate.Iface.CallBack;
import com.hosseini.persian.dt.PersianDate.Iface.FindIt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @since 3/8/16.
 */

public class Config implements FindIt {

    /**
     * CallBack Pattern
     * <p>
     * this CallBack Here can you access it from subClasses
     * no need to create one any more nedd it use it
     * <p>
     */
    CallBack callBack;


    /**
     *
     **/
    private final String dateAsString, sentence;
    private Date dateAsdate;


    Config(String date, String sentence) {
        this.dateAsString = date;
        this.sentence = sentence;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        try {
            dateAsdate = format.parse(this.dateAsString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getDateAsdate() {
        return dateAsdate;
    }

    public String getDate() {
        return dateAsString;
    }

    public String getSentence() {
        return sentence;
    }

    @Override
    public String Location(String word) {

        Pattern pattern = Pattern.compile("\\{DATE\\}");
        Matcher matcher = pattern.matcher(getSentence());

        if (matcher.find())
            return matcher.replaceAll(word);
        else
            return word;
    }
}
