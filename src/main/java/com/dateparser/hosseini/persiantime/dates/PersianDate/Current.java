package com.dateparser.hosseini.persiantime.dates.PersianDate;

import android.widget.TextView;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class Current extends Generate {

    public enum Job{
        WithDigit,
        WithLetter
    }
    public Current(String date, String sentence) {
        super(date, sentence);
    }
    
    public String withLetter(){
    /*
     *  and its get string date as persian not english SO you have to
     *  first get persian date like this yyyy-MM-dd then pass it
     */

        Pattern pattern = Pattern.compile("^(\\d{4})\\/(\\d{1,2})\\/(\\d{1,2})$");
        Matcher matcher = pattern.matcher(withDigit());

        if (!matcher.find())
            throw new IllegalAccessError("Date format is not correct !");

        String YEAR_FOR_STATUS = matcher.group(1);
        String MONTH_FOR_STATUS = matcher.group(2);
        String Display_Month_on_Status = String.valueOf("");
        String DAY_FOR_STATUS = matcher.group(3);

        switch (Integer.parseInt(MONTH_FOR_STATUS)) {
            case 1:
                Display_Month_on_Status = "فروردین";
                break;
            case 2:
                Display_Month_on_Status = "ارديبهشت";
                break;
            case 3:
                Display_Month_on_Status = "خرداد";
                break;
            case 4:
                Display_Month_on_Status = "تير";

                break;
            case 5:
                Display_Month_on_Status = "مرداد";

                break;
            case 6:
                Display_Month_on_Status = "شهريور";
                break;
            case 7:
                Display_Month_on_Status = "مهر";
                break;
            case 8:
                Display_Month_on_Status = "آبان";
                break;
            case 9:
                Display_Month_on_Status = "آذر";
                break;
            case 10:
                Display_Month_on_Status = "دي";
                break;
            case 11:
                Display_Month_on_Status = "بهمن";
                break;
            case 12:
                Display_Month_on_Status = "اسفند";
                break;
        }

        return DAY_FOR_STATUS + " " +Display_Month_on_Status + " " + YEAR_FOR_STATUS;

    }


    public String withDigit() {
        Locale loc = new Locale("en_US");
        Generate util = new Generate(super.getDate(),  super.getSentence());
        CCalendar sc = util.new CCalendar();
        return String.valueOf(sc.year) + "/" + String.format(loc, "%02d",
                sc.month) + "/" + String.format(loc, "%02d", sc.date);
    }

    public void into(TextView view,Job taskName){
        String finalSentence = null;

        switch (taskName){
            case WithDigit:
                finalSentence = super.Location(withDigit());
                break;
            case WithLetter:
                finalSentence = super.Location(withLetter());
                break;
        }

        view.setText(finalSentence);

    }



}
