package com.dateparser.hosseini.persiantime.dates.PersianDate;

import android.widget.TextView;


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

public final class AgoTime extends Postion{

    public AgoTime(String date, String sentence) {
        super(date, sentence);
    }

    public String tostring() {


        final long	current = System.currentTimeMillis(),
                timestamp = getDateAsdate().getTime(),
                diff = (current - timestamp)/1000;


        int	amount;
        String	what;


        if(diff > 31536000) {
            amount = (int)(diff/31536000);
            what = "سال";
        }
        else if(diff > 2592000) {
            amount = (int)(diff/2592000);
            what = "ماه";

        }
        else if(diff > 604800) {
            amount = (int)(diff/604800);
            what = "هفته";

        }
        else if(diff > 86400) {
            amount = (int)(diff/86400);
            what = "روز";
        }
        else if(diff > 3600) {
            amount = (int)(diff/3600);
            what = "ساعت";
        }
        else if(diff > 60) {
            amount = (int)(diff/60);
            what = "دقیقه";
        }
        else {
            amount = (int)(diff);
            return amount + " ثانیه پیش";
        }

        if(amount == 1) {
            if(what.equals("روز")) {
                return "دیروز";
            }
            else if(what.equals("هفته") || what.equals("ماه") || what.equals("سال")) {
                return what+ " پیش " ;
            }
        }

        return amount + " " + what + " پیش ";
    }

    public void into(TextView element) {
        element.setText(Location(tostring()));
    }

}